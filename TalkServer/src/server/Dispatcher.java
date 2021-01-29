package server;

import view.Chat;
import view.Loading;
import view.NotFound;
import view.Repeat;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Hashtable;

public class Dispatcher implements Runnable {
    private Socket client;
    private Request request;
    private Response response;
    private Hashtable<String, Chat> session;

    public Dispatcher(Socket client, Hashtable<String,Chat> session){
        this.client = client;
        this.session = session;
        request = new Request(client);
        response = new Response(client);
    }

    public void run(){
        if(request!=null&&request.getMethod().equals("GET")){
            //get请求
            if(request.getParameterValue("userName")!=null){
                //新消息请求
                String userName = request.getParameterValue("userName");
                if(session.get(userName)!=null) {
                    //有这个人
                    Chat tmp = session.get(userName);
                    if(tmp.isRefrushOrNot()){
                        response.print(tmp.toString());
                        response.pushToBrowser(200);
                    }else{
                        response.pushToBrowser(204);
                    }
                }else{
                    //没有这个人 返回404
                    response.print(new NotFound().toString());
                    response.pushToBrowser(200);
                }
            }else if(request.getUrl().equals("/")){
                //首页登录页请求
                response.print(new Loading().toString());
                response.pushToBrowser(200);
            }else{
                //404页面请求
                response.print(new NotFound().toString());
                response.pushToBrowser(200);
            }
        }else{
            //post请求
            if(request.getParameterValue("message")==null){
                //登录
                String userName = request.getParameterValue("userName");
                if(session.get(userName)==null){
                    //用户名未被占用
                    for(Chat tmp:session.values()){
                        tmp.addSystemMessage(userName+" 加入了聊天室");
                    }
                    Chat chat = new Chat(userName);
                    session.put(userName,chat);
                    response.print(chat.toString());
                    response.pushToBrowser(200);
                }else{
                    //用户名重复
                    //response.print(new Repeat().toString());
                    //response.pushToBrowser(200);
                    Chat tmp = session.get(userName);
                    response.print(tmp.toString());
                    response.pushToBrowser(200);
                }
            }else{
                //发送消息
                String message = request.getParameterValue("message");
                String userName = request.getParameterValue("userName");
                while(message.length()<userName.length()){
                    message = message+"    ";
                }
                if(session.get(userName)!=null){
                    //有这个人
                    if(message.indexOf("@")==0&&message.contains(" ")){
                        //可能是私发消息
                        String name = message.substring(1,message.indexOf(" "));
                        if(session.get(name)!=null){
                            //是私发消息
                            Chat tmp;
                            tmp = session.get(userName);
                            tmp.addSpecialMessage(userName,message);
                            response.print(tmp.toString());
                            response.pushToBrowser(200);
                            tmp = session.get(name);
                            tmp.addSpecialMessage(userName,message);
                        }else{
                            //是普通消息
                            for(Chat tmp:session.values()){
                                tmp.addMessage(userName,message);
                            }
                            Chat tmp = session.get(userName);
                            response.print(tmp.toString());
                            response.pushToBrowser(200);
                        }
                    }else{
                        //是普通消息
                        for(Chat tmp:session.values()){
                            tmp.addMessage(userName,message);
                        }
                        Chat tmp = session.get(userName);
                        response.print(tmp.toString());
                        response.pushToBrowser(200);
                    }
                }else{
                    //没有这个人 返回404
                    response.print(new NotFound().toString());
                    response.pushToBrowser(200);
                }
            }

        }
    }
}

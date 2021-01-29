package server;

import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.util.Date;

//响应
public class Response {
    private BufferedWriter bw;
    //协议头信息
    private StringBuilder headInfo;
    //正文
    private StringBuilder content;
    private int len;
    //常量
    private final String BLANK = " ";
    private final String CRLF = "\r\n";
    private Socket client;

    public Response(Socket client){
        try {
            content = new StringBuilder();
            headInfo = new StringBuilder();
            len = 0;
            bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            this.client = client;
        }catch (IOException e){
            e.printStackTrace();
            headInfo = null;
        }
    }

    //动态添加内容
    public Response print(String info){
        content.append(info);
        len += info.getBytes().length;
        return this;
    }
    public Response println(String info){
        content.append(info).append(CRLF);
        len += (info+CRLF).getBytes().length;
        return this;
    }

    public void pushToBrowser(int code){
        if(null == headInfo){
            code = 505;
        }
        createHeadInfo(code);
        try {
            bw.append(headInfo);
            bw.append(content);
            bw.flush();
            bw.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端错误");
        }
    }

    //构建头信息
    private void createHeadInfo(int code){
        //响应行
        headInfo.append("HTTP/1.1").append(BLANK);
        headInfo.append(code).append(BLANK);
        switch (code){
            case 200:
                headInfo.append("OK").append(CRLF);
                break;
            case 404:
                headInfo.append("NOT FOUND").append(CRLF);
                break;
            case 204:
                headInfo.append("No Content").append(CRLF);
            case 505:
                headInfo.append("SERVER ERROR").append(CRLF);
                break;
        }
        //响应头（最后一行有空行）
        headInfo.append("Date:").append(new Date()).append(CRLF);
        headInfo.append("Server:").append("dhh Server/0.0.1;charset=GBK").append(CRLF);
        headInfo.append("Content-type:text.html").append(CRLF);
        headInfo.append("Content-length:").append(len).append(CRLF);
        headInfo.append(CRLF);
    }


}

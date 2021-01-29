package server;

import view.Chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Hashtable;

public class Server {
    private ServerSocket serverSocket;
    private boolean isRunning;
    private Hashtable<String, Chat> session;
    public static void main(String[] args){
        Server server = new Server();
        server.start();
    }

    //启动服务
    public void start(){
        try{
            serverSocket = new ServerSocket(80);
            session = new Hashtable<String, Chat>();
            isRunning = true;
            receive();
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("服务器启动失败。。。");
            stop();
        }
    }

    public void receive(){
        while(isRunning){
            try{
                Socket client = serverSocket.accept();
                System.out.println("一个客户端建立了连接。。。");
                new Thread(new Dispatcher(client,session)).start();
            }catch (IOException e){
                e.printStackTrace();
                System.out.println("客户端错误");
            }
        }
    }

    //停止服务
    public void stop(){
        isRunning = false;
        try{
            this.serverSocket.close();
            System.out.println("服务器已停止");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}

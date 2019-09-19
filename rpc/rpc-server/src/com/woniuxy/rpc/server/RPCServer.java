package com.woniuxy.rpc.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class RPCServer {
    private static final int DEFAULT_PORT = 10086;

    public static void main(String[] args) {
        System.out.println("RPCServer ==> 启动服务，监听端口：" + DEFAULT_PORT);
        BufferedReader br = null;
        ServerSocket ss = null;
        Socket socket = null;
        PrintWriter pw = null;
        try {
            ss = new ServerSocket(DEFAULT_PORT);
            socket = ss.accept();
            System.out.println("RPCServer ==> 收到请求...");
            //从请求中获取参数
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = null;
            StringBuilder paramBuilder = new StringBuilder();
            while ((line = br.readLine()) != null) {
                paramBuilder.append(line);
            }
            System.out.println("RPCServer ==>请求参数为："+paramBuilder.toString());

            //反序列化，将String转换为特定类型,这里因为目标类型也是String，因此操作较为简单
            String[] paramArr = paramBuilder.toString().split("#");
            if("java.lang.String".equals(paramArr[1])){
                //调用本地方法，得到结果
                int result = new RatingServiceImpl().rate(paramArr[0]);
                //写回信息
                pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                String returnMessage = ""+result;
                System.out.println("RPCServer ==>写回数据 "+returnMessage);
                pw.write(returnMessage);
                pw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
                try {
                    if(ss!=null){
                        ss.close();
                    }
                    if(socket!=null){
                        socket.close();
                    }
                    if(br!=null){
                        br.close();
                    }
                    if(pw!=null){
                        pw.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
    }
}

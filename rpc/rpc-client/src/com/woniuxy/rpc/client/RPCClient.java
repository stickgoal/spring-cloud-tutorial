package com.woniuxy.rpc.client;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class RPCClient {
    /**
     * 模拟服务注册表
     */
    private static final Map<String, String> SERVICE_ADDRESS_MAP = new HashMap<>();

    private static final int DEFAULT_PORT = 10086;

    static {
        //模拟注册服务地址
        SERVICE_ADDRESS_MAP.put("ratingService", "127.0.0.1");
    }

    /**
     * 远程调用指定服务
     *
     * @param serviceName
     * @return
     */
    public <T> Object execute(String serviceName, Class<T> resultClass, Object param) {
        //通过map模拟寻址过程
        String address = SERVICE_ADDRESS_MAP.get(serviceName);
        PrintWriter writer = null;
        try {
            System.out.println("RPCClient==>请求");
            //通过Socket链接远程服务
            Socket socket = new Socket(address, DEFAULT_PORT);
            //传输参数
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            //序列化操作，目前只支持一个参数
            writer.write(param.toString());
            //# 分隔参数类型
            writer.write("#" + param.getClass().getName());
            writer.flush();
            socket.shutdownOutput();

            //反序列化操作
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = null;
            StringBuilder resultBuilder = new StringBuilder();
            while ((line = br.readLine()) != null) {
                resultBuilder.append(line);
            }
            System.out.println("响应结果："+resultBuilder.toString());
            //简单处理，目前只处理int型
            if (resultClass == Integer.class) {
                return Integer.parseInt(resultBuilder.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
        return null;
    }

    /**
     * 反序列化操作
     *
     * @param resultString
     * @param resultClass
     * @param <T>
     * @return
     */
    private <T> Object deserialize(String resultString, Class<T> resultClass) {
        //简单处理，目前只处理int型
        if (resultClass == Integer.class) {
            return Integer.parseInt(resultString);
        }

        return null;
    }

}

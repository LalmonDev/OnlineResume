package com.lalmondev.online_resume.util;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class RuntimeTool {
    public Boolean CMDTool(String command,String filePath){
        File dirPath = new File(filePath);
        String[] cmd={"cmd","/C",command};

        System.out.println("CMD命令："+command);
        System.out.println("命令执行目录："+filePath);

        try {
            Process process;
            process = Runtime.getRuntime().exec(cmd,null,dirPath);

            //获取进程输入流
            final InputStream inputStream = process.getInputStream();
            //获取进程错误流
            final InputStream errorStream = process.getErrorStream();

            //启动两个线程，一个线程负责读标准输出流，另一个负责读标准错误流
            new Thread() {
                public void run() {
                    BufferedReader br1 = new BufferedReader(new InputStreamReader(inputStream));
                    try {
                        String line1 = null;
                        while ((line1 = br1.readLine()) != null) {
                            if (line1 != null){}
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    finally{
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();

            new Thread() {
                public void  run() {
                    BufferedReader br2 = new  BufferedReader(new  InputStreamReader(errorStream));
                    try {
                        String line2 = null ;
                        while ((line2 = br2.readLine()) !=  null ) {
                            if (line2 != null){}
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    finally{
                        try {
                            errorStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();

            int exitVal = process.waitFor();
            System.out.println("Process exitValue: " + exitVal);

        }catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
            return false;
        }

        System.out.println("执行 " + command +" 完毕！");
        return true;
    }
}

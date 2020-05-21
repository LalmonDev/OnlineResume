package com.lalmondev.online_resume.util;

import java.io.*;

public class RuntimeTool {
    public static Boolean creatResumeByFilePath(String command,String filePath){
        File dirPath = new File(filePath);
        String[] cmd={"cmd","/C",command};
        Process process;

        try {
            process = Runtime.getRuntime().exec(cmd,null,dirPath);
            //取得命令结果的输出流
            InputStream inputStream = process.getInputStream();
            //用一个读输出流类去读
            InputStreamReader streamReader = new InputStreamReader(inputStream);
            //用缓冲器读行
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            String line = null;
            //直到读完为止
            while((line = bufferedReader.readLine()) != null)
            {
                System.out.println(line);
            }
            //关闭相应进程
            bufferedReader.close();
            streamReader.close();
            inputStream.close();
        }catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}

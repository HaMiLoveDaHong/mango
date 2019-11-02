package com.louis.mango.common.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 文件相关操作
 * @quthor haMi
 * @date2019/11/2
 */
public class FileUtils {
    public static final String CONTENTYPE ="Content-Disposition";

    /**
     * 下载文件
     * @param respone
     * @param file
     * @param newFileName
     */
    public static void downloadFile(HttpServletResponse respone,File file,String newFileName){
        try{
            respone.setHeader(CONTENTYPE,"attachment; filename="+new String(newFileName.getBytes("ISO-8859-1"),"UTF-8"));
            BufferedOutputStream bos = new BufferedOutputStream(respone.getOutputStream());
            InputStream is = new FileInputStream(file.getAbsoluteFile());
            BufferedInputStream bis = new BufferedInputStream(is);
            int length = 0;
            byte[] temp = new byte[1 * 1024 * 10];
            while ((length = bis.read(temp))!= -1){
                bos.write(temp,0,length);
            }
            bos.flush();
            bis.close();
            bos.close();
            is.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

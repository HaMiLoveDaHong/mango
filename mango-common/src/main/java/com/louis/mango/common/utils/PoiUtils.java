package com.louis.mango.common.utils;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * POI 相关操作
 * @quthor haMi
 * @date2019/11/2
 */
public class PoiUtils {

    public static File createExcelFile(Workbook workbook,String fileName){
        OutputStream stream = null;
        File file = null;
        try {
            file = File.createTempFile(fileName,".xlsx");
            stream = new FileOutputStream(file.getAbsoluteFile());
            workbook.write(stream);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            IOUtils.closeQuietly(workbook);
            IOUtils.closeQuietly(stream);
        }
        return  file;
    }
}

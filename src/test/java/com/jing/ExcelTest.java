package com.jing;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;
import org.junit.Test;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ExcelTest {

    @Test
    public void createExcel(){
        Workbook wb = new HSSFWorkbook();  // or new XSSFWorkbook();
        Sheet sheet1 = wb.createSheet("new sheet");
        Sheet sheet2 = wb.createSheet("second sheet");

        // Note that sheet name is Excel must not exceed 31 characters
        // and must not contain any of the any of the following characters:
        // 0x0000
        // 0x0003
        // colon (:)
        // backslash (\)
        // asterisk (*)
        // question mark (?)
        // forward slash (/)
        // opening square bracket ([)
        // closing square bracket (])

        // You can use org.apache.poi.ss.util.WorkbookUtil#createSafeSheetName(String nameProposal)}
        // for a safe way to create valid names, this utility replaces invalid characters with a space (' ')
        String safeName = WorkbookUtil.createSafeSheetName("[O'Brien's sales*?]"); // returns " O'Brien's sales   "
        Sheet sheet3 = wb.createSheet(safeName);

        try (OutputStream fileOut = new FileOutputStream("workbook.xls")) {
            wb.write(fileOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void mulu() {
        File[] roots = File.listRoots();

        System.out.println("系统所有根目录：");

        for (int i = 0; i < roots.length; i++) {

            System.out.println(roots[i].toString());
        }

        System.out.println(File.separator);
    }

    @Test
    public void newdate(){
//        try {
//            System.out.println(1/0);
//        } catch (Exception e) {
//            System.out.println(e.getLocalizedMessage());
//            System.out.println(e.getMessage());
//            System.out.println(e.getCause());
//            System.out.println(e.getSuppressed());
//        }
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Calendar ca = Calendar.getInstance();
        System.out.println(ca.getTime());
        String last = format.format(ca.getTime());
        System.out.println(ca.getTime()+"=="+ca.get(Calendar.DATE)+"==="+Calendar.getInstance().getTime());
        System.out.println(last);

    }


    @Test
    public void stringtest(){
//        String i="LC44BKRN-a0-23";
//        System.out.println(i.indexOf("a01"));
//        System.out.println();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(1531821338892l-86400000*(24+1));
        System.out.println(sdf.format(1531821338892l-86400000*24+1));
//        System.out.println(StringUtils.substringAfterLast(i, "-"));
//        int a=0;l
//        try {
//            a=Integer.parseInt(StringUtils.substringAfterLast(i, "-"));
//        } catch (NumberFormatException e) {
//            a=1;
//        }
//        System.out.println(a);
    }

    @Test
    public void testdate()throws Exception{
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date dt = sdf.parse("2018-07-17 04:03:20");

//        rightNow.setTime(dt);
//        rightNow.add(Calendar.DATE, -1);
//        rightNow.add(Calendar.DATE, -1);
//        Date dt1 = rightNow.getTime();
//        String reStr = sdf.format(dt1);
//        System.out.println(reStr);
        List<String> resultList=new ArrayList<>();
        ergodic(new File("https://www.soxtu.com/upload/photos/tu/"), resultList);
    }


    private List<String> ergodic(File file, List<String> resultFileName){
        File[] files = file.listFiles();
        if(files==null)return resultFileName;// 判断目录下是不是空的
        for (File f : files) {
            if(f.isDirectory()){// 判断是否文件夹
                resultFileName.add(f.getPath());
                ergodic(f,resultFileName);// 调用自身,查找子目录
            }else
                resultFileName.add(f.getPath());
        }
        return resultFileName;
    }


}

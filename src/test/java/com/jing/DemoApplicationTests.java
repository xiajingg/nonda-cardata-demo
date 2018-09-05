package com.jing;


import nonda.cardata.DemoApplication;
import nonda.cardata.service.IReportsService;
import nonda.cardata.util.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

    @Autowired
    private IReportsService iReportsService;


	@Test
	public void contextLoads()throws Exception {
        String newdateString="2018-08-13 23:59";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date newdate=sdf.parse(newdateString);
        System.out.println((new Date().getTime()-newdate.getTime())/1000/60/60/24<90);
	}


    /**
     * 删除文件
     */
	@Test
    public void users(){
        System.out.println(FileUtils.deleteFile("workbook.xls"));

    }



    @Test
    public void shuchu(){

	    char a='a';
	    char b=98;
        System.out.println((int)a);
        System.out.println(b);

        int c=2;
        System.out.println(StringUtils.leftPad(c+"", 3,"0"));

//        Tire tire=new Tire();
//        System.out.println(tire.getPos());
//        for (int i = 0; i < 7; i++) {
//            System.out.println();
//        }
    }

}

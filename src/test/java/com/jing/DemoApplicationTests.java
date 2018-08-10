package com.jing;


import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import javafx.scene.input.DataFormat;
import nonda.cardata.DemoApplication;
import nonda.cardata.controller.UUIDHelper;
import nonda.cardata.model.Reports;
import nonda.cardata.model.Tire;
import nonda.cardata.model.User;
import nonda.cardata.model.dao.IReportsDao;
import nonda.cardata.service.IReportsService;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

    @Autowired
    private IReportsService iReportsService;


	@Test
	public void contextLoads() {
//        Reports reports=new Reports();
//        reports.setId(UUIDHelper.getUUID32());
//        reports.setPostedDate("Jul 19, 2018 12:17:16 AM PDT");
//        iReportsService.save(reports);
        System.out.println(new Date("Jul 19, 2018 12:17:16 AM PDT"));
        System.out.println("mRdy6LIQYNXcdwKKlLu5HdOlg".length());
//        System.out.println(UUID.randomUUID().toString().length());
	}


	@Test
    public void users(){
        User user =new User(UUIDHelper.getUUID32(),UUIDHelper.getUUID32(),0.00);

        System.out.println(user.get_id());
        System.out.println(user.getUsername());

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

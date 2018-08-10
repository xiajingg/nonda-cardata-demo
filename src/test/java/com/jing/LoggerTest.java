package com.jing;

import hirondelle.date4j.DateTime;
import net.sf.json.JSONObject;
import nonda.cardata.DemoApplication;
import nonda.cardata.model.MongoUser;
import nonda.cardata.model.User;
import nonda.cardata.service.impl.MongoUserServiceImpl;
import nonda.cardata.service.impl.UserServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.aspectj.weaver.ast.Var;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.util.calendar.BaseCalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by xiajing on 2018/4/12.
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = DemoApplication.class)
public class LoggerTest {

    private final Logger logger= LoggerFactory.getLogger(LoggerTest.class);

    @Autowired
    private MongoUserServiceImpl mongoUserService;
    @Autowired
    private UserServiceImpl userService;

    @Test
    public void test1(){
        System.out.println(1);
        logger.info("info......");
        System.out.println(UUID.randomUUID().toString());
    }

    @Test
    public void test2(){
        MongoUser mongoUser= mongoUserService.findByusername("qinyu123@sjtu.edu.cn");
        JSONObject jsonObject=JSONObject.fromObject(mongoUser.getConfig());
        System.out.println(jsonObject.getString("car_finder_distance_unit"));

    }

    @Test
    public void test3(){
//        User user=new User();
//        user.set_id("1");
//        user.setUsername("xiajing");
//        user.setNu(15.12345678901234567);
//        userService.createUser(user);

        SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date("2018-06-07 00:00:00");
        System.out.println(format.format(date));
    }

    @Test
    public void timeCalculator(){
        SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format1= new SimpleDateFormat("HH:mm");
        try {
            Date date=format.parse("2001-01-01 00:00:00");
            String dateformat=format.format(new Date());
            System.out.println("date:"+dateformat);
            long s=1529769600000l;
            Date date1=format.parse("2018-01-01 00:00:00");
            if (date.getTime()>date1.getTime()){
                System.out.println("第一个时间比较大");
            }else if (date.getTime()==date1.getTime()){
                System.out.println("两个时间相等");
            }else {
                System.out.println("第二个时间比较大");
            }
            System.out.println("date1转换为时间戳是: "+date1.getTime());
            System.out.println("时间戳转换为时间格式为:"+format1.format(s));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date date=new Date();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date date1=new Date();
        System.out.println();

        String a = new String("a");
        String b = new String("a");
        if (a.equals(b)){
            System.out.println(1);
        }else {
            System.out.println(2);
        }

    }


    @Test
    public void shuxue(){

        try {
            System.out.println(1/0);
        } catch (Exception e) {
            System.err.println("0");

            try {
                System.out.println(1/0);
            } catch (Exception e1) {
                return;
            }finally {
                System.out.println(2);
            }

        } finally {
            System.out.println(1);
        }

    }

    @Test
    public void chaxunshijian(){

        int past=0;
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
            Date today = calendar.getTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String result = format.format(today);
        System.out.println(result);

    }

    @Test
    public void stringlength(){
        String a="203-2172297-1323517";
        System.out.println(a.length());

        String b="";
        System.out.println(Double.parseDouble(b));
        List<Double> list=new ArrayList<>();


    }



    @Test
    public void jisuan(){
        float a;
        a=(float)(12.99+2.33-1.81-2.26-5.85-2.33+25.98+4.66-3.62-2.26-4.66);
        System.out.println(a);
    }

    @Test
    public void substring(){
        String a=null;
//        System.out.println(StringUtils.substringAfter(a, "."));
//        System.out.println(StringUtils.substringBefore(a, "."));
        System.out.println(a==null?1:2);
        for (int i = 0; i < 10; i++) {
            boolean b=true;
            for (int j = 0; j < 1; j++) {
                b=false;
            }
            if (b) {
                System.out.println(1);
            }

        }

        System.out.println("结束");
    }


    @Test
    public void xmldown(){
        System.out.println("分期费用=>"+(4926.48*11+9025.82-12000));
        System.out.println("季付=>"+(13170*3+21774-12000));
//        try {
//            System.out.println(1/0);
//        } catch (Exception e) {
//            System.out.println("111");
//        }
//        System.out.println("ok");
//
//        SimpleDateFormat format=new SimpleDateFormat("MM");
//        String dateString=format.format(new Date());
//        if (dateString.equals("01")||dateString.equals("02")||dateString.equals("03")){
//            System.out.println("Q1");
//        }else if (dateString.equals("04")||dateString.equals("05")||dateString.equals("06")){
//            System.out.println("Q2");
//        }else if (dateString.equals("07")||dateString.equals("08")||dateString.equals("09")){
//            System.out.println("Q3");
//        }else if (dateString.equals("10")||dateString.equals("11")||dateString.equals("12")){
//            System.out.println("Q4");
//        }else {
//            System.out.println("错误");
//        }
        String s="Micro Center\nP.O. Box 910\nMicro Center #00001";
        System.out.println(StringUtils.substringBefore(s, "\n"));
    }

    @Test
    public void continuetest(){
        for (int i = 0; i < 10; i++) {
            if (i%2==0){
                continue;
            }
            System.out.println(i);
        }

        System.out.println("贵=>"+4390*12);
        System.out.println("便宜=>"+1890*12);
    }


    @Test
    public void a2(){
        System.out.println(1);
        a:do {
            System.out.println(2);

            for (int i = 0; i < 10; i++) {
                System.out.println(3);
                break a;
            }

        }while(true);
        System.out.println(4);
    }

    @Test
    public void a1(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //美国  Jul 30, 2018 12:30:00 AM PDT
        try {
            System.out.println(new Date("Jul 30, 2018 12:30:00 AM"));
        } catch (Exception e) {
            System.err.println("美国时间转换错误");
        }

        //加拿大 2018-07-30 1:20:28 AM PDT
        try {
            DateTime dateTime=new DateTime("2018-07-30 1:20:28 AM");
            System.out.println(sdf.parse(dateTime.toString()));
        } catch (Exception e) {
            System.err.println("加拿大时间转换错误");
        }

        //英国 2 Jan 2018 09:16:41 GMT+00:00
        try {
            DateTime dateTime=new DateTime("2 Jan 2018 09:16:41");
//            System.out.println(dateTime.getDay()+" "+dateTime.getHour()+":"+dateTime.getMinute());
//            System.out.println(sdf.parse(dateTime.toString()));
            System.out.println(new Date("2 Jan 2018 09:16:41"));
        } catch (Exception e) {
            System.err.println("英国时间转换错误");
            e.printStackTrace();
        }

        //日本 2018/02/06 12:46:55JST
        try {
            DateTime dateTime=new DateTime("2018/02/06 12:46:55");
            System.out.println(new Date("2018/02/06 12:46:55"));

        } catch (Exception e) {
            System.err.println("日本时间转换错误");
            e.printStackTrace();
        }


    }


    @Test
    public void a3(){
//        System.out.println("2 Jan 2018 09:16:41 GMT+00:00".indexOf("GMT"));
//        System.out.println(StringUtils.substringBeforeLast("2 Jan 2018 09:16:41 GMT+00:00","GMT" ));
        // 2018-01-02 1:17:59 PM PST
        System.out.println(new Date(StringUtils.replace(StringUtils.substringBeforeLast("2018-07-30 10:59:27 PM PDT", "PDT"), "-", "/")));
    }
}

package nonda.cardata.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@EnableScheduling
public class TestTaks {



    @Scheduled(cron = "1 * 9 * * ?")
    public void test1(){
        System.out.println("1秒一个的"+new Date());
    }



    @Scheduled(cron = "5 * 9 * * ?")
    public void test2(){
        System.out.println("5秒一个"+new Date());
    }


    @Scheduled(cron = "30 * * * * ?")
    public void test3(){
        System.out.println("到30s一个"+new Date());
    }
}

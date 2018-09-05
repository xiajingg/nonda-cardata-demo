package nonda.cardata.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@EnableScheduling
public class TestTaks {



//    @Scheduled(cron = "1 * 9 * * ?")
//    public void test1(){
//        System.out.println("1秒一个的"+new Date());
//    }
//
//
//
//    @Scheduled(cron = "5 * 9 * * ?")
//    public void test2(){
//        System.out.println("5秒一个"+new Date());
//    }


//    @Scheduled(cron = "0 * * * * ?")
    public void test3(){
        new Thread(new Runnable() {
            public void run() {
                for (int i=0;i<=1000;i++){
                    try {
                        System.out.println(i);
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

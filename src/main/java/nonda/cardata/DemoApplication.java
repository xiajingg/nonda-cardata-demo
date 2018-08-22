package nonda.cardata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 运行主类， 点左边的那个三角箭头 项目就跑起来了
 */
//@ComponentScan("nonda.cardata")
//扫描包
@SpringBootApplication(scanBasePackages = "nonda.cardata",exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
//开启定时器功能
@EnableScheduling
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("run ok");
	}
}

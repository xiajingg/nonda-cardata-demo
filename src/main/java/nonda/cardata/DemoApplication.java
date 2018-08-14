package nonda.cardata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 运行主类， 点左边的那个三角箭头 项目就跑起来了
 */
//@ComponentScan("nonda.cardata")
@SpringBootApplication(scanBasePackages = "nonda.cardata")
@EnableScheduling
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("run ok");
	}
}

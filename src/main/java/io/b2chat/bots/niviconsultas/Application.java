package io.b2chat.bots.niviconsultas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.vertical.bot.app.BotCoreService;

@SpringBootApplication
@EnableConfigurationProperties
@EnableAsync
@EnableScheduling
@ComponentScan(basePackages={"io.b2chat.bots.niviconsultas"})
@Import({BotCoreService.class})
public class Application {
	
	public static void main(String[] args) {
		BotLogger.debug(Application.class, "Application.main");
		ApplicationContext context = SpringApplication.run(new Object[] { Application.class }, args);
		context.getBean(BotCoreService.class).run();
	}
	
}
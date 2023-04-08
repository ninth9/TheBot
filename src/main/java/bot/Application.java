package bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@LineMessageHandler
@Log4j2
public class Application {
	public static void main(String... args) {
		SpringApplication.run(Application.class, args);
	}

	@EventMapping
	public Message handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
		log.info("event: {}", event);
		final String originalMessageText = event.getMessage().getText();
		return new TextMessage(originalMessageText);
	}

	@EventMapping
	public void handleDefaultMessageEvent(Event event) {
		log.info("event: {}", event);
	}
}

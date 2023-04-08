package bot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@Data
public class BotController {
	@GetMapping("/")
	public String index() {
		return "HelloWorld";
	}
}

package io.dagistan.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.dagistan.model.MessageModel;
import io.dagistan.service.RedisService;

@RestController
@RequestMapping("/api")
public class Service {

	@Autowired
	private RedisService redisService;

	@PostMapping("/message")
	public String saveMessage(@Valid @RequestBody MessageModel message) {
		redisService.addMessage(message);
		return "OK";
	}

	@GetMapping(value = "/message/{listId}")
	public List<String> getMessagesByListId(@PathVariable("listId") String listId) {
		List<String> messages = redisService.listMessageByListId(listId);
		return messages;
	}

}

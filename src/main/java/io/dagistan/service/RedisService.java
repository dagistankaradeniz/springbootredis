package io.dagistan.service;

import java.util.List;

import io.dagistan.model.MessageModel;

public interface RedisService {

	public void addMessage(MessageModel message);

	public List<String> listMessageByListId(String listId);

}

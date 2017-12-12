package io.dagistan.service;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.stereotype.Service;

import io.dagistan.model.MessageModel;

@Service("redisService")
public class RedisServiceImpl implements RedisService {

	// for moredetailed explanation of RedisTemplate please visit link below
	// https://docs.spring.io/spring-data/redis/docs/2.0.x/reference/html/#redis:template

	// inject the template as ListOperations
    // can also inject as Value, Set, ZSet, and HashOperations
	// https://projects.spring.io/spring-data-redis/
	@Resource(name = "redisTemplate")
	private ListOperations<String, String> redisList;
	
	// lots of redis operations are inside RedisOperations
	@Resource(name = "redisTemplate")
	private RedisOperations<String, MessageModel> latestMessageOperation;

	@Override
	public void addMessage(MessageModel message) {
		
		
		redisList.leftPush(message.getId(), message.getDetail());
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		Date date = Date.from(zonedDateTime.plus(1, ChronoUnit.MINUTES).toInstant());
		latestMessageOperation.expireAt(message.getId(), date); // 1 minute life is set :)
	}

	@Override
	public List<String> listMessageByListId(String listId) {
		return redisList.range(listId, 0, -1); // return all items in a list by given listId
	}

}

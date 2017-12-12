# Run Steps

This is a [SpringBoot](https://projects.spring.io/spring-boot/) application using [Redis](https://redis.io/) as cache. 

Redis is briefly *"an open source (BSD licensed), in-memory data structure store, used as a database, cache and message broker. It supports data structures such as strings, hashes, lists, sets, sorted sets with range queries, bitmaps, hyperloglogs and geospatial indexes with radius queries. Redis has built-in replication, Lua scripting, LRU eviction, transactions and different levels of on-disk persistence, and provides high availability via Redis Sentinel and automatic partitioning with Redis Cluster"* ( yeah, that is a brief :smile: )

[Download and install](https://redis.io/download) Redis. Redis will start using **6379** port.

## RedisConfig.java

That is a Redis Configuration file that enables **@Configuration** and **@EnableCaching**. **JedisConnectionFactory** is enough to connect to Redis server. Redis connection values are set inside **application.properties** file.

## Test

Use your favorite Rest client to add or list messages you post to Redis.

> **Note:**
>
> You can use a Redis desktop client. [FastoRedis](https://fastoredis.com/) and [Redis Desktop Manager](https://redisdesktop.com/) can be used.
> Connection parameters are set as default in each gui above. If you didn't changed defaults. (host:localhost, port:6379)

Good Luck :wink:

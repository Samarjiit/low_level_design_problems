package Feeds;

import models.Post;
import services.RedisClient;

import java.util.Set;

public class PushFanoutStrategy implements FanoutStrategy{
    private final RedisClient redis=RedisClient.getInstance();

    @Override
    public void fanout(Post post, Set<String> followers) {
        for (String followerId : followers) {
            redis.zadd("feed:" + followerId, post.getCreatedAt().getTime(),post.getId());
        }
        System.out.println("📤 Fanout PUSH to " + followers.size() + " users.");
    }

}


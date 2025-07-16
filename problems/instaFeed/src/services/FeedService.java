package services;

import Feeds.FanoutStrategy;
import Feeds.PullFanoutStrategy;
import Feeds.PushFanoutStrategy;
import models.Post;
import models.User;

import java.util.List;
import java.util.Set;

public class FeedService {
    private final RedisClient redis=RedisClient.getInstance();

    public void distribute(Post post){
        User user=UserService.getInstance().getUser(post.getUserId());
        Set<String> followers=user.getFollowers();


        FanoutStrategy strategy=(followers.size()<100000)?new PushFanoutStrategy() :new PullFanoutStrategy();
        strategy.fanout(post,followers);
    }

    public List<String> getFeed(String userId, int limit){
        return redis.zrange("feed:" + userId,limit);
    }
}

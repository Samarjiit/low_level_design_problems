package Feeds;

import models.Post;

import java.util.Set;

public interface FanoutStrategy {
    void fanout(Post post, Set<String> followers);
}

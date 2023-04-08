package org.example.repository;

import org.example.model.GetPost;
import org.example.model.Post;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PostRepository {
    private final Map<Long, Post> posts = new ConcurrentHashMap<>();
    private final AtomicLong counter = new AtomicLong(0);

    public List<GetPost> all() {
        List<GetPost> list = new ArrayList<>();
        for (Post post : posts.values()) {
            if (post.checkRemove()) {
                list.add(new GetPost(post.getId(), post.getContent()));
            }
        }
        return list;
    }

    public Optional<GetPost> getById(GetPost post) {
        if (posts.containsKey(post.getId()) && posts.get(post.getId()).checkRemove()) {
            posts.put(post.getId(), new Post(post.getId(), post.getContent()));
            return Optional.of(post);
        }
        return Optional.empty();
    }

    public GetPost save(GetPost post) {
        if (post.getId() == 0 && post.getContent() != null) {
            counter.getAndIncrement();
            post.setId(counter.get());
            posts.put(counter.get(), new Post(post.getId(), post.getContent()));
            return post;
        }
        return new GetPost(0, null);
    }

    public boolean removeById(long id) {
        if (!posts.containsKey(id)) {
            return false;
        }
        posts.get(id).setRemove(false);
        return true;
    }
}

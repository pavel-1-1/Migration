package org.example.service;

import org.example.model.GetPost;
import org.example.repository.PostRepository;
import org.example.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<GetPost> all() {
        return repository.all();
    }

    public GetPost getById(GetPost post) {
        return repository.getById(post).orElseThrow(NotFoundException::new);
    }

    public GetPost save(GetPost post) {
        return repository.save(post);
    }

    public boolean removeById(long id) {
        return repository.removeById(id);
    }
}

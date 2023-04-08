package org.example.controller;

import org.example.model.GetPost;
import org.example.model.Post;
import org.example.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PostController {
    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("/read")
    public List<GetPost> all() {
        return service.all();
    }

    @PostMapping("/update")
    public GetPost getById(@RequestBody GetPost post) {
        return service.getById(post);
    }

    @PostMapping("/create")
    public GetPost save(@RequestBody GetPost post) {
        return service.save(post);
    }

    @DeleteMapping("/delete")
    public void removeById(@RequestBody GetPost post) {
        service.removeById(post.getId());
    }
}

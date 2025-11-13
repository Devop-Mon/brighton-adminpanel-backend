package com.adminpanel.controller;

import com.adminpanel.payload.PostDto;
import com.adminpanel.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notice") // Base URL for all post-related APIs
@CrossOrigin(origins = "*")   // Allows frontend access (you can restrict later)
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 🟢 Admin creates a post
    @PostMapping
    public PostDto createPost(@RequestBody PostDto postDto) {
        return postService.createPost(postDto);
    }

    // 🔵 Everyone can view all posts
    @GetMapping
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    }
}

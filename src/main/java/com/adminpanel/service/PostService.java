package com.adminpanel.service;

import com.adminpanel.payload.PostDto;
import java.util.List;

public interface PostService {

    // 🟢 Admin creates a post
    PostDto createPost(PostDto postDto);

    // 🔵 Everyone can view posts
    List<PostDto> getAllPosts();
}

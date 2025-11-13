package com.adminpanel.service.impl;

import com.adminpanel.entity.Post;
import com.adminpanel.payload.PostDto;
import com.adminpanel.repository.PostRepository;
import com.adminpanel.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // Admin creates a post
    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = new Post();
        post.setNotice(postDto.getNotice());

        Post savedPost = postRepository.save(post);

        PostDto response = new PostDto();
        response.setId(savedPost.getId());
        response.setNotice(savedPost.getNotice());
        response.setCreatedAt(savedPost.getCreatedAt());

        return response;
    }

    // Everyone can view all posts
    @Override
    public List<PostDto> getAllPosts() {
        return postRepository.findAll().stream()
                .map(post -> new PostDto(
                        post.getId(),
                        post.getNotice(),
                        post.getCreatedAt()
                ))
                .collect(Collectors.toList());
    }
}

package com.adminpanel.repository;

import com.adminpanel.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    // JpaRepository provides save(), findAll(), findById(), deleteById(), etc.
}

package com.csmarton.postserver.dao;

import com.csmarton.postserver.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    Post findByPostId(final String postId);
}

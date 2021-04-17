package com.csmarton.postserver.service;

import com.csmarton.postserver.dao.PostRepository;
import com.csmarton.postserver.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

}

package com.csmarton.postserver.dao;

import com.csmarton.postserver.model.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    private PostRepository repository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testSaveAndFindPost() throws Exception {
        Post post1 = new Post("1", "post1", "This is post no 1");
        repository.save(post1);
        Post post2 = new Post("2", "post2", "this is post no 2");
        repository.save(post2);

        assertEquals(post1, repository.findByPostId("1"));
        assertEquals(post2, repository.findByPostId("2"));
        assertNull(repository.findByPostId("3"));
    }

    @Test
    public void testSaveNewPostWithExistingPostId() throws Exception {
        Assertions.assertThrows(DuplicateKeyException.class, () -> {
            repository.save(new Post("1", "Post1", "Content1"));
            repository.save(new Post("1", "Post1", "Content1"));
        });
    }
}
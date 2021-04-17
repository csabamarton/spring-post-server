package com.csmarton.postserver.dao;

import com.csmarton.postserver.model.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootTest
class TicketRepositoryTest {

    @Autowired
    private TicketRepository repository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testSaveNewTicketWithExistingTicketId() throws Exception {
        Assertions.assertThrows(DuplicateKeyException.class, () -> {
            repository.save(new Ticket("1", "blabla"));
            repository.save(new Ticket("1", "hihi"));
        });
    }
}
package com.csmarton.postserver.dao;

import com.csmarton.postserver.model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<Ticket, String> {

    Ticket findByTicketId(final String ticketId);
}

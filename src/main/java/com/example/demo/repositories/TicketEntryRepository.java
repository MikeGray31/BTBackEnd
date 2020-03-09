package com.example.demo.repositories;

import com.example.demo.models.TicketEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketEntryRepository extends CrudRepository<TicketEntry, Long> {
}

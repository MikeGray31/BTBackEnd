package com.example.demo.services;

import com.example.demo.repositories.TicketEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketEntryServices {

    private TicketEntryRepository ticketEntryRepository;

    @Autowired
    public TicketEntryServices(TicketEntryRepository ticketEntryRepository) {
        this.ticketEntryRepository = ticketEntryRepository;
    }
}

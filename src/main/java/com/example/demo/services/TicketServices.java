package com.example.demo.services;

import com.example.demo.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServices {

    private TicketRepository ticketRepository;

    @Autowired
    public TicketServices(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
}

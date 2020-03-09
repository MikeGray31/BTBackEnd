package com.example.demo.controllers;

import com.example.demo.services.TicketServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {

    private TicketServices ticketServices;

    @Autowired
    public TicketController(TicketServices ticketServices) {
        this.ticketServices = ticketServices;
    }
}

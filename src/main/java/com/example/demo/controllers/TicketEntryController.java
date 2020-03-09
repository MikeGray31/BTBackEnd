package com.example.demo.controllers;

import com.example.demo.services.TicketEntryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketEntryController {

    private TicketEntryServices ticketEntryServices;

    @Autowired
    public TicketEntryController(TicketEntryServices ticketEntryServices) {
        this.ticketEntryServices = ticketEntryServices;
    }
}

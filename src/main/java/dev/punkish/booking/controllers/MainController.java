package dev.punkish.booking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dev.punkish.booking.services.TicketService;

@Controller
public class MainController {
    private TicketService ticketService;

    public MainController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("unsoldTickets", ticketService.getAllUnsold());
        model.addAttribute("soldTickets", ticketService.getAllSold());
        return "index";
    }
}

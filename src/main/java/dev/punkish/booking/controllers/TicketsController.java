package dev.punkish.booking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.punkish.booking.models.Ticket;
import dev.punkish.booking.services.TicketService;

@Controller   
@RequestMapping("/tickets") 
public class TicketsController {
    private TicketService ticketService;

    public TicketsController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    @GetMapping("/{id}/edit")
    public String editTicket(@PathVariable String id, Model model) {
        Ticket ticket = ticketService.getTicketById(id);
        model.addAttribute("ticket", ticket);
        return "tickets/form";
    }

    @PostMapping("/{id}/sell")
    public String sellTicket(@PathVariable String id) {
        Ticket ticket = ticketService.getTicketById(id);
        ticketService.updateTicketStatus(ticket);

        return "redirect:/";
    }
}

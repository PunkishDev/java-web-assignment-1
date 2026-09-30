package dev.punkish.booking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.punkish.booking.exceptions.TicketNotFoundException;
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

    @PostMapping("/{id}/edit")
    public String postEdit(@PathVariable String id, @ModelAttribute Ticket ticket) {
        try {
            Ticket t = ticketService.getTicketById(id);
            t.setTitle(ticket.getTitle());
            t.setPrice(ticket.getPrice());
            ticketService.updateTicket(t);
            return "redirect:/";
        } catch (TicketNotFoundException e) {
            return "redirect:/";
        }
    }

    @GetMapping("/{id}/sell")
    public String sellTicket(@PathVariable String id, Model model) {
        Ticket ticket = ticketService.getTicketById(id);
        model.addAttribute("ticket", ticket);
        return "tickets/sell";
    }

    @PostMapping("/{id}/sell")
    public String updateTicket(@PathVariable String id, @RequestParam(required = false) String confirm) {
        if (confirm != null && confirm.equals("yes")){
            try {
                Ticket ticket = ticketService.getTicketById(id);
                ticketService.updateTicketStatus(ticket);
            }catch (TicketNotFoundException e) {
                return "redirect:/";
            }
        }
        return "redirect:/";
    }
}

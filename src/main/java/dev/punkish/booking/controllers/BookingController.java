package dev.punkish.booking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class BookingController {
    @GetMapping("/")
    public String index() {
        return "redirect:/tickets";
    }
}

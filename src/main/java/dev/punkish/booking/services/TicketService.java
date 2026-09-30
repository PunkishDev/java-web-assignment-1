package dev.punkish.booking.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import dev.punkish.booking.exceptions.TicketNotFoundException;

import dev.punkish.booking.models.Ticket;

@Service
public class TicketService {
    private List<Ticket> tickets = new ArrayList<>();

    public TicketService() {
        tickets.add(new Ticket(UUID.randomUUID().toString(), "Taylor Swift's The Eras Tour", 108856L, false));
        tickets.add(new Ticket(UUID.randomUUID().toString(), "Coachella", 135487L, false));
        tickets.add(new Ticket(UUID.randomUUID().toString(), "Tomorrowland", 49720L, false));
        tickets.add(new Ticket(UUID.randomUUID().toString(), "Glastonbury", 52545L, false));
        tickets.add(new Ticket(UUID.randomUUID().toString(), "Elton John's Farewell Yellow Brick Road Tour", 52545L, false));
        tickets.add(new Ticket(UUID.randomUUID().toString(), "Lollapalooza", 71190L, false));
        tickets.add(new Ticket(UUID.randomUUID().toString(), "U2's, 360 Tour", 28250L, false));
        tickets.add(new Ticket(UUID.randomUUID().toString(), "Rock in Rio", 56274L, false));
        tickets.add(new Ticket(UUID.randomUUID().toString(), "Coldplay's Music of the Spheres Tour", 45200L, false));
        tickets.add(new Ticket(UUID.randomUUID().toString(), "Burning Man", 84750L, false));
    }

    public List<Ticket> getAllUnsold() {
        List<Ticket> result = new ArrayList<>();
        for (Ticket t : tickets) {
            if (!t.isSold()) {
                result.add(t);
            }
        }

        return result;
    }

    public List<Ticket> getAllSold() {
        List<Ticket> result = new ArrayList<>();
        for (Ticket t : tickets) {
            if (t.isSold()) {
                result.add(t);
            }
        }

        return result;
    }

    public Ticket getTicketById(String id) {
        for (Ticket t : tickets) {
            if (t.getId().equals(id)) {
                return t;
            }
        }

        throw new TicketNotFoundException(id);
    } 

    public Ticket updateTicketStatus(Ticket ticket) {
        for (Ticket t : tickets) {
            if (t.getId().equals(ticket.getId())) {
                t.toggleSold();
                return t;
            }
        }

        throw new TicketNotFoundException(ticket.getId());
    }
}

package com.bugtracker.controller;

import com.bugtracker.entity.Ticket;
import com.bugtracker.model.Status;
import com.bugtracker.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@CrossOrigin
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @PutMapping("/{id}/status")
    public Ticket updateStatus(@PathVariable Long id,
                               @RequestParam String status) {

        Status newStatus = Status.valueOf(status);  // 🔥 conversion happens here
        return ticketService.updateStatus(id, newStatus);
    }

    @DeleteMapping("/{id}")
    public String deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return "Ticket deleted successfully";
    }
}

package com.bugtracker.service;

import com.bugtracker.entity.Ticket;
import com.bugtracker.model.Status;

import java.util.List;

public interface TicketService {

    Ticket createTicket(Ticket ticket);

    List<Ticket> getAllTickets();

    Ticket updateStatus(Long id, Status status);

    void deleteTicket(Long id);
}

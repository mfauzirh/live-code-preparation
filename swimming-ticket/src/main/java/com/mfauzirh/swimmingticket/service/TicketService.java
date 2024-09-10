package com.mfauzirh.swimmingticket.service;

import com.mfauzirh.swimmingticket.dto.TicketRequest;
import com.mfauzirh.swimmingticket.entity.Ticket;
import com.mfauzirh.swimmingticket.repository.TicketRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public Ticket createTicket(TicketRequest request) {
        Ticket ticket = Ticket.builder()
                .ticketType(request.getTicketType())
                .price(request.getPrice())
                .stock(request.getStock())
                .build();
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicketStock(Long id, TicketRequest request) {
        return ticketRepository.findById(id)
                .map(ticket -> {
                    ticket.setTicketType(request.getTicketType());
                    ticket.setPrice(request.getPrice());
                    ticket.setStock(request.getStock());
                    return ticketRepository.save(ticket);
                })
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found with id: " + id));
    }
}

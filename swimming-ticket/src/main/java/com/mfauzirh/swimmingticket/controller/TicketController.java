package com.mfauzirh.swimmingticket.controller;

import com.mfauzirh.swimmingticket.dto.TicketRequest;
import com.mfauzirh.swimmingticket.entity.Ticket;
import com.mfauzirh.swimmingticket.service.TicketService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ResponseEntity.ok(ticketService.findAll());
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@Valid @RequestBody TicketRequest request) {
        return ResponseEntity.ok(ticketService.createTicket(request));
    }

    @PutMapping("/{id}/stock")
    public ResponseEntity<Ticket> updateTicketStock(@PathVariable Long id, @Valid @RequestBody TicketRequest request) {
        return ResponseEntity.ok(ticketService.updateTicketStock(id, request));
    }
}
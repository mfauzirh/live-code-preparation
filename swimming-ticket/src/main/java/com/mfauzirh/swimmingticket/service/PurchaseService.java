package com.mfauzirh.swimmingticket.service;

import com.mfauzirh.swimmingticket.dto.PurchaseRequest;
import com.mfauzirh.swimmingticket.entity.Purchase;
import com.mfauzirh.swimmingticket.entity.Ticket;
import com.mfauzirh.swimmingticket.repository.PurchaseRepository;
import com.mfauzirh.swimmingticket.repository.TicketRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public List<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

    @Transactional
    public Purchase createPurchase(PurchaseRequest request) {
        List<Ticket> purchasedTicket = new ArrayList<>();
        int totalPrice = 0;
        for (Long id : request.getTicketIds()) {
            Ticket ticket = ticketRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Ticket is not found"));

            if (ticket.getStock() < 1) {
                throw new IllegalArgumentException("Purchase cannot be done due to insufficient stock");
            }
            totalPrice += ticket.getPrice();
            ticket.setStock(ticket.getStock() - 1);
            ticketRepository.save(ticket);
            purchasedTicket.add(ticket);
        }

        Purchase purchase = Purchase.builder()
                .purchaseDate(LocalDate.now())
                .totalPrice(totalPrice)
                .tickets(purchasedTicket)
                .build();
        return purchaseRepository.save(purchase);
    }

    public Purchase getPurchase(Long id) {
        return purchaseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("purchase is not found"));
    }
}

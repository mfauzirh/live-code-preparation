package com.mfauzirh.swimmingticket.repository;

import com.mfauzirh.swimmingticket.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}

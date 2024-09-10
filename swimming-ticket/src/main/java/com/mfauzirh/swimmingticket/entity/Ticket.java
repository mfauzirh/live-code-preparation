package com.mfauzirh.swimmingticket.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long id;

    @Column(name = "ticket_type", nullable = false, length = 125)
    private String ticketType;

    @Column(nullable = false)
    @Min(value = 0, message = "Stock can't be lower than 0")
    private Integer stock;

    @Column(nullable = false)
    @Min(value = 0, message = "Price can't be lower than 0")
    private Integer price;
}

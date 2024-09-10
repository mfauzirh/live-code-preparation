package com.mfauzirh.swimmingticket.dto;

import com.mfauzirh.swimmingticket.entity.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseRequest {
    private List<Long> ticketIds;
}

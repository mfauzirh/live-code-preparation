package com.mfauzirh.swimmingticket.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketRequest {
    @NotNull
    @NotBlank
    @Size(min = 0, max = 125)
    private String ticketType;

    @Min(value = 0, message = "Stock can't be lower than 0")
    private Integer stock;

    @Min(value = 0, message = "Price can't be lower than 0")
    private Integer price;
}

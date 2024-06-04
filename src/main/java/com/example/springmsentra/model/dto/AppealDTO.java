package com.example.springmsentra.model.dto;

import lombok.Builder;
import lombok.Data;


import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
public class AppealDTO {
    private UUID id;
    private String nric;
    private String appealStatus;
    private String appealDescription;
    private LocalDateTime appealCreatedDate;
}

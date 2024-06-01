package com.example.springmsentra.model.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class AppealDTO {
    private long id;
    private String nric;
    private String appealStatus;
    private String appealDescription;
    private LocalDateTime appealCreatedDate;
}

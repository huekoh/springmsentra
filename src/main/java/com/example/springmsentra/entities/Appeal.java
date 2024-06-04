package com.example.springmsentra.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Appeal {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    @NotNull
    @Column(length = 9, nullable = false, unique = true)
    private String nric;

    public enum AppealStatus {
        REJECTED, PENDING, APPROVED
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AppealStatus appealStatus;

    @NotNull
    @Column
    private String appealDescription;

    @CreationTimestamp
    @Column
    private LocalDateTime appealCreatedDate;
}

package com.example.demo.model;

import com.example.demo.model.enums.Role;
import com.example.demo.model.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Booking {
    @Id
    Long id;

    @Column(nullable = false)
    BigDecimal totalPrice;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    Status status;

    @Column(nullable = false)
    LocalDateTime startTime;

    @Column(nullable = false)
    LocalDateTime endTime;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    User user;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "room_id", referencedColumnName = "id", nullable = false)
    Room room;
}

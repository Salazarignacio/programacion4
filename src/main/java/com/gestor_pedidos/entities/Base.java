package com.gestor_pedidos.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@MappedSuperclass
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
public abstract class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean eliminado = false;
    private LocalDate createdAt = LocalDate.now();
}

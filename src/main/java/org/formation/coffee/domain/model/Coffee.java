package org.formation.coffee.domain.model;

public record Coffee(
        Long id,
        String name,
        Double price
) {
}
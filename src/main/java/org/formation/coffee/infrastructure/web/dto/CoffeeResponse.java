package org.formation.coffee.infrastructure.web.dto;

public record CoffeeResponse(
        Long id,
        String name,
        Double price
) {
}
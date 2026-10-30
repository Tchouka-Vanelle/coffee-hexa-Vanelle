package org.formation.coffee.infrastructure.web.dto;

public record CoffeeRequest(
        String name,
        Double price
) {
}
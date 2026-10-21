package org.formation.coffee.infrastructure.web.controller;

import org.formation.coffee.application.port.in.CreateCoffeeUseCase;
import org.formation.coffee.infrastructure.web.dto.CoffeeRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coffees")
public class CoffeeController {

    private final CreateCoffeeUseCase useCase;

    public CoffeeController(
            CreateCoffeeUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public ResponseEntity<Void> createCoffee(
            @RequestBody CoffeeRequest request) {

        useCase.createCoffee(
                request.name(),
                request.price()
        );

        return ResponseEntity.ok().build();
    }
}
package org.formation.coffee.infrastructure.web.controller;

import org.formation.coffee.application.port.in.CreateCoffeeUseCase;
import org.formation.coffee.application.port.in.GetAllCoffeesUseCase;
import org.formation.coffee.infrastructure.web.dto.CoffeeRequest;
import org.formation.coffee.infrastructure.web.dto.CoffeeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/coffees")
public class CoffeeController {

    private final CreateCoffeeUseCase useCase;
    private final GetAllCoffeesUseCase getAllUseCase;

    public CoffeeController(
            CreateCoffeeUseCase useCase, GetAllCoffeesUseCase getAllUseCase) {
        this.useCase = useCase;
        this.getAllUseCase = getAllUseCase;
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

    @GetMapping
    public List<CoffeeResponse> getAll() {

        return getAllUseCase.getAll()
                .stream()
                .map(coffee ->
                        new CoffeeResponse(
                                coffee.id(),
                                coffee.name(),
                                coffee.price()
                        )
                )
                .toList();
    }
}
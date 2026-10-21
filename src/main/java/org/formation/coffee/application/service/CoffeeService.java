package org.formation.coffee.application.service;

import org.formation.coffee.application.port.in.CreateCoffeeUseCase;
import org.formation.coffee.application.port.in.GetAllCoffeesUseCase;
import org.formation.coffee.application.port.out.CoffeeRepositoryPort;
import org.formation.coffee.domain.model.Coffee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService implements CreateCoffeeUseCase, GetAllCoffeesUseCase {

    private final CoffeeRepositoryPort repository;

    public CoffeeService(CoffeeRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public void createCoffee(String name, Double price) {

        Coffee coffee =
                new Coffee(
                        null,
                        name,
                        price
                );

        repository.save(coffee);
    }

    @Override
    public List<Coffee> getAll() {
        return repository.findAll();
    }
}
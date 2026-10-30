package org.formation.coffee.application.port.out;

import org.formation.coffee.domain.model.Coffee;

import java.util.List;

public interface CoffeeRepositoryPort {

    Coffee save(Coffee coffee);

    List<Coffee> findAll();

}
package org.formation.coffee.application.port.out;

import org.formation.coffee.domain.model.Coffee;

public interface CoffeeRepositoryPort {

    Coffee save(Coffee coffee);

}
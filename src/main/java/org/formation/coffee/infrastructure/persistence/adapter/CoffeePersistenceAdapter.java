package org.formation.coffee.infrastructure.persistence.adapter;

import org.formation.coffee.application.port.out.CoffeeRepositoryPort;
import org.formation.coffee.domain.model.Coffee;
import org.formation.coffee.infrastructure.persistence.entity.CoffeeEntity;
import org.formation.coffee.infrastructure.persistence.repository.CoffeeJpaRepository;
import org.springframework.stereotype.Component;

@Component
public class CoffeePersistenceAdapter
        implements CoffeeRepositoryPort {

    private final CoffeeJpaRepository repository;

    public CoffeePersistenceAdapter(
            CoffeeJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Coffee save(Coffee coffee) {

        CoffeeEntity entity =
                new CoffeeEntity(
                        coffee.id(),
                        coffee.name(),
                        coffee.price()
                );

        entity = repository.save(entity);

        return new Coffee(
                entity.getId(),
                entity.getName(),
                entity.getPrice()
        );
    }
}
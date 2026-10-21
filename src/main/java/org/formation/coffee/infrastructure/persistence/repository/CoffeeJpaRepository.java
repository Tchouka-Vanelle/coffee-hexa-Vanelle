package org.formation.coffee.infrastructure.persistence.repository;

import org.formation.coffee.infrastructure.persistence.entity.CoffeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeJpaRepository
        extends JpaRepository<CoffeeEntity, Long> {
}
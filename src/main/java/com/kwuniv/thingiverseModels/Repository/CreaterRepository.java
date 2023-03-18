package com.kwuniv.thingiverseModels.Repository;

import com.kwuniv.thingiverseModels.Entity.Creater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CreaterRepository extends JpaRepository<Creater, Long> {
    Optional<Creater> findByName(String name);
}

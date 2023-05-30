package com.kwuniv.thingiverseModels.Repository;

import com.kwuniv.thingiverseModels.Entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Optional<Tag> findByTagName(String tagname);
}

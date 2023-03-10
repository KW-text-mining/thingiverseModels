package com.kwuniv.thingiverseModels.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestData {
    @Id
    @GeneratedValue
    @Column
    private Long testDataId;

    private String name;
}

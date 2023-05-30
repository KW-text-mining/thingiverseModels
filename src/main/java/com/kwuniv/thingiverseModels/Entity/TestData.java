package com.kwuniv.thingiverseModels.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

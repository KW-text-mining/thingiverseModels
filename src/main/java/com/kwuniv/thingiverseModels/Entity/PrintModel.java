package com.kwuniv.thingiverseModels.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrintModel {

    @Id
    @GeneratedValue
    @Column(name="printmodel_id")
    private Long printModelId;
    private Integer modelId;

    private String name;
    private String thumbnail;

    private String public_url;
    private String createrName;
    private LocalDateTime added;
    private String description;
    private String modelName;
    private Integer likeCount;
    private Integer collectCount;
    private Integer commentCount;
    private Integer downloadCount;
    private Integer viewCount;
    private Integer makeCount;
}

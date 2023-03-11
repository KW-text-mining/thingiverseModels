package com.kwuniv.thingiverseModels.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kwuniv.thingiverseModels.Category;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
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
    @Column
    private Long printModelId;
    private Integer modelId;

    private String name;
    private String thumbnail;

    private String public_url;
    private String createrName;
    @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    private LocalDate added;
    private String description;

    public String bigCategory;
    public String smallCategory;
    private String modelName;
    private Integer likeCount;
    private Integer collectCount;
    private Integer commentCount;
    private Integer downloadCount;
    private Integer viewCount;
    private Integer makeCount;



}

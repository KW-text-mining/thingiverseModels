package com.kwuniv.thingiverseModels.Dto;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BigCategoryResponseDTO {

    private String categoryName;
    private Integer count;

}

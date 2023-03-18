package com.kwuniv.thingiverseModels.Dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TagResponseDTO {
    private String tagName;
    private Integer count;
}

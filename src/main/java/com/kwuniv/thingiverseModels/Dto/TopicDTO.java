package com.kwuniv.thingiverseModels.Dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TopicDTO {
    private String text;
    private Integer value;
}

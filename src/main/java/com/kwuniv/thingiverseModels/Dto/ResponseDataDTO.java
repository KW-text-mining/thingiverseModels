package com.kwuniv.thingiverseModels.Dto;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class ResponseDataDTO {
    private Integer count;
    private List<DTO> dtos=new ArrayList<>();

    private List<TopicDTO> topics = new ArrayList<>();
}

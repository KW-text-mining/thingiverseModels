package com.kwuniv.thingiverseModels.Dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class DTO {
    List<ResultDTO> resultDTOList = new ArrayList<>();
}

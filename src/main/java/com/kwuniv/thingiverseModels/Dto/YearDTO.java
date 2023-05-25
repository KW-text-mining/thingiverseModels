package com.kwuniv.thingiverseModels.Dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class YearDTO {
    private String name;

    private List<Integer> data = new ArrayList<>();
}
package com.kwuniv.thingiverseModels.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@RequiredArgsConstructor
public class PrintModelResponseDTO {
    private Integer id;

    private String name;
    private String creater;

    private LocalDate added;
    private String thumbnail;
    private Integer likeCount;
    private Integer collectCount;
    private Integer commentCount;
    private String description;
    private String instruction;

    public List<String> tags;
    public String bigCategory;
    public String smallCategory;
    private Integer fileCount;
    private Integer downloadCount;
    private Integer viewCount;
    private Integer remixCount;
    private Integer makeCount;
    private Integer rootCommentCount;


}

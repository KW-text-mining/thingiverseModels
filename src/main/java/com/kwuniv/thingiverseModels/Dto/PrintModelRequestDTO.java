package com.kwuniv.thingiverseModels.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kwuniv.thingiverseModels.Category;
import com.kwuniv.thingiverseModels.Entity.PrintModel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@RequiredArgsConstructor
public class PrintModelRequestDTO {
    private Integer id;


    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    private LocalDate added;
    private String thumbnail;

    private Integer likeCount;
    private Integer collectCount;
    private Integer commentCount;
    private String description;
    private String instruction;

    public List<String> tags;
    private String slug;
    private Integer fileCount;
    private Integer downloadCount;
    private Integer viewCount;
    private Integer makeCount;

    private Integer remixCount;
    private Integer rootCommentCount;


    private String createrName;
    private String firstName;
    private String lastname;
    private String modelThumbnail;
    private Integer countOfFollwers;
    private Integer countOfFollwings;
    private Integer countOfDesigns;
    private String location;






    public PrintModel toEntity() {
        Category category = Category.getInstance();
        String bigCategory = category.getBigCategory(this.slug);
        PrintModel newPrintmodel = PrintModel.builder().id(id).added(added).thumbnail(thumbnail).likeCount(likeCount).collectCount(collectCount).description(description).instruction(instruction).bigCategory(bigCategory).smallCategory(slug).fileCount(fileCount)
                .downloadCount(downloadCount).viewCount(viewCount).makeCount(makeCount).rootCommentCount(rootCommentCount).build();
        return newPrintmodel;
    }


}



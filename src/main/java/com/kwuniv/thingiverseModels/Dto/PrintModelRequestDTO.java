package com.kwuniv.thingiverseModels.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kwuniv.thingiverseModels.Category;
import com.kwuniv.thingiverseModels.Entity.PrintModel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class PrintModelRequestDTO {
    private Integer modelId;

    private String name;
    private String thumbnail;

    private String public_url;
    private String createrName;
    @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    private LocalDate added;
    private String description;

    public String slug;
    private String modelName;
    private Integer likeCount;
    private Integer collectCount;
    private Integer commentCount;
    private Integer downloadCount;
    private Integer viewCount;
    private Integer makeCount;

    public PrintModel toEntity() {
        Category category = Category.getInstance();
        String bigCategory = category.getBigCategory(this.slug);
        return PrintModel.builder().modelId(modelId).name(name)
                .thumbnail(thumbnail).public_url(public_url).createrName(createrName).added(added).description(description).smallCategory(slug).bigCategory(bigCategory).modelName(modelName).likeCount(likeCount).collectCount(collectCount).commentCount(commentCount).downloadCount(downloadCount).viewCount(viewCount).makeCount(makeCount).build();    }
}



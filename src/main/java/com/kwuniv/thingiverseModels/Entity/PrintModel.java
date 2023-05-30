package com.kwuniv.thingiverseModels.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class PrintModel {

    @Id
    @GeneratedValue
    @Column(name = "printmodel_id")
    private Long printModelId;
    private Integer id;

    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="creater_id")
    private Creater creater;

    @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    private LocalDate added;
    private String thumbnail;

    private Integer likeCount;
    private Integer collectCount;
    private Integer commentCount;
    @Column(length = 5000)
    private String description;
    @Column(length = 5000)
    private String instruction;


    @OneToMany(mappedBy = "printModel")
    public List<TagPrintModel> tags;
    public String bigCategory;
    public String smallCategory;

    private Integer fileCount;
    private Integer downloadCount;
    private Integer viewCount;
    private Integer remixCount;
    private Integer makeCount;
    private Integer rootCommentCount;



}

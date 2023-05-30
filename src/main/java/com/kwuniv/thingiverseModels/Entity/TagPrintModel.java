package com.kwuniv.thingiverseModels.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TagPrintModel {
    @Id
    @GeneratedValue
    @Column(name = "tagprintmodel_id")
    private Long tagPringMdodelId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="printmodel_id")
    private PrintModel printModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tag_id")
    private Tag tag;
}

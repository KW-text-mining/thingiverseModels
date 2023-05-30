package com.kwuniv.thingiverseModels.Entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Creater {

    @Id
    @GeneratedValue
    @Column(name = "creater_id")
    private Long createrId;

//    @OneToMany(mappedBy = "creater")
//    private List<PrintModel> printModels = new ArrayList<>();

    private String name;
    private String firstName;
    private String lastname;
    private String thumbnail;
    private Integer countOfFollwers;
    private Integer countOfFollwings;
    private Integer countOfDesigns;




}

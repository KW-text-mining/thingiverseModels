package com.kwuniv.thingiverseModels.Repository;

import com.kwuniv.thingiverseModels.Entity.PrintModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrintModelRepository extends JpaRepository<PrintModel, Long> {

    List<PrintModel> findByAddedBetween(LocalDate startTime, LocalDate endTime);
    List<PrintModel> findByAddedBetweenAndBigCategory(LocalDate startTime, LocalDate endTime,String bigCategory);
    List<PrintModel> findByAddedBetweenAndSmallCategory(LocalDate startTime, LocalDate endTime,String smallCategory);

}

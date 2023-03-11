package com.kwuniv.thingiverseModels.Service;


import com.kwuniv.thingiverseModels.Entity.PrintModel;
import com.kwuniv.thingiverseModels.Repository.PrintModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrintModelService {

    @Autowired
    private PrintModelRepository printModelRepository;


    public PrintModel makeData(PrintModel pm) {
        return printModelRepository.save(pm);
    }

    public List<PrintModel> findAllData() {
        return printModelRepository.findAll();
    }

    public List<PrintModel> findBetween(String startDate, String endDate) {
        LocalDate startLocalDate = LocalDate.parse(startDate);
        LocalDate endLocalDate = LocalDate.parse(endDate);
        return printModelRepository.findByAddedBetween(startLocalDate, endLocalDate);
    }

    public List<PrintModel> findBigCategory(String startDate, String endDate, String bigCategory) {
        LocalDate startLocalDate = LocalDate.parse(startDate);
        LocalDate endLocalDate = LocalDate.parse(endDate);
        return printModelRepository.findByAddedBetweenAndBigCategory(startLocalDate, endLocalDate,bigCategory);
    }

    public List<PrintModel> findSmallCategory(String startDate, String endDate, String smallCategory) {
        LocalDate startLocalDate = LocalDate.parse(startDate);
        LocalDate endLocalDate = LocalDate.parse(endDate);
        return printModelRepository.findByAddedBetweenAndSmallCategory(startLocalDate, endLocalDate,smallCategory);
    }
}

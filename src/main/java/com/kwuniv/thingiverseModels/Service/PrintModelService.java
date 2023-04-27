package com.kwuniv.thingiverseModels.Service;


import com.kwuniv.thingiverseModels.Dto.PrintModelRequestDTO;
import com.kwuniv.thingiverseModels.Entity.Creater;
import com.kwuniv.thingiverseModels.Entity.PrintModel;
import com.kwuniv.thingiverseModels.Entity.Tag;
import com.kwuniv.thingiverseModels.Entity.TagPrintModel;
import com.kwuniv.thingiverseModels.Repository.PrintModelRepository;
import com.kwuniv.thingiverseModels.Repository.TagPrintMdodelRepository;
import com.kwuniv.thingiverseModels.Repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PrintModelService {

    @Autowired
    private PrintModelRepository printModelRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private TagPrintMdodelRepository tagPrintMdodelRepository;

    @Autowired
    private TagPrintModelService tagPrintModelService;

    @Autowired
    private CreaterService createrService;
    public PrintModel makeData(PrintModelRequestDTO pm) {
        PrintModel printModel = pm.toPrintEntity();

        Creater creater = createrService.getCreater(pm);
        printModel.setCreater(creater);
        printModelRepository.save(printModel);
        List<TagPrintModel> taglist=  tagPrintModelService.addTag(printModel,pm.getTags());
        //printModel.setTags(taglist);


        return printModel;
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

    public Integer countBigCategory(String startDate, String endDate, String bigCategory) {
        LocalDate startLocalDate = LocalDate.parse(startDate);
        LocalDate endLocalDate = LocalDate.parse(endDate);
        return printModelRepository.countByAddedBetweenAndBigCategory(startLocalDate, endLocalDate,bigCategory);
    }

    public Integer countSmallCategory(String startDate, String endDate, String bigCategory, String name) {
        LocalDate startLocalDate = LocalDate.parse(startDate);
        LocalDate endLocalDate = LocalDate.parse(endDate);
        return printModelRepository.countByAddedBetweenAndBigCategoryAndSmallCategory(startLocalDate, endLocalDate,bigCategory,name);
    }

    public Integer countAllBigCategory( String bigCategory) {
        return printModelRepository.countBigCategory(bigCategory);
    }
}

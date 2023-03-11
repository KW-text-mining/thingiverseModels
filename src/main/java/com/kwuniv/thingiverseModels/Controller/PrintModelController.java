package com.kwuniv.thingiverseModels.Controller;


import com.kwuniv.thingiverseModels.Dto.PrintModelRequestDTO;
import com.kwuniv.thingiverseModels.Dto.TestDataDTO;
import com.kwuniv.thingiverseModels.Dto.TestDataRequestDTO;
import com.kwuniv.thingiverseModels.Entity.PrintModel;
import com.kwuniv.thingiverseModels.Entity.TestData;
import com.kwuniv.thingiverseModels.Service.PrintModelService;
import com.kwuniv.thingiverseModels.Service.TestDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("data")
public class PrintModelController {
    @Autowired
    private PrintModelService printModelService;

    @PostMapping("/makedata")
    public PrintModel makeNewData(@RequestBody PrintModelRequestDTO pm) {
        PrintModel printModel = printModelService.makeData(pm.toEntity());
        //중복 체크, dto 처리 안함
        return printModel;
    }

    @GetMapping("findalldata")
    public List<PrintModel> findAllDatas() {
        List<PrintModel> printModels = printModelService.findAllData();

        return printModels;
    }

    @GetMapping("finddatabetween")
    public List<PrintModel> findDataBetween(@RequestParam String startDate,@RequestParam String endDate) {
        System.out.println(startDate);
        System.out.println(endDate);
        List<PrintModel> printModels = printModelService.findBetween(startDate,endDate);

        return printModels;
    }

    @GetMapping("finddatabig")
    public List<PrintModel> findDataBig(@RequestParam String startDate,@RequestParam String endDate,@RequestParam String bigCategory) {

        List<PrintModel> printModels = printModelService.findBigCategory(startDate,endDate,bigCategory);

        return printModels;
    }

    @GetMapping("finddatasmall")
    public List<PrintModel> findDataSmall(@RequestParam String startDate,@RequestParam String endDate,@RequestParam String smallCategory) {

        List<PrintModel> printModels = printModelService.findSmallCategory(startDate,endDate,smallCategory);

        return printModels;
    }
}

package com.kwuniv.thingiverseModels.Controller;

import com.kwuniv.thingiverseModels.Dto.TestDataDTO;
import com.kwuniv.thingiverseModels.Dto.TestDataRequestDTO;
import com.kwuniv.thingiverseModels.Entity.TestData;
import com.kwuniv.thingiverseModels.Service.TestDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("testdata")
public class TestDataController {

    @Autowired
    private TestDataService testDataService;

    @GetMapping("test")
    public String test() {
        return "hello World";
    }

    @PostMapping("/makedata")
    public TestDataDTO makeFifaUser(@RequestBody TestDataRequestDTO td) {
        TestData testData = testDataService.makeData(td.getName());

        TestDataDTO testDataDTO = new TestDataDTO();
        testDataDTO.setName(testData.getName());
        return testDataDTO;
    }

    @GetMapping("findalldata")
    public List<TestDataDTO> findAllDatas() {
        List<TestData> testDatas = testDataService.findAllData();
        List<TestDataDTO> testDataDTOS = new ArrayList<>();
        for (TestData testData : testDatas) {
            TestDataDTO newDTO = new TestDataDTO();
            newDTO.setName(testData.getName());
            testDataDTOS.add(newDTO);
        }

        return testDataDTOS;
    }
}

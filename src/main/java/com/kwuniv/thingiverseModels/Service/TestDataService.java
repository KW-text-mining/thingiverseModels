package com.kwuniv.thingiverseModels.Service;

import com.kwuniv.thingiverseModels.Entity.TestData;
import com.kwuniv.thingiverseModels.Repository.TestDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class TestDataService {

    @Autowired
    private TestDataRepository testDataRepository;


    public TestData makeData(String name) {

        TestData newTestData = new TestData();
        newTestData.setName(name);

        return testDataRepository.save(newTestData);
    }

    public List<TestData> findAllData() {
        return testDataRepository.findAll();
    }
}

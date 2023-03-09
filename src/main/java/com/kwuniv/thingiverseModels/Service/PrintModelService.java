package com.kwuniv.thingiverseModels.Service;


import com.kwuniv.thingiverseModels.Entity.PrintModel;
import com.kwuniv.thingiverseModels.Repository.PrintModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

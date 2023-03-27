package com.kwuniv.thingiverseModels.Service;

import com.kwuniv.thingiverseModels.Dto.PrintModelRequestDTO;
import com.kwuniv.thingiverseModels.Entity.Creater;
import com.kwuniv.thingiverseModels.Repository.CreaterRepository;
import com.kwuniv.thingiverseModels.Repository.TagPrintMdodelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreaterService {

    @Autowired
    private CreaterRepository createrRepository;

    public Creater getCreater(PrintModelRequestDTO pm) {
        Optional<Creater> creater = createrRepository.findByName(pm.getName());
        if (creater.isPresent()) {
            return creater.get();
        }
        Creater newCreater = pm.toCreaterEntity();
        return createrRepository.save(newCreater);
    }
}

package com.kwuniv.thingiverseModels.Service;

import com.kwuniv.thingiverseModels.Entity.PrintModel;
import com.kwuniv.thingiverseModels.Entity.Tag;
import com.kwuniv.thingiverseModels.Entity.TagPrintModel;
import com.kwuniv.thingiverseModels.Repository.PrintModelRepository;
import com.kwuniv.thingiverseModels.Repository.TagPrintMdodelRepository;
import com.kwuniv.thingiverseModels.Repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TagPrintModelService {
    @Autowired
    private PrintModelRepository printModelRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private TagPrintMdodelRepository tagPrintMdodelRepository;

    public List<TagPrintModel> addTag(PrintModel printModel, List<String> tags) {
        List<TagPrintModel> taglist = new ArrayList<>();
            for (String tagname : tags) {
                Optional<Tag> tag = tagRepository.findByTagName(tagname);
                Tag mappingTag;
                if (tag.isPresent()) {
                    mappingTag = tag.get();
                    mappingTag.setCount(mappingTag.getCount() + 1);

                } else {
                    mappingTag = new Tag();
                    mappingTag.setCount(0);
                    mappingTag.setTagName(tagname);

                }
                tagRepository.save(mappingTag);
                TagPrintModel tagPrintModel = new TagPrintModel();
                //tagPrintModel.setPrintModel(printModel);
                tagPrintModel.setTag(mappingTag);
                tagPrintModel.setPrintModel(printModel);

                tagPrintMdodelRepository.save(tagPrintModel);

        }
        return taglist;
    }
}

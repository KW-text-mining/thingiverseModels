package com.kwuniv.thingiverseModels.Controller;


import com.kwuniv.thingiverseModels.BigCategory;
import com.kwuniv.thingiverseModels.Dto.*;
import com.kwuniv.thingiverseModels.Entity.PrintModel;
import com.kwuniv.thingiverseModels.Entity.TagPrintModel;
import com.kwuniv.thingiverseModels.Entity.TestData;
import com.kwuniv.thingiverseModels.Service.PrintModelService;
import com.kwuniv.thingiverseModels.Service.TestDataService;
import com.kwuniv.thingiverseModels.SmallCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("data")
public class PrintModelController {
    @Autowired
    private PrintModelService printModelService;

    @PostMapping("/makedata")
    public PrintModel makeNewData(@RequestBody PrintModelRequestDTO pm) {
        System.out.println(pm);
        PrintModel printModel = printModelService.makeData(pm);

        //중복 체크, dto 처리 안함
        return null;
    }

    @GetMapping("findalldata")
    public List<PrintModelResponseDTO> findAllDatas() {
        List<PrintModel> printModels = printModelService.findAllData();
        List<PrintModelResponseDTO> printModelResponseDTOS = new ArrayList<>();
        for (PrintModel printModel : printModels) {
            PrintModelResponseDTO pr = new PrintModelResponseDTO();
            pr.setId(printModel.getId());
            pr.setCreator(printModel.getCreater().getFirstName() + printModel.getCreater().getLastname());
            pr.setAdded(printModel.getAdded());
            pr.setThumbnail(printModel.getThumbnail());
            pr.setLikeCount(printModel.getLikeCount());
            pr.setCollectCount(printModel.getCollectCount());
            pr.setBigCategory(printModel.bigCategory);
            pr.setSmallCategory(printModel.smallCategory);
            pr.setFileCount(printModel.getFileCount());
            pr.setViewCount(printModel.getViewCount());
            pr.setMakeCount(printModel.getMakeCount());

            pr.setRootCommentCount(printModel.getRootCommentCount());

            List<String> tags = new ArrayList<>();
            for (TagPrintModel model : printModel.getTags()) {
                tags.add(model.getTag().getTagName());
            }
            pr.setTags(tags);
            printModelResponseDTOS.add(pr);
        }
        return printModelResponseDTOS;
    }

    @GetMapping("finddatabetween")
    public List<PrintModelResponseDTO> findDataBetween(@RequestParam String startDate,@RequestParam String endDate) {
        System.out.println(startDate);
        System.out.println(endDate);

        List<PrintModel> printModels = printModelService.findBetween(startDate,endDate);



        List<PrintModelResponseDTO> printModelResponseDTOS = new ArrayList<>();
        for (PrintModel printModel : printModels) {
            PrintModelResponseDTO pr = new PrintModelResponseDTO();
            pr.setId(printModel.getId());
            pr.setCreator(printModel.getCreater().getFirstName() + printModel.getCreater().getLastname());
            pr.setAdded(printModel.getAdded());
            pr.setThumbnail(printModel.getThumbnail());
            pr.setLikeCount(printModel.getLikeCount());
            pr.setCollectCount(printModel.getCollectCount());
            pr.setBigCategory(printModel.bigCategory);
            pr.setSmallCategory(printModel.smallCategory);
            pr.setFileCount(printModel.getFileCount());
            pr.setViewCount(printModel.getViewCount());
            pr.setMakeCount(printModel.getMakeCount());

            pr.setRootCommentCount(printModel.getRootCommentCount());

            List<String> tags = new ArrayList<>();
            for (TagPrintModel model : printModel.getTags()) {
                tags.add(model.getTag().getTagName());
            }
            pr.setTags(tags);
            printModelResponseDTOS.add(pr);
        }
        return printModelResponseDTOS;
    }

    @GetMapping("period")
    public List<BigCategoryResponseDTO> findbigbyperiod(@RequestParam String startDate,@RequestParam String endDate) {

        List<BigCategoryResponseDTO> dtos = new ArrayList<>();
        for (BigCategory big : BigCategory.values()) {
            BigCategoryResponseDTO dto = new BigCategoryResponseDTO();
            dto.setCategoryName(big.getName());
            Integer count=printModelService.countBigCategory(startDate, endDate, big.getName());
            dto.setCount(count);

            dtos.add(dto);
        }

        return dtos;
    }

    @GetMapping("big")
    public List<SmallCategoryResponseDTO> findsmallbybig(@RequestParam String startDate,@RequestParam String endDate,@RequestParam String bigCategory) {

        List<SmallCategoryResponseDTO> dtos = new ArrayList<>();
        for (SmallCategory small : SmallCategory.values()) {
            SmallCategoryResponseDTO dto = new SmallCategoryResponseDTO();
            dto.setCategoryName(small.getName());
            Integer count=printModelService.countSmallCategory(startDate, endDate,bigCategory, small.getName());
            dto.setCount(count);

            dtos.add(dto);
        }

        return dtos;
    }


    @GetMapping("small")
    public List<TagResponseDTO> findtags(@RequestParam String startDate,@RequestParam String endDate,@RequestParam String smallCategory) {

        List<TagResponseDTO> dtos = new ArrayList<>();
        List<PrintModel> printModels = printModelService.findSmallCategory(startDate,endDate,smallCategory);
        HashMap<String, Integer> tags = new HashMap<String, Integer>();
        for (PrintModel printModel : printModels) {
            List<TagPrintModel> tagPrintModels = printModel.getTags();
            for (TagPrintModel tagPrintModel : tagPrintModels) {
                int x = 1;
                if (tags.containsKey(tagPrintModel.getTag().getTagName())) {
                    x = tags.get(tagPrintModel.getTag().getTagName())+1;
                }
                tags.put(tagPrintModel.getTag().getTagName(), x);
            }

        }
        for( String key : tags.keySet() ){
            TagResponseDTO tagResponseDTO = new TagResponseDTO();
            tagResponseDTO.setTagName(key);
            tagResponseDTO.setCount(tags.get(key));
            dtos.add(tagResponseDTO);
        }
        return dtos;
    }

    @GetMapping("finddatasmall")
    public List<PrintModel> findDataSmall(@RequestParam String startDate,@RequestParam String endDate,@RequestParam String smallCategory) {

        List<PrintModel> printModels = printModelService.findSmallCategory(startDate,endDate,smallCategory);

        return printModels;
    }
}

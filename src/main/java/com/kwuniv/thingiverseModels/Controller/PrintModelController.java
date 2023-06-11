package com.kwuniv.thingiverseModels.Controller;


import com.kwuniv.thingiverseModels.BigCategory;
import com.kwuniv.thingiverseModels.Dto.*;
import com.kwuniv.thingiverseModels.Entity.PrintModel;
import com.kwuniv.thingiverseModels.Entity.TagPrintModel;
import com.kwuniv.thingiverseModels.Service.PrintModelService;
import com.kwuniv.thingiverseModels.SmallCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080","https://kw-text-mining.github.io/3D-Printing-FrontEnd/","https://github.com/KW-text-mining/3D-Printing-FrontEnd/","https://kw-text-mining.github.io"})

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
            pr.setName(printModel.getName());
            // pr.setCreater(printModel.getCreater().getFirstName() + printModel.getCreater().getLastname());
            pr.setAdded(printModel.getAdded());
            pr.setThumbnail(printModel.getThumbnail());
            pr.setLikeCount(printModel.getLikeCount());
            pr.setCollectCount(printModel.getCollectCount());

            pr.setDescription(printModel.getDescription());
            pr.setInstruction(pr.getInstruction());

            pr.setBigCategory(printModel.bigCategory);
            pr.setSmallCategory(printModel.smallCategory);
            pr.setFileCount(printModel.getFileCount());
            pr.setViewCount(printModel.getViewCount());
            pr.setMakeCount(printModel.getMakeCount());
            pr.setRemixCount(printModel.getRemixCount());

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
            pr.setCreater(printModel.getCreater().getFirstName() + printModel.getCreater().getLastname());
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

    @GetMapping("countall")
    public List<BigCategoryResponseDTO> countall() {

        List<BigCategoryResponseDTO> dtos = new ArrayList<>();
        for (BigCategory big : BigCategory.values()) {
            BigCategoryResponseDTO dto = new BigCategoryResponseDTO();
            dto.setName(big.getName());
            Integer count=printModelService.countAllBigCategory( big.getName());
            dto.setData(count);

            dtos.add(dto);
        }

        return dtos;
    }

    @GetMapping("period")
    public List<PeriodDTO> findbigbyperiod(@RequestParam String startDate,@RequestParam String endDate) {

        List<PeriodDTO> dtos = new ArrayList<>();
        for (BigCategory big : BigCategory.values()) {
            PeriodDTO dto = new PeriodDTO();
            dto.setLabel(big.getName());
            Integer count=printModelService.countBigCategory(startDate, endDate, big.getName());
            dto.setValue(count);

            dtos.add(dto);
        }

        return dtos;
    }
    @GetMapping("datayears")
    public List<YearDTO> datayears() {
        String[] years={ "2018","2019","2020","2021","2022"};

        List<YearDTO> dtos = new ArrayList<>();
        for (BigCategory big : BigCategory.values()) {
            YearDTO dto = new YearDTO();
            for (String year : years) {
                String startDate = year + "-01-01";
                String endDate = year + "-12-31";
                Integer count=printModelService.countBigCategory(startDate, endDate, big.getName());
                dto.getData().add(count);
            }
            dto.setName(big.getName());

            dtos.add(dto);
        }

        return dtos;
    }

    @GetMapping("datamonth")
    public List<YearDTO> datamonth() {
        String year = "2022";
        String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        List<YearDTO> dtos = new ArrayList<>();
        for (BigCategory big : BigCategory.values()) {
            YearDTO dto = new YearDTO();
            for (String month : months) {
                String startDate = year + "-"+month+"-01";
                String endDate = year + "-"+month+"-28";
                Integer count=printModelService.countBigCategory(startDate, endDate, big.getName());
                dto.getData().add(count);
            }
            dto.setName(big.getName());

            dtos.add(dto);
        }

        return dtos;
    }

    @GetMapping("dataweek")
    public List<YearDTO> dataweek() {
        String year = "2021";
        String[] months = {"01", "02", "03", "04", "05", "06", "07"};
        List<YearDTO> dtos = new ArrayList<>();
        for (BigCategory big : BigCategory.values()) {
            YearDTO dto = new YearDTO();
            for (String month : months) {
                String startDate = year + "-"+month+"-01";
                String endDate = year + "-"+month+"-02";
                Integer count=printModelService.countBigCategory(startDate, endDate, big.getName());
                dto.getData().add(count);
            }
            dto.setName(big.getName());

            dtos.add(dto);
        }

        return dtos;
    }



    @GetMapping("periodmonth")
    public List<BigCategoryResponseDTO> findbigbyperiodmonth(@RequestParam String year,@RequestParam String month) {

        List<BigCategoryResponseDTO> dtos = new ArrayList<>();
        for (BigCategory big : BigCategory.values()) {
            BigCategoryResponseDTO dto = new BigCategoryResponseDTO();
            dto.setName(big.getName());
            String startDate = year + "-"+month+"-01";
            String endDate = year +"-"+month+"-30";
            Integer count=printModelService.countBigCategory(startDate, endDate, big.getName());
            dto.setData(count);

            dtos.add(dto);
        }

        return dtos;
    }

    @GetMapping("periodday")
    public List<BigCategoryResponseDTO> findbigbyperiodday(@RequestParam String date) {

        List<BigCategoryResponseDTO> dtos = new ArrayList<>();
        for (BigCategory big : BigCategory.values()) {
            BigCategoryResponseDTO dto = new BigCategoryResponseDTO();
            dto.setName(big.getName());
            String startDate = date;
            String endDate =date;
            Integer count=printModelService.countBigCategory(startDate, endDate, big.getName());
            dto.setData(count);

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



    @GetMapping("test")
    public ResponseDataDTO test(@RequestParam String startDate,@RequestParam String endDate,@RequestParam String category) {
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();

        System.out.println(startDate);
        System.out.println(endDate);

        List<PrintModel> printModels = printModelService.findBetween(startDate,endDate);



        List<PrintModelResponseDTO> printModelResponseDTOS = new ArrayList<>();
        for (PrintModel printModel : printModels) {
            PrintModelResponseDTO pr = new PrintModelResponseDTO();
            pr.setId(printModel.getId());
            printModelResponseDTOS.add(pr);
        }
        List<Integer> ids = new ArrayList<>();

        for (PrintModelResponseDTO printModelResponseDTO : printModelResponseDTOS) {
            ids.add(printModelResponseDTO.getId());
        }
        List<String> csvList = new ArrayList<String>();
        File csv = new File("/home/ubuntu/thingiverseModels/src/main/java/com/kwuniv/thingiverseModels/thingiverseData_preprocessing.csv");
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null) { // readLine()은 파일에서 개행된 한 줄의 데이터를 읽어온다.
                List<String> aLine = new ArrayList<String>();
                String[] lineArr = line.split(","); // 파일의 한 줄을 ,로 나누어 배열에 저장 후 리스트로 변환한다.
                String reslString = line;
//                if (lineArr.length > 7) {
//
//                    System.out.println(lineArr[7]);
//                }
                try {
                    if (lineArr.length > 7 && ids.contains(Integer.parseInt(lineArr[7]))) {
                        csvList.add(reslString);
                    }
                } catch (Exception e) {
                }


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close(); // 사용 후 BufferedReader를 닫아준다.
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }




        String filePath = "/home/ubuntu/thingiverseModels/src/main/java/com/kwuniv/thingiverseModels/input.csv";

        File file = null;
        BufferedWriter bw = null;
        String NEWLINE = System.lineSeparator(); // 줄바꿈(\n)

        try {
            file = new File(filePath);
            bw = new BufferedWriter(new FileWriter(file));

            bw.write(",added,big_category,collect_count,description,download_count,file_count,id,instruction,like_count,make_count,root_comment_count,small_category,thumbnail,view_count,name,tag,preprocessing");
            bw.write(NEWLINE);
            System.out.println(csvList);
            for (String string: csvList) {
                bw.write(string);
                bw.write("\n");
            }

            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ProcessBuilder pb = new ProcessBuilder("python3", "/home/ubuntu/thingiverseModels/src/main/java/com/kwuniv/thingiverseModels/LDA.py",category);
        try {
            Process p = pb.start();
            BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String newline = "";
            System.out.println("Running Python starts: " + newline);

            int idx = 0;
            while ((newline = bfr.readLine()) != null){
		    System.out.println(newline);
                if (idx == 0) {
                    responseDataDTO.setCount(Integer.parseInt(newline));
                    idx += 1;
                }
                if (newline.equals("#")) {
                    DTO dto = new DTO();
                    while ((newline = bfr.readLine()) != null){
                        ResultDTO resultDTO = new ResultDTO();
                        if (newline.equals("!")) {
                            responseDataDTO.getDtos().add(dto);
                            break;
                        }
                        String[] temp = newline.split(" ");
                        resultDTO.setPercent(Double.parseDouble(temp[0]));
                        resultDTO.setTopic(temp[1]);
                        dto.getResultDTOList().add(resultDTO);


                    }

                }
                else if(newline.equals("$")) {
                    while ((newline = bfr.readLine()) != null){
                        if (newline.equals("!")) {
                            break;
                        }
                        TopicDTO topicDTO = new TopicDTO();
                        topicDTO.setText(newline);
                        topicDTO.setValue(30);
                        responseDataDTO.getTopics().add(topicDTO);

                    }
                }

            }

        } catch (Exception e) {
            System.out.println("파이썬 오류");
            e.printStackTrace();
        }


        return responseDataDTO;
    }
}

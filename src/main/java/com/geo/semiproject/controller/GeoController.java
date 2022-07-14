package com.geo.semiproject.controller;

import com.geo.semiproject.VO.Geo;
import com.geo.semiproject.VO.GeoEntrc;
import com.geo.semiproject.service.GeoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/geo")
public class GeoController {

    private static final Logger logger = LoggerFactory.getLogger(GeoController.class);

    @Autowired
    private GeoService geoService;

    @RequestMapping(value = "getList.do", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    @ResponseBody
    public String getList() {
        logger.info("TXT File 생성");
        Map<String, Object> result = new LinkedHashMap<String, Object>();

        try {
            // -------------------------------
            // parameter
            // -------------------------------
            List<GeoEntrc> geoList = geoService.getList();

//            result.put("SUCCESS", true);
//            result.put("RESULT", geoList);

            String path = System.getProperty("user.dir") + "\\outFile\\geoData.txt";
            logger.info("생성 경로 : " + path);
            File file = new File(path);

            if(!file.exists()){
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file,false);
            BufferedWriter writer = new BufferedWriter(fw);


            for (GeoEntrc geo : geoList){
                String writeText = geo.getGid() + " || " + geo.getGeom() + " || " + geo.getEntrcSe() + " || "
                        + geo.getOpertDe() + " || " + geo.getSigCd() + " || " + geo.getEqbManSn() + " || "
                        + geo.getBulManNo() + " || " + geo.getEntManNo()
                        + "\n";
                writer.write(writeText);
            }

            writer.close();



        } catch (Throwable t) {
            logger.error(t.getMessage(), t);
//            result.put("SUCCESS", false);
//            result.put("MESSAGE", t.getMessage());
        }

        return "index.html";

    }
}

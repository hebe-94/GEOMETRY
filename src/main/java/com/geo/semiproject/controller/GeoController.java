package com.geo.semiproject.controller;

import com.geo.semiproject.VO.GeoEntrc;
import com.geo.semiproject.service.GeoService;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.WKTWriter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.geotools.geometry.jts.WKTReader2;
import org.geotools.geometry.jts.WKTWriter2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.*;

@Controller
@RequestMapping(value = "/geo")
public class GeoController {

    private static final Logger logger = LoggerFactory.getLogger(GeoController.class);

    @Autowired
    private GeoService geoService;

    @RequestMapping(value = "makeText.do", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    @ResponseBody
    public void makeText() {
        logger.info("TXT File 생성");
        Map<String, Object> result = new LinkedHashMap<String, Object>();

        try {
            // -------------------------------
            // parameter
            // -------------------------------
            List<GeoEntrc> geoList = geoService.getList();

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
        }
    }

    @RequestMapping(value = "makeExcel.do", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    @ResponseBody
    public void makeExcel() {
        logger.info("Excel File 생성");
        Map<String, Object> result = new LinkedHashMap<String, Object>();

        try {
            // -------------------------------
            // parameter
            // -------------------------------
            List<GeoEntrc> geoList = geoService.getList();

            String path = System.getProperty("user.dir") + "\\outFile\\";
            String fileName = "geoData.xlsx";
            logger.info("생성 경로 : " + path + fileName);
            XSSFWorkbook workbook = new XSSFWorkbook();

            XSSFSheet sheet = workbook.createSheet("spbd_entrc");

            Map<Integer, Object[]> excelRows = new TreeMap<>();
            excelRows.put(0,new Object[]{"gid","bulManNO","entrcSe","entManNo","EqbManSn","OpertDe","sigCd","geom"});
            for(int i = 0; i < geoList.size(); i++){
                GeoEntrc excelRow = geoList.get(i);
                excelRows.put(i+1,new Object[]{excelRow.getGid(),excelRow.getBulManNo(),excelRow.getEntrcSe(), excelRow.getEntManNo(),excelRow.getEqbManSn(),
                        excelRow.getOpertDe(),excelRow.getSigCd(),excelRow.getGeom()});
            }
            Set<Integer> keySet = excelRows.keySet();
            List<Integer> keySetList = new ArrayList<>(keySet);
            Collections.sort(keySetList);
            int rownum = 0;
            for (Integer key : keySet) {
                Row row = sheet.createRow(rownum++);
                Object[] objArr = excelRows.get(key);
                int cellnum = 0;
                for (Object obj : objArr) {
                    Cell cell = row.createCell(cellnum++);
                    if (obj instanceof String) {
                        cell.setCellValue((String)obj);
                    } else if (obj instanceof Integer) {
                        cell.setCellValue((Integer)obj);
                    }else if (obj instanceof Float) {
                        cell.setCellValue((Float)obj);
                    }
                }
            }

            FileOutputStream out = new FileOutputStream(new File(path, fileName));
            workbook.write(out);
            out.close();

        } catch (Throwable t) {
            logger.error(t.getMessage(), t);
        }
    }

    @RequestMapping(value = "makeBufferExcel.do", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    @ResponseBody
    public void makeBufferExcel() {
        logger.info("BufferExcel File 생성");
        Map<String, Object> result = new LinkedHashMap<String, Object>();

        try {

            List<GeoEntrc> geoList = geoService.getList();

            String path = System.getProperty("user.dir") + "\\outFile\\";
            String fileName = "GeoList.xlsx";
            logger.info("생성 경로 : " + path + fileName);
            XSSFWorkbook workbook = new XSSFWorkbook();

            XSSFSheet sheet = workbook.createSheet("spbd_entrc");

            Map<Integer, Object[]> excelRows = new TreeMap<>();
            excelRows.put(0,new Object[]{"gid","bulManNO","entrcSe","entManNo","EqbManSn","OpertDe","sigCd","geom","BufferedGeom"});
            for(int i = 0; i < geoList.size(); i++){
                GeoEntrc excelRow = geoList.get(i);
                // 여기서 작업
                WKTReader2 wktReader2 = new WKTReader2();
                Geometry geometry = (Geometry) wktReader2.read(excelRow.getGeom());
                logger.info("-----getGeom-----");
                logger.info(excelRow.getGeom().getClass().getName());
                logger.info("-----Geometry.toString-----");
                logger.info(geometry.toString());
                logger.info("-----Geometry-----");
                logger.info(geometry.getGeometryType()); // point라서
                Geometry buffer = geometry.buffer(2.0);
                logger.info("-----bufferedGeometry-----");
                logger.info(buffer.getGeometryType()); // polygon으로 나옴
                WKTWriter2 wktWriter2 = new WKTWriter2();
                String buffer_String = wktWriter2.write(buffer);
                logger.info("-----buffer_String-----");
                logger.info(buffer_String.getClass().getName()); // String으로 나옴

                excelRows.put(i+1,new Object[]{excelRow.getGid(),excelRow.getBulManNo(),excelRow.getEntrcSe(), excelRow.getEntManNo(),excelRow.getEqbManSn(),
                        excelRow.getOpertDe(),excelRow.getSigCd(),excelRow.getGeom(), buffer_String});
            }
            Set<Integer> keySet = excelRows.keySet();
            List<Integer> keySetList = new ArrayList<>(keySet);
            Collections.sort(keySetList);
            int rownum = 0;
            for (Integer key : keySet) {
                Row row = sheet.createRow(rownum++);
                Object[] objArr = excelRows.get(key);
                int cellnum = 0;
                for (Object obj : objArr) {
                    Cell cell = row.createCell(cellnum++);
                    if (obj instanceof String) {
                        cell.setCellValue((String)obj);
                    } else if (obj instanceof Integer) {
                        cell.setCellValue((Integer)obj);
                    }else if (obj instanceof Float) {
                        cell.setCellValue((Float)obj);
                    }
                }
            }

            FileOutputStream out = new FileOutputStream(new File(path, fileName));
            workbook.write(out);
            out.close();

        } catch (Throwable t) {
            logger.error(t.getMessage(), t);
        }
    }
}

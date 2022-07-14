package com.geo.semiproject.mapper;


import com.geo.semiproject.VO.Geo;
import com.geo.semiproject.VO.GeoEntrc;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class MapperTest {

    @Autowired
    private GeoMapper geoMapper;

    @Test
    public void getList(){
        log.info(System.getProperty("user.dir"));
        List<GeoEntrc> list = geoMapper.getList();
        log.info(list.toString());
    }
}

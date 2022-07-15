package com.geo.semiproject.service;

import com.geo.semiproject.VO.Geo;
import com.geo.semiproject.VO.GeoEntrc;
import com.geo.semiproject.mapper.GeoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeoServiceImple implements GeoService{
    @Autowired
    GeoMapper geoMapper;

    @Override
    public List<GeoEntrc> getList() {
        return geoMapper.getList();
    }

    @Override
    public List<String> getGeoList() {
        return geoMapper.getGeoList();
    }


}

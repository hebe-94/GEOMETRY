package com.geo.semiproject.service;

import com.geo.semiproject.VO.Geo;
import com.geo.semiproject.VO.GeoEntrc;

import java.util.List;

public interface GeoService {
    List<GeoEntrc> getList();
    List<String> getGeoList();
}

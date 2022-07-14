package com.geo.semiproject.mapper;

import com.geo.semiproject.VO.Geo;
import com.geo.semiproject.VO.GeoEntrc;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GeoMapper {
    public List<GeoEntrc> getList();
}

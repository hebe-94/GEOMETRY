package com.geo.semiproject.VO;

import lombok.*;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class GeoEntrc {
    private int gid;
    private int bulManNo;
    private String entrcSe;
    private float entManNo;
    private float eqbManSn;
    private String opertDe;
    private String sigCd;
    private String geom;
}

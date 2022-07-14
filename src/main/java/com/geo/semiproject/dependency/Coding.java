package com.geo.semiproject.dependency;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class Coding {
    @Autowired
    private Computer computer;
}

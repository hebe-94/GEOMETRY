package com.geo.semiproject.dependencyTest;

import com.geo.semiproject.dependency.Coding;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class DependencyTest {

    @Autowired
    private Coding coding;
}

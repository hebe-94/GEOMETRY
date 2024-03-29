package com.geo.semiproject.mybatis;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
@Slf4j
public class MyBatisConfigTest {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    private DataSource dataSource;

    @Test
    public void testDataSource(){
        try(
                Connection conn = dataSource.getConnection();
            )
        {
            log.info("datasource connection : " + conn);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}

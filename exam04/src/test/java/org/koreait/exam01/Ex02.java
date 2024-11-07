package org.koreait.exam01;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import javax.sql.DataSource;


public class Ex02 {

    @BeforeEach
    void init() {
        DataSource ds = new DataSource();
        ds.setDriverClassName("oracle.jdbc.OracleDriver");
        ds.setUsername("spring6");
        ds.setPassword("oracle");
    }
}

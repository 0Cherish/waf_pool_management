package com.maoxian.mapper;

import com.maoxian.pojo.Waf;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WafMapperTest {

    @Autowired
    private WafMapper wafMapper;
    @Test
    void selectListForStatus() {
        List<Waf> wafs = wafMapper.selectListForStatus(0);
        System.out.println(wafs);
    }
}
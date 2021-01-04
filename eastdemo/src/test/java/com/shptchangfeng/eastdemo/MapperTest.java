package com.shptchangfeng.eastdemo;

import com.shptchangfeng.eastdemo.dao.DicStaffMapper;
import com.shptchangfeng.eastdemo.po.DicStaff;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MapperTest {
    @Autowired
    private DicStaffMapper dicStaffMapper;

    @Test
    public void testLoad() {
        long id = 123;
//        dicStaffMapper.delete(id);
        DicStaff dicStaffPo = dicStaffMapper.load(id);
        if (null != dicStaffPo) {
            System.out.println(dicStaffPo.toString());
        } else {
            System.out.println("id:" + id + "'s staffInfo is null.");
        }
    }
}

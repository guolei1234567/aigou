package com.guolei.aigou;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.guolei.aigou.domain.User;
import com.guolei.aigou.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductApplication_8002.class)
public class ProductGeneratorTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testadd(){
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setName("熊大"+i);
            user.setPassword("xxx"+i);
            userService.insert(user);
        }
    }
    @Test
    public void testFindAll(){
        List<User> users = userService.selectList(null);
        for (User user : users) {
            System.out.println(user);

        }


    }

    @Test
    public void testFindAllPage(){

        Page<User> page = new Page(2,5);
//        List<User> userPage = (List<User>)userService.selectPage(page);
        Wrapper<User> wrapper =new EntityWrapper("0");


//        userService.selectPage(page, wrapper);
        Page<User> page1 = userService.selectPage(page,wrapper);
        System.out.println(page1);
        System.out.println(page1.getSize());
        System.out.println(page1.getTotal());
        //System.out.println(page1.getCondition());
        System.out.println("分页==="+page1.getRecords());

    }
}

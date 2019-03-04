package com.guolei.aigou.plat.controller;

import com.guolei.aigou.utils.AjaxResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plat")
public class EmployeeController {
//    访问地址localhost:8001/swagger-ui.html
//    zuul:http://localhost:9527/aigou/taurus/swagger-ui.html#/
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public AjaxResult login(@RequestBody Employee employee) {
        System.out.println(employee.getName());
        System.out.println(employee.getPassword());
       String pswd =  employee.getPassword();
        if (!employee.getName().equals("admin") || !employee.getPassword().equals("admin")) {
            return AjaxResult.me().setSuccess(false).setMsg("登陆失败");
        }
        return AjaxResult.me();
    }

    @RequestMapping("/prin/{id}")
    public void prinEmp(@PathVariable("id") Long id){
        System.out.println("=======华丽热部署测试====="+id);
    }
}

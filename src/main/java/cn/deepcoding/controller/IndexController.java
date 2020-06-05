package cn.deepcoding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by admin on 2020-06-05 01:06
 */
@Controller
public class IndexController {

    @GetMapping("/index")
    public String toIndex(){
        return "ems/login";
    }

    @GetMapping("toRegister")
    public String toRegister(){
        return "ems/regist";
    }


    //保存人员
    @GetMapping("/toSave")
    public String toSave(){
        return "/ems/addEmp";
    }

}

package cn.deepcoding.controller;

import cn.deepcoding.pojo.Emp;
import cn.deepcoding.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by admin on 2020-06-05 03:55
 */
@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;
    //更新员工信息
    @PostMapping("/update")
    public String update(Emp emp){
        empService.update(emp);
        return "redirect:/emp/findAll";
    }




    //删除员工的方法
    @GetMapping("/delete")
    public String delete(String id){
        empService.delete(id);
        return "redirect:/emp/findAll";
    }



    //保存员工信息
    @PostMapping("/save")
    public String save(Emp emp){
        empService.save(emp);
        return "redirect:/emp/findAll";
    }



    //查询所有
    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<Emp> emps = empService.findAll();
        model.addAttribute("emps", emps);
        return "/ems/emplist";
    }

    //根据id查询单人
    @GetMapping("/find")
    public String update(String id,Model model){
        Emp emp = empService.find(id);
        model.addAttribute("emp", emp);
        return "/ems/updateEmp";
    }
}

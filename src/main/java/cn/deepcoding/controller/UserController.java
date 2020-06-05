package cn.deepcoding.controller;

import cn.deepcoding.pojo.User;
import cn.deepcoding.service.UserService;
import cn.deepcoding.utils.ValidateImageCodeUtils;
import com.sun.deploy.net.HttpResponse;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by admin on 2020-06-05 01:31
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    //登录
    @PostMapping("/login")
    public String loing(String username,String password){
        User login = userService.login(username, password);
        if (login!=null){
            return "redirect:/emp/findAll";//跳转到查询所有
        }
        else {
            return "redirect:/index";
        }
    }



    //注册方法
    @PostMapping("/register")
    public String register(User user,String code,HttpSession session){
        String  code1 = (String) session.getAttribute("code");
        if (code1 != null  &&  code1.equalsIgnoreCase(code)){
            userService.register(user);
            return "redirect:/index";
        }else {
            return "redirect:/toRegister";
        }
    }




    @GetMapping("/code")
    public void getImage(HttpSession session,
                         HttpServletResponse response) throws IOException {
        //生成验证码
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        session.setAttribute("code", securityCode);//存入session作用域中
        //相应图片
        ServletOutputStream os = response.getOutputStream();
        ImageIO.write(image, "png",os);
    }

}

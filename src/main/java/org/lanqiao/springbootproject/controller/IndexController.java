package org.lanqiao.springbootproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;


/**
 * @Auther: WDS
 * @Date: 2019/1/4 14:48
 * @Description:
 */
@Controller
public class IndexController {

    @PostMapping("/user/login")
    public String login(String username, String password, Model model, HttpSession session){
        System.out.println(username + "=====" + password);
        String msg = "";
        if(!StringUtils.isEmpty(username)){
            if(!StringUtils.isEmpty(password)){
                if("admin".equals(username) && "123456".equals(password)){
                    session.setAttribute("username",username);
                    return "redirect:/main.html";
                }else{
                    msg = "用户名或密码错误";
                }
            }else {
                msg = "密码不能为空";
            }
        }else {
            msg = "用户名不能为空";
        }
        System.out.println(msg);
        model.addAttribute("msg",msg);
        return "index";
    }
}

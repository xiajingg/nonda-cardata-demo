package nonda.cardata.controller;

import nonda.cardata.model.User;
import nonda.cardata.service.IUserService;
import nonda.cardata.util.CookieUtils;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public ModelAndView login(HttpServletRequest request){
        String username=CookieUtils.getCookie(request,"username");
        String password=CookieUtils.getCookie(request,"password");
        List<User> users=iUserService.findByUsernameAndPassword(username,password);
        if (users.size()==1){
            return new ModelAndView("/order/query");
        }else {
            return new ModelAndView("login");
        }
    }

    @PostMapping(value = "dologin")
    public ModelAndView doLogin(HttpServletResponse response, @RequestParam(value = "username")String username, @RequestParam(value = "password")String password){

        List<User> users=iUserService.findByUsernameAndPassword(username,password);

        if (users.size()==1){
            CookieUtils.writeCookie(response,"username",username);
            CookieUtils.writeCookie(response,"password",password);
            return new ModelAndView("/order/query");
        }else {
            return new ModelAndView("login");
        }

    }
}

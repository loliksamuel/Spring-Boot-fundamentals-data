package org.example.ws.web.api;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The Thymeleaf Controller class is a RESTful web service controller.
 * it looks for html file in resources/templates
 *
 * url      :http://localhost:8080/hello
 * user name: user      or operations
 * password : password  or operations
 *
 * @author Matt Warman
 */
@Controller
public class HelloFormController extends BaseController {


    @RequestMapping(value ="/hello", method = RequestMethod.GET)
    public String hello() {
        return "helloForm";
    }

    @RequestMapping(value ="/hello", method = RequestMethod.POST)
    public String hello(HttpServletRequest req, Model model) {
        String name = req.getParameter("name");
        if (name == null || name=="")
            name = "world";
        model.addAttribute("name", name);
        return "hello";
    }


}

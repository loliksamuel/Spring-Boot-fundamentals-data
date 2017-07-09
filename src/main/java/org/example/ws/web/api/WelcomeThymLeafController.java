package org.example.ws.web.api;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * The Thymeleaf Controller class is a RESTful web service controller.
 * it looks for html file in resources/templates
 *
 * url      :http://localhost:8080/
 *           http://localhost:8080/welcome?name=sam
 *           http://localhost:8080/welcome2
 *           http://localhost:8080/welcome3
 *           http://localhost:8080/properties
 * user name: user      or operations
 * password : password  or operations
 *
 * @author Matt Warman
 */
@Controller
public class WelcomeThymLeafController extends BaseController {

    @Value("${welcome.message:test}")
    private String message = "Hello World";


    @GetMapping("/")
    public String actuator(Model model) {
        model.addAttribute("now", LocalDateTime.now());
        return "actuator";
    }



    @GetMapping("properties")
    @ResponseBody
    public java.util.Properties properties() {
        return System.getProperties();
    }

    @RequestMapping(value ="/welcome")
    public String welcome(Map<String, Object> model, HttpServletRequest req) {
        String name = req.getParameter("name");
        model.put("message", this.message);
        model.put("name", name);
        return "welcome";
    }




    /**
     * Web service endpoint to fetch all Greeting entities. The service returns
     * the collection of Greeting entities as JSON.
     * @return A ResponseEntity containing a Collection of Greeting objects.*/
    @RequestMapping(  value = "/welcome3", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String welcome() {

        logger.info("> welcome3.html");
        return "welcome3";

    }


    /**
     * Web service endpoint to fetch all Greeting entities. The service returns
     * the collection of Greeting entities as JSON.
     * @return A ResponseEntity containing a Collection of Greeting objects.*/
    @RequestMapping(  value = "/welcome2", method = RequestMethod.GET)
    @ResponseBody//return a string
    public String welcome2(HttpServletRequest req) {
        String name = req.getParameter("name");
        if (name == null)
            name = "world";
        logger.info("> welcome.html");
        String msg = "welcome";//welcomeMessage.getMessage(name);
        //return "index";
        return "<h1>"+msg+" "+name+"</h1>";
    }

//
//    /**
//     * url : welcome4?name=lolik
//     **/
//    @RequestMapping(  value = "/welcome4", method = RequestMethod.GET)
//    public String welcome4(HttpServletRequest req, Model model) {
//
//        String name = req.getParameter("name");
//        if (name == null)
//            name = "world";
//        logger.info("> welcome.html");
//        String msg = "welcome";//welcomeMessage.getMessage(name);
//        //return "index";
//
//        model.addAttribute("message", msg);
//        model.addAttribute("name", name);
//        return "welcome";//this tell spring to render templates/welcome.html
//    }
}

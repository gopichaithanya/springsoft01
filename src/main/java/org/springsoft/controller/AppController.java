package org.springsoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chaitu on 6/19/2017.
 */
@Controller
public class AppController {
    @RequestMapping("/")
    String home(ModelMap modal) {
        modal.addAttribute("title","EMPLOYEE MANAGEMENT SYSTEMS");
        return "index";
    }

    @RequestMapping("/partials/{page}")
    String partialHandler(@PathVariable("page") final String page) {
        return page;
    }
}

package com.taxiservicespring.controller.shared;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.taxiservicespring.util.constant.WebPage.*;

@Controller
public class HomeController {

    @GetMapping(value = {"/index", "/"})
    public String index(HttpSession session, Model model, HttpServletRequest request) {
        return MAIN_PAGE;
    }
}

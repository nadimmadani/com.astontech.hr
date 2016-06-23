package com.astontech.hr.controllers;

import com.astontech.hr.repositories.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ryanmada1 on 6/14/2016.
 */
@Controller
public class IndexController {


    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
}

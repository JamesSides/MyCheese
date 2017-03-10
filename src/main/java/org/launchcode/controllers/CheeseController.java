package org.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringJoiner;

/**
 * Created by stephen on 3/9/17.
 */
@Controller
@RequestMapping(value = "cheese")
public class CheeseController {

    private static HashMap<String, String> cheeses = new HashMap<>();

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");

        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@RequestParam(name = "name") String name, @RequestParam(name = "description", required = false, defaultValue = "Empty Description") String description) {
        cheeses.put(name, description);
        return "redirect:";
    }

}

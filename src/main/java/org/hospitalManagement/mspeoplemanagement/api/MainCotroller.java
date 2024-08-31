package org.hospitalManagement.mspeoplemanagement.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainCotroller {

    @RequestMapping(value = "index")
    public String showIndexPage(Model model) {
        model.addAttribute("greeting", "Welcome to our dynamic website!");
        return "index";
    }

}

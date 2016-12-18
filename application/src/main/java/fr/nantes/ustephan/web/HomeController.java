package fr.nantes.ustephan.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ughostephan on 25/11/2016.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(ModelMap model) {
        return "index";
    }

}

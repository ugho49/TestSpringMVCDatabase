package fr.nantes.ustephan.web.controller;

import fr.nantes.ustephan.web.entity.City;
import fr.nantes.ustephan.web.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by ughostephan on 25/11/2016.
 */
@Controller
public class HomeController {

    @Autowired
    CityService cityService;

    @RequestMapping("/")
    public String index(ModelMap model) {
        return "index";
    }

    @RequestMapping("/cities")
    public String cities(ModelMap model) {
        List<City> cities = cityService.findAll();
        model.addAttribute("cities", cities);
        return "cities";
    }

}

package fr.nantes.ustephan.world.controller;

import fr.nantes.ustephan.world.entity.City;
import fr.nantes.ustephan.world.entity.Country;
import fr.nantes.ustephan.world.entity.Language;
import fr.nantes.ustephan.world.service.CityService;
import fr.nantes.ustephan.world.service.CountryService;
import fr.nantes.ustephan.world.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by ughostephan on 25/11/2016.
 */
@Controller
public class WorldController {

    @Autowired
    CityService cityService;
    @Autowired
    CountryService countryService;
    @Autowired
    LanguageService languageService;

    @RequestMapping("/world")
    public String cities(ModelMap model) {
        List<City> cities = cityService.findAll();
        List<Country> countries = countryService.findAll();
        List<Language> languages = languageService.findAll();


        TreeMap<String, List<City>> citiesOrdered = new TreeMap<>();
        TreeMap<String, List<Country>> countriesOrdered = new TreeMap<>();
        TreeMap<String, List<Language>> languagesOrdered = new TreeMap<>();


        for (City c : cities) {
            if (!citiesOrdered.containsKey(c.getCountryCode())) {
                citiesOrdered.put(c.getCountryCode(), new ArrayList<>());
            }

            final List<City> cByCode = citiesOrdered.get(c.getCountryCode());
            cByCode.add(c);

            citiesOrdered.replace(c.getCountryCode(), cByCode);
        }

        for (Country c : countries) {
            if (!countriesOrdered.containsKey(c.getContinent())) {
                countriesOrdered.put(c.getContinent(), new ArrayList<>());
            }

            final List<Country> cByCode = countriesOrdered.get(c.getContinent());
            cByCode.add(c);

            countriesOrdered.replace(c.getContinent(), cByCode);
        }

        for (Language l : languages) {
            if (!languagesOrdered.containsKey(l.getCountryCode())) {
                languagesOrdered.put(l.getCountryCode(), new ArrayList<>());
            }

            final List<Language> lByCode = languagesOrdered.get(l.getCountryCode());
            lByCode.add(l);

            languagesOrdered.replace(l.getCountryCode(), lByCode);
        }

        model.addAttribute("cities", citiesOrdered);
        model.addAttribute("countries", countriesOrdered);
        model.addAttribute("languages", languagesOrdered);

        return "world";
    }

}

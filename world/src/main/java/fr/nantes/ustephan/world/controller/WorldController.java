package fr.nantes.ustephan.world.controller;

import fr.nantes.ustephan.world.entity.City;
import fr.nantes.ustephan.world.entity.Country;
import fr.nantes.ustephan.world.entity.Language;
import fr.nantes.ustephan.world.form.CityForm;
import fr.nantes.ustephan.world.helper.ListOrderHelper;
import fr.nantes.ustephan.world.service.CityService;
import fr.nantes.ustephan.world.service.CountryService;
import fr.nantes.ustephan.world.service.LanguageService;
import fr.nantes.ustephan.world.validator.CityFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by ughostephan on 25/11/2016.
 */
@Controller
public class WorldController {

    @Autowired
    private CityService cityService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private LanguageService languageService;
    @Autowired
    private CityFormValidator cityFormValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(cityFormValidator);
    }

    @ModelAttribute(name = "cityForm")
    private CityForm getCityForm() {
        return new CityForm();
    }

    @RequestMapping("/world")
    public String world(ModelMap model) {
        List<City> cities = cityService.findAll();
        List<Country> countries = countryService.findAll();
        List<Language> languages = languageService.findAll();

        TreeMap<String, List<City>> citiesOrdered = ListOrderHelper.citiesOrdered(cities);
        TreeMap<String, List<Country>> countriesOrdered = ListOrderHelper.countriesOrdered(countries);
        TreeMap<String, List<Language>> languagesOrdered = ListOrderHelper.languagesOrdered(languages);

        model.addAttribute("cities", citiesOrdered);
        model.addAttribute("countries", countriesOrdered);
        model.addAttribute("languages", languagesOrdered);

        return "world";
    }

    @RequestMapping("/districts/{countryCode}")
    @ResponseBody
    public List<String> findAllDistrictsByCountry(@PathVariable String countryCode) {
        return cityService.findAllDistinctDistrictsByCountry(countryCode);
    }

    @RequestMapping("/addCity")
    public String addCityForm(Model model) {
        List<Country> countries = countryService.findAll();
        TreeMap<String, List<Country>> countriesOrdered = ListOrderHelper.countriesOrdered(countries);
        model.addAttribute("countries", countriesOrdered);
        return "addCity";
    }

    @RequestMapping(value = "/addCity", method = RequestMethod.POST)
    public ModelAndView addCity(@Valid CityForm form, BindingResult result, RedirectAttributes redir) {

        ModelAndView modelAndView = new ModelAndView();

        if (result.hasErrors()) {
            redir.addFlashAttribute("cityForm", form);
            redir.addFlashAttribute("org.springframework.validation.BindingResult.cityForm", result);
            modelAndView.setViewName("redirect:/addCity");
        } else {
            City newCity = new City();
            newCity.setName(form.getName());
            newCity.setCountryCode(form.getCountryCode());
            newCity.setDistrict(form.getDistrict());
            newCity.setPopulation(form.getPopulation());
            cityService.create(newCity);
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
    }
}

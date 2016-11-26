package fr.nantes.ustephan.web.controller.api;

import fr.nantes.ustephan.web.entity.Country;
import fr.nantes.ustephan.web.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;


/**
 * Created by ughostephan on 26/11/2016.
 */

@RestControllerAdvice
@RequestMapping("/api/country")
public class CountryApiController {

    @Autowired
    private CountryService countryService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Country> findAll() {
        return countryService.findAll();
    }

}

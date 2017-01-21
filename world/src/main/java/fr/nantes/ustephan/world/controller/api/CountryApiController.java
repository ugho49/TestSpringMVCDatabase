package fr.nantes.ustephan.world.controller.api;

import fr.nantes.ustephan.world.entity.Country;
import fr.nantes.ustephan.world.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;


/**
 * Created by ughostephan on 26/11/2016.
 */
@RestController
@RequestMapping("/api/country")
public class CountryApiController {

    @Autowired
    private CountryService countryService;

    /**
     * Find all list.
     *
     * @return the list
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Country> findAll() {
        return countryService.findAll();
    }

}

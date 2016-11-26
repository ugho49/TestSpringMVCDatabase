package fr.nantes.ustephan.web.controller.api;

import fr.nantes.ustephan.web.entity.City;
import fr.nantes.ustephan.web.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;


/**
 * Created by ughostephan on 26/11/2016.
 */

@RestControllerAdvice
@RequestMapping("/api/city")
public class CityApiController {

    @Autowired
    private CityService cityService;

    @RequestMapping(method = RequestMethod.GET)
    public List<City> findAll() {
        return cityService.findAll();
    }

}

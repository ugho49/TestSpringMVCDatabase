package fr.nantes.ustephan.world.controller.api;

import fr.nantes.ustephan.world.entity.City;
import fr.nantes.ustephan.world.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;


/**
 * Created by ughostephan on 26/11/2016.
 */
@RestController
@RequestMapping("/api/city")
public class CityApiController {

    @Autowired
    private CityService cityService;

    /**
     * Find all list.
     *
     * @return the list
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<City> findAll() {
        return cityService.findAll();
    }

    /**
     * Find all by country list.
     *
     * @param countryCode the country code
     * @return the list
     */
    @RequestMapping("/{countryCode}")
    public List<City> findAllByCountry(@PathVariable String countryCode) {
        return cityService.findAllByCountry(countryCode);
    }

    /**
     * Find all by criteria list.
     *
     * @param countryCode   the country code
     * @param minPopulation the min population
     * @param firstLetter   the first letter
     * @return the list
     */
    @RequestMapping("/search")
    public List<City> findAllByCriteria(@RequestParam(value = "countryCode") String countryCode,
                                       @RequestParam(value = "minPopulation", required = false) Integer minPopulation,
                                       @RequestParam(value = "firstLetter", required = false) Character firstLetter) {
        return cityService.findAllByCriteria(countryCode, minPopulation, firstLetter);
    }

}

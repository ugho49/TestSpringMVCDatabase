package fr.nantes.ustephan.world.service;

import fr.nantes.ustephan.world.entity.City;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Created by ughostephan on 26/11/2016.
 */
public interface CityService {
    City create(City city);
    City update(City city) throws EntityNotFoundException;
    City delete(int id) throws EntityNotFoundException;
    City findById(int id);
    List<City> findAll();

    List<City> findAllByCountry(String countryCode);

    List<City> findAllByCriteria(String countryCode, Integer minPopulation, Character firstLetter);

}

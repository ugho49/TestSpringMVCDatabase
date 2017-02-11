package fr.nantes.ustephan.world.service;

import fr.nantes.ustephan.world.entity.City;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Created by ughostephan on 26/11/2016.
 */
public interface CityService {
    /**
     * Create city.
     *
     * @param city the city
     * @return the city
     */
    City create(City city);

    /**
     * Update city.
     *
     * @param city the city
     * @return the city
     * @throws EntityNotFoundException the entity not found exception
     */
    City update(City city) throws EntityNotFoundException;

    /**
     * Delete city.
     *
     * @param id the id
     * @return the city
     * @throws EntityNotFoundException the entity not found exception
     */
    City delete(int id) throws EntityNotFoundException;

    /**
     * Find by id city.
     *
     * @param id the id
     * @return the city
     */
    City findById(int id);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<City> findAll();

    /**
     * Find all by country list.
     *
     * @param countryCode the country code
     * @return the list
     */
    List<City> findAllByCountry(String countryCode);

    /**
     * Find all by criteria list.
     *
     * @param countryCode   the country code
     * @param minPopulation the min population
     * @param firstLetter   the first letter
     * @return the list
     */
    List<City> findAllByCriteria(String countryCode, Integer minPopulation, Character firstLetter);

    /**
     * Find all distinct districts by country list.
     *
     * @param countryCode the country code
     * @return the list
     */
    List<String> findAllDistinctDistrictsByCountry(String countryCode);
}

package fr.nantes.ustephan.world.service;

import fr.nantes.ustephan.world.entity.Country;

import java.util.List;

/**
 * Created by ughostephan on 26/11/2016.
 */
public interface CountryService {
    /**
     * Find by id country.
     *
     * @param id the id
     * @return the country
     */
    public Country findById(String id);

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<Country> findAll();
}

package fr.nantes.ustephan.world.service;

import fr.nantes.ustephan.world.entity.Country;

import java.util.List;

/**
 * Created by ughostephan on 26/11/2016.
 */
public interface CountryService {
    public Country findById(String id);
    public List<Country> findAll();
}

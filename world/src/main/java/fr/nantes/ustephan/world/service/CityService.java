package fr.nantes.ustephan.world.service;

import fr.nantes.ustephan.world.entity.City;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Created by ughostephan on 26/11/2016.
 */
public interface CityService {
    public City create(City city);
    public City update(City city) throws EntityNotFoundException;
    public City delete(int id) throws EntityNotFoundException;
    public City findById(int id);
    public List<City> findAll();
}

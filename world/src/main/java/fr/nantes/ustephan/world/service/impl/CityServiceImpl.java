package fr.nantes.ustephan.world.service.impl;

import fr.nantes.ustephan.world.entity.City;
import fr.nantes.ustephan.world.repository.CityRepository;
import fr.nantes.ustephan.world.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ughostephan on 26/11/2016.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    @Transactional
    public City create(City city) {
        return cityRepository.save(city);
    }

    @Override
    @Transactional(rollbackFor=EntityNotFoundException.class)
    public City update(City city) throws EntityNotFoundException {
        City updatedCity = cityRepository.findOne(city.getId());

        if (updatedCity == null)
            throw new EntityNotFoundException();

        updatedCity.setName(city.getName());
        updatedCity.setCountryCode(city.getCountryCode());
        updatedCity.setDistrict(city.getDistrict());
        updatedCity.setPopulation(city.getPopulation());

        return updatedCity;
    }

    @Override
    @Transactional(rollbackFor=EntityNotFoundException.class)
    public City delete(int id) throws EntityNotFoundException {
        City deletedCity = cityRepository.findOne(id);

        if (deletedCity == null)
            throw new EntityNotFoundException();

        cityRepository.delete(deletedCity);
        return deletedCity;
    }

    @Override
    @Transactional
    public City findById(int id) {
        return cityRepository.findOne(id);
    }

    @Override
    @Transactional
    public List<City> findAll() {
        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.ASC, "countryCode"));
        orders.add(new Sort.Order(Sort.Direction.ASC, "name"));

        Sort sort = new Sort(orders);

        return cityRepository.findAll(sort);
    }

}

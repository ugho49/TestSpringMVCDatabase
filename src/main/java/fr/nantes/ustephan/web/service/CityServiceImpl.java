package fr.nantes.ustephan.web.service;

import fr.nantes.ustephan.web.entity.City;
import fr.nantes.ustephan.web.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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
        return cityRepository.findAll();
    }

}

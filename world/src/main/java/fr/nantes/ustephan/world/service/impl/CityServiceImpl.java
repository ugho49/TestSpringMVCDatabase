package fr.nantes.ustephan.world.service.impl;

import fr.nantes.ustephan.world.entity.City;
import fr.nantes.ustephan.world.repository.CityRepository;
import fr.nantes.ustephan.world.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ughostephan on 26/11/2016.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private EntityManagerFactory emf;

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

    @Override
    @Transactional
    public List<City> findAllByCountry(String countryCode) {
        EntityManager em = emf.createEntityManager();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT c FROM City c ");
        sb.append("WHERE c.countryCode = :code ");
        sb.append("ORDER BY c.population DESC ");

        Query query = em.createQuery(sb.toString());
        query.setParameter("code", countryCode);
        List<City> cities = query.getResultList();

        return cities;
    }

    @Override
    @Transactional
    public List<City> findAllByCriteria(String countryCode, Integer minPopulation, Character firstLetter) {
        EntityManager em = emf.createEntityManager();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT c FROM City c ");
        sb.append("WHERE c.countryCode = :countryCode ");

        if (minPopulation != null) {
            sb.append("AND c.population > :minPopulation ");
        }

        if (firstLetter != null) {
            sb.append("AND SUBSTRING(c.name, 1, 1) = :firstLetter ");
        }

        sb.append("ORDER BY c.name ASC ");

        Query query = em.createQuery(sb.toString());
        query.setParameter("countryCode", countryCode);

        if (minPopulation != null) {
            query.setParameter("minPopulation", minPopulation);
        }

        if (firstLetter != null) {
            query.setParameter("firstLetter", firstLetter.toString());
        }

        List<City> cities = query.getResultList();

        return cities;
    }

    @Override
    @Transactional
    public List<String> findAllDistinctDistricts() {
        return cityRepository.findAllDistinctDistricts();
    }

}

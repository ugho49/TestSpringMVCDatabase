package fr.nantes.ustephan.world.service;

import fr.nantes.ustephan.UStephanTestConfiguration;
import fr.nantes.ustephan.world.entity.City;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ughostephan on 10/02/2017.
 */
@ContextConfiguration(classes = UStephanTestConfiguration.class)
@RunWith(SpringRunner.class)
@DataJpaTest
public class CityServiceTest {

    @Autowired
    private CityService cityService;

    @Test
    public void create() {
        City entity1 = new City();
        entity1.setCountryCode("FRA");
        entity1.setName("test");
        entity1.setDistrict("test");
        entity1.setPopulation(1030);
        entity1 = cityService.create(entity1);

        Assert.assertEquals(Integer.valueOf(1), entity1.getId());
        Assert.assertEquals("FRA", entity1.getCountryCode());
        Assert.assertEquals("test", entity1.getName());
        Assert.assertEquals("test", entity1.getDistrict());
        Assert.assertEquals(Integer.valueOf(1030), entity1.getPopulation());

        final City entity2 = new City();
        entity2.setCountryCode("FRA");
        entity2.setName("test2");
        entity2.setDistrict("test2");
        entity2.setPopulation(1030);
        cityService.create(entity2);

        Assert.assertEquals(2, cityService.findAll().size());
        Assert.assertEquals(Integer.valueOf(2), cityService.findById(2).getId());

    }

    @Test
    public void update() throws Exception {
        City entity = new City();
        entity.setCountryCode("f");
        entity.setName("f");
        entity.setDistrict("f");
        entity.setPopulation(1);
        entity = cityService.create(entity);

        final City entityToUpdate = cityService.findById(entity.getId());
        entityToUpdate.setCountryCode("fa");
        entityToUpdate.setName("fa");
        entityToUpdate.setDistrict("fa");
        entityToUpdate.setPopulation(2);
        cityService.update(entityToUpdate);

        final City entityUpdated = cityService.findById(entity.getId());
        Assert.assertEquals("fa", entityUpdated.getCountryCode());
        Assert.assertEquals("fa", entityUpdated.getName());
        Assert.assertEquals("fa", entityUpdated.getDistrict());
        Assert.assertEquals(Integer.valueOf(2), entityUpdated.getPopulation());
    }

    @Test
    public void delete() throws Exception {
        final City entity = new City();
        entity.setCountryCode("f");
        entity.setName("f");
        entity.setDistrict("f");
        entity.setPopulation(1);
        cityService.create(entity);

        Assert.assertEquals(1, cityService.findAll().size());

        cityService.delete(entity.getId());

        Assert.assertEquals(0, cityService.findAll().size());
    }

    @Test
    public void findById() throws Exception {
        City entity = new City();
        entity.setCountryCode("f");
        entity.setName("f");
        entity.setDistrict("f");
        entity.setPopulation(1);
        entity = cityService.create(entity);

        final City entityFromBase = cityService.findById(entity.getId());
        Assert.assertTrue(entityFromBase != null);
    }

    @Test
    public void findAll() throws Exception {

        Assert.assertEquals(0, cityService.findAll().size());

        for (int i = 0; i < 3; i++) {
            final City entity = new City();
            entity.setCountryCode("f");
            entity.setName("f");
            entity.setDistrict("f");
            entity.setPopulation(1);
            cityService.create(entity);
        }

        Assert.assertEquals(3, cityService.findAll().size());
    }

    @Test
    public void findAllByCountry() throws Exception {

        Assert.assertEquals(0, cityService.findAllByCountry("USA").size());

        for (int i = 0; i < 2; i++) {
            final City entity = new City();
            entity.setCountryCode("USA");
            entity.setName("usa");
            entity.setDistrict("usa");
            entity.setPopulation(1);
            cityService.create(entity);
        }

        for (int i = 0; i < 4; i++) {
            final City entity = new City();
            entity.setCountryCode("FRA");
            entity.setName("fra");
            entity.setDistrict("fra");
            entity.setPopulation(1);
            cityService.create(entity);
        }

        for (int i = 0; i < 3; i++) {
            final City entity = new City();
            entity.setCountryCode("AFR");
            entity.setName("afr");
            entity.setDistrict("afr");
            entity.setPopulation(1);
            cityService.create(entity);
        }

        Assert.assertEquals(4, cityService.findAllByCountry("FRA").size());

    }

}
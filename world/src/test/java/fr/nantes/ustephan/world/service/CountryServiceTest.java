package fr.nantes.ustephan.world.service;

import fr.nantes.ustephan.UStephanTestConfiguration;
import fr.nantes.ustephan.world.entity.City;
import fr.nantes.ustephan.world.entity.Country;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ughostephan on 11/02/2017.
 */
@ContextConfiguration(classes = UStephanTestConfiguration.class)
@RunWith(SpringRunner.class)
@DataJpaTest
public class CountryServiceTest {

    @Autowired
    private CountryService countryService;

    @Test
    @Ignore
    public void findById() {

    }

    @Test
    public void findAll() {
        Assert.assertEquals(0, countryService.findAll().size());

        for (int i = 0; i < 3; i++) {
            final Country entity = new Country();

            entity.setCode("f"+i);
            entity.setName("f");
            entity.setContinent("f");
            entity.setSurfaceArea("f");
            entity.setIndepYear(Short.valueOf("1"));
            entity.setRegion("f");
            entity.setPopulation(2);
            entity.setLifeExpectancy(2f);
            entity.setGnp(2f);
            entity.setGnpOld(2f);
            entity.setLocalName("f");
            entity.setGovernmentForm("f");
            entity.setHeadOfState("f");
            entity.setCapital(2);
            entity.setCode2("f");

            countryService.create(entity);
        }

        Assert.assertEquals(3, countryService.findAll().size());
    }

}
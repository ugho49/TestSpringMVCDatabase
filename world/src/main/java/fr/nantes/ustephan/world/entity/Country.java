package fr.nantes.ustephan.world.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ughostephan on 25/11/2016.
 */
@Entity
@Table(name = "country")
public class Country implements Serializable {

    @Id
    private String code;
    private String name;
    private String continent;
    private String region;
    private String surfaceArea;
    private Short indepYear;
    private Integer population;
    private Float lifeExpectancy;
    private Float gnp;
    private Float gnpOld;
    private String localName;
    private String governmentForm;
    private String headOfState;
    private Integer capital;
    private String code2;

    /**
     * Instantiates a new Country.
     */
    public Country() {
    }

    /**
     * Instantiates a new Country.
     *
     * @param code           the code
     * @param name           the name
     * @param continent      the continent
     * @param region         the region
     * @param surfaceArea    the surface area
     * @param indepYear      the indep year
     * @param population     the population
     * @param lifeExpectancy the life expectancy
     * @param gnp            the gnp
     * @param gnpOld         the gnp old
     * @param localName      the local name
     * @param governmentForm the government form
     * @param headOfState    the head of state
     * @param capital        the capital
     * @param code2          the code 2
     */
    public Country(String code, String name, String continent, String region, String surfaceArea, Short indepYear, Integer population, Float lifeExpectancy, Float gnp, Float gnpOld, String localName, String governmentForm, String headOfState, Integer capital, String code2) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surfaceArea = surfaceArea;
        this.indepYear = indepYear;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
        this.gnp = gnp;
        this.gnpOld = gnpOld;
        this.localName = localName;
        this.governmentForm = governmentForm;
        this.headOfState = headOfState;
        this.capital = capital;
        this.code2 = code2;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets continent.
     *
     * @return the continent
     */
    public String getContinent() {
        return continent;
    }

    /**
     * Sets continent.
     *
     * @param continent the continent
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }

    /**
     * Gets region.
     *
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets region.
     *
     * @param region the region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Gets surface area.
     *
     * @return the surface area
     */
    public String getSurfaceArea() {
        return surfaceArea;
    }

    /**
     * Sets surface area.
     *
     * @param surfaceArea the surface area
     */
    public void setSurfaceArea(String surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    /**
     * Gets indep year.
     *
     * @return the indep year
     */
    public Short getIndepYear() {
        return indepYear;
    }

    /**
     * Sets indep year.
     *
     * @param indepYear the indep year
     */
    public void setIndepYear(Short indepYear) {
        this.indepYear = indepYear;
    }

    /**
     * Gets population.
     *
     * @return the population
     */
    public Integer getPopulation() {
        return population;
    }

    /**
     * Sets population.
     *
     * @param population the population
     */
    public void setPopulation(Integer population) {
        this.population = population;
    }

    /**
     * Gets life expectancy.
     *
     * @return the life expectancy
     */
    public Float getLifeExpectancy() {
        return lifeExpectancy;
    }

    /**
     * Sets life expectancy.
     *
     * @param lifeExpectancy the life expectancy
     */
    public void setLifeExpectancy(Float lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    /**
     * Gets gnp.
     *
     * @return the gnp
     */
    public Float getGnp() {
        return gnp;
    }

    /**
     * Sets gnp.
     *
     * @param gnp the gnp
     */
    public void setGnp(Float gnp) {
        this.gnp = gnp;
    }

    /**
     * Gets gnp old.
     *
     * @return the gnp old
     */
    public Float getGnpOld() {
        return gnpOld;
    }

    /**
     * Sets gnp old.
     *
     * @param gnpOld the gnp old
     */
    public void setGnpOld(Float gnpOld) {
        this.gnpOld = gnpOld;
    }

    /**
     * Gets local name.
     *
     * @return the local name
     */
    public String getLocalName() {
        return localName;
    }

    /**
     * Sets local name.
     *
     * @param localName the local name
     */
    public void setLocalName(String localName) {
        this.localName = localName;
    }

    /**
     * Gets government form.
     *
     * @return the government form
     */
    public String getGovernmentForm() {
        return governmentForm;
    }

    /**
     * Sets government form.
     *
     * @param governmentForm the government form
     */
    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    /**
     * Gets head of state.
     *
     * @return the head of state
     */
    public String getHeadOfState() {
        return headOfState;
    }

    /**
     * Sets head of state.
     *
     * @param headOfState the head of state
     */
    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    /**
     * Gets capital.
     *
     * @return the capital
     */
    public Integer getCapital() {
        return capital;
    }

    /**
     * Sets capital.
     *
     * @param capital the capital
     */
    public void setCapital(Integer capital) {
        this.capital = capital;
    }

    /**
     * Gets code 2.
     *
     * @return the code 2
     */
    public String getCode2() {
        return code2;
    }

    /**
     * Sets code 2.
     *
     * @param code2 the code 2
     */
    public void setCode2(String code2) {
        this.code2 = code2;
    }
}

package fr.nantes.ustephan.world.form;

/**
 * Created by ughostephan on 21/01/2017.
 */
public class CityForm {

    private String name;

    private String countryCode;

    private String district;

    private String otherDistrict;

    private Integer population;

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
     * Gets country code.
     *
     * @return the country code
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets country code.
     *
     * @param countryCode the country code
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Gets district.
     *
     * @return the district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * Sets district.
     *
     * @param district the district
     */
    public void setDistrict(String district) {
        this.district = district;
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
     * Gets other district.
     *
     * @return the other district
     */
    public String getOtherDistrict() {
        return otherDistrict;
    }

    /**
     * Sets other district.
     *
     * @param otherDistrict the other district
     */
    public void setOtherDistrict(String otherDistrict) {
        this.otherDistrict = otherDistrict;
    }
}

package fr.nantes.ustephan.world.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ughostephan on 25/11/2016.
 */
@Entity
@Table(name = "countrylanguage")
@IdClass(value = LanguagePK.class)
public class Language implements Serializable {

    @Id
    private String countryCode;
    @Id
    private String language;
    private Character isOfficial;
    private Float percentage;

    /**
     * Instantiates a new Language.
     */
    public Language() {
    }

    /**
     * Instantiates a new Language.
     *
     * @param countryCode the country code
     * @param language    the language
     * @param isOfficial  the is official
     * @param percentage  the percentage
     */
    public Language(String countryCode, String language, Character isOfficial, Float percentage) {
        this.countryCode = countryCode;
        this.language = language;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
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
     * Gets language.
     *
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets language.
     *
     * @param language the language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Gets is official.
     *
     * @return the is official
     */
    public Character getIsOfficial() {
        return isOfficial;
    }

    /**
     * Sets is official.
     *
     * @param isOfficial the is official
     */
    public void setIsOfficial(Character isOfficial) {
        this.isOfficial = isOfficial;
    }

    /**
     * Gets percentage.
     *
     * @return the percentage
     */
    public Float getPercentage() {
        return percentage;
    }

    /**
     * Sets percentage.
     *
     * @param percentage the percentage
     */
    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }
}

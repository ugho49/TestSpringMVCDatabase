package fr.nantes.ustephan.world.entity;

import java.io.Serializable;

/**
 * Created by ughostephan on 25/11/2016.
 */
public class LanguagePK implements Serializable {

    private String countryCode;
    private String language;

    /**
     * Instantiates a new Language pk.
     */
    public LanguagePK() {
    }

    /**
     * Instantiates a new Language pk.
     *
     * @param countryCode the country code
     * @param language    the language
     */
    public LanguagePK(String countryCode, String language) {
        this.countryCode = countryCode;
        this.language = language;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LanguagePK that = (LanguagePK) o;

        if (countryCode != null ? !countryCode.equals(that.countryCode) : that.countryCode != null) return false;
        return language != null ? language.equals(that.language) : that.language == null;

    }

    @Override
    public int hashCode() {
        int result = countryCode != null ? countryCode.hashCode() : 0;
        result = 31 * result + (language != null ? language.hashCode() : 0);
        return result;
    }
}

package fr.nantes.ustephan.web.entity;

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

    public Language() {
    }

    public Language(String countryCode, String language, Character isOfficial, Float percentage) {
        this.countryCode = countryCode;
        this.language = language;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Character getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(Character isOfficial) {
        this.isOfficial = isOfficial;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }
}

package fr.nantes.ustephan.world.helper;

import fr.nantes.ustephan.world.entity.City;
import fr.nantes.ustephan.world.entity.Country;
import fr.nantes.ustephan.world.entity.Language;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by ughostephan on 21/01/2017.
 */
public class ListOrderHelper {

    /**
     * Cities ordered tree map.
     *
     * @param cities the cities
     * @return the tree map
     */
    public static TreeMap<String, List<City>> citiesOrdered(List<City> cities) {
        TreeMap<String, List<City>> citiesOrdered = new TreeMap<>();

        for (City c : cities) {
            if (!citiesOrdered.containsKey(c.getCountryCode())) {
                citiesOrdered.put(c.getCountryCode(), new ArrayList<>());
            }

            final List<City> cByCode = citiesOrdered.get(c.getCountryCode());
            cByCode.add(c);

            citiesOrdered.replace(c.getCountryCode(), cByCode);
        }

        return citiesOrdered;
    }

    /**
     * Countries ordered tree map.
     *
     * @param countries the countries
     * @return the tree map
     */
    public static TreeMap<String, List<Country>> countriesOrdered(List<Country> countries) {
        TreeMap<String, List<Country>> countriesOrdered = new TreeMap<>();

        for (Country c : countries) {
            if (!countriesOrdered.containsKey(c.getContinent())) {
                countriesOrdered.put(c.getContinent(), new ArrayList<>());
            }

            final List<Country> cByCode = countriesOrdered.get(c.getContinent());
            cByCode.add(c);

            countriesOrdered.replace(c.getContinent(), cByCode);
        }

        return countriesOrdered;
    }

    /**
     * Languages ordered tree map.
     *
     * @param languages the languages
     * @return the tree map
     */
    public static TreeMap<String, List<Language>> languagesOrdered(List<Language> languages) {
        TreeMap<String, List<Language>> languagesOrdered = new TreeMap<>();

        for (Language l : languages) {
            if (!languagesOrdered.containsKey(l.getCountryCode())) {
                languagesOrdered.put(l.getCountryCode(), new ArrayList<>());
            }

            final List<Language> lByCode = languagesOrdered.get(l.getCountryCode());
            lByCode.add(l);

            languagesOrdered.replace(l.getCountryCode(), lByCode);
        }

        return languagesOrdered;
    }
}

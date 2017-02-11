package fr.nantes.ustephan.world.repository;

import fr.nantes.ustephan.world.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ughostephan on 25/11/2016.
 */
@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    @Query("SELECT DISTINCT c.district FROM City c " +
           "WHERE c.countryCode = :code " +
           "ORDER BY c.district ASC ")
    List<String> findAllDistinctDistrictsByCountry(@Param("code") String countryCode);

    @Query("SELECT c FROM City c " +
            "WHERE c.countryCode = :code " +
            "ORDER BY c.district ASC ")
    List<City> findCityByCountry(@Param("code") String countryCode);
}

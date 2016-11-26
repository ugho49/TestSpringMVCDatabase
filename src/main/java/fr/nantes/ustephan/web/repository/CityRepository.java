package fr.nantes.ustephan.web.repository;

import fr.nantes.ustephan.web.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ughostephan on 25/11/2016.
 */
@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}

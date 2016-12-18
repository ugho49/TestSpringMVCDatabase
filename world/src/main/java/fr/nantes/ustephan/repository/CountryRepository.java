package fr.nantes.ustephan.repository;

import fr.nantes.ustephan.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ughostephan on 25/11/2016.
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

}

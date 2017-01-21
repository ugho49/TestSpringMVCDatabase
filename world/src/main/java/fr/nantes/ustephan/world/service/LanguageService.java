package fr.nantes.ustephan.world.service;

import fr.nantes.ustephan.world.entity.Language;
import fr.nantes.ustephan.world.entity.LanguagePK;

import java.util.List;

/**
 * Created by ughostephan on 26/11/2016.
 */
public interface LanguageService {
    /**
     * Find by id language.
     *
     * @param id the id
     * @return the language
     */
    public Language findById(LanguagePK id);

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<Language> findAll();
}

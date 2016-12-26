package fr.nantes.ustephan.world.service;

import fr.nantes.ustephan.world.entity.Language;
import fr.nantes.ustephan.world.entity.LanguagePK;

import java.util.List;

/**
 * Created by ughostephan on 26/11/2016.
 */
public interface LanguageService {
    public Language findById(LanguagePK id);
    public List<Language> findAll();
}

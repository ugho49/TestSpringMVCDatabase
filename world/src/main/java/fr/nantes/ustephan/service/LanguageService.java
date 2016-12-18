package fr.nantes.ustephan.service;

import fr.nantes.ustephan.entity.Language;
import fr.nantes.ustephan.entity.LanguagePK;

import java.util.List;

/**
 * Created by ughostephan on 26/11/2016.
 */
public interface LanguageService {
    public Language findById(LanguagePK id);
    public List<Language> findAll();
}

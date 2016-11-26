package fr.nantes.ustephan.web.service;

import fr.nantes.ustephan.web.entity.Language;
import fr.nantes.ustephan.web.entity.LanguagePK;

import java.util.List;

/**
 * Created by ughostephan on 26/11/2016.
 */
public interface LanguageService {
    public Language findById(LanguagePK id);
    public List<Language> findAll();
}

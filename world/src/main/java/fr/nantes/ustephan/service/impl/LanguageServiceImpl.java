package fr.nantes.ustephan.service.impl;

import fr.nantes.ustephan.entity.Language;
import fr.nantes.ustephan.entity.LanguagePK;
import fr.nantes.ustephan.repository.LanguageRepository;
import fr.nantes.ustephan.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ughostephan on 26/11/2016.
 */
@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    @Transactional
    public Language findById(LanguagePK id) {
        return languageRepository.findOne(id);
    }

    @Override
    @Transactional
    public List<Language> findAll() {
        return languageRepository.findAll();
    }

}

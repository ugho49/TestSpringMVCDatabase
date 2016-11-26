package fr.nantes.ustephan.web.controller.api;

import fr.nantes.ustephan.web.entity.City;
import fr.nantes.ustephan.web.entity.Language;
import fr.nantes.ustephan.web.service.CityService;
import fr.nantes.ustephan.web.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;


/**
 * Created by ughostephan on 26/11/2016.
 */

@RestControllerAdvice
@RequestMapping("/api/language")
public class LanguageApiController {

    @Autowired
    private LanguageService languageService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Language> findAll() {
        return languageService.findAll();
    }

}

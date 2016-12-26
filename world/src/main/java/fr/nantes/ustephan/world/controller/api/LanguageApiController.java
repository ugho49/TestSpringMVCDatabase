package fr.nantes.ustephan.world.controller.api;

import fr.nantes.ustephan.world.entity.Language;
import fr.nantes.ustephan.world.service.LanguageService;
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

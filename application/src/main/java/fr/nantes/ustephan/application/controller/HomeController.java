package fr.nantes.ustephan.application.controller;

import fr.nantes.ustephan.application.ws.output.ProjectOutput;
import fr.nantes.ustephan.application.ws.service.WSTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by ughostephan on 25/11/2016.
 */
@Controller
public class HomeController {

    @Autowired
    private WSTestService service;

    @RequestMapping("/")
    public String index(ModelMap model) {
        ProjectOutput project = service.getProjectById(1);
        List<ProjectOutput> projects = service.getProjects();
        return "index";
    }

}

package fr.nantes.ustephan.application.controller;

import fr.nantes.ustephan.application.util.MailService;
import fr.nantes.ustephan.application.ws.output.ProjectOutput;
import fr.nantes.ustephan.application.ws.service.WSTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by ughostephan on 25/11/2016.
 */
@Controller
public class HomeController {

    @Autowired
    private WSTestService wsTestService;

    @Autowired
    private MailService mailService;

    /**
     * Index string.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping("/")
    public String index(ModelMap model) {
        return "index";
    }

    /**
     * Projects string.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping("/projects")
    public String projects(ModelMap model) {
        ProjectOutput project = wsTestService.getProjectById(1);
        List<ProjectOutput> projects = wsTestService.getProjects();
        return "index";
    }

    /**
     * Send mail string.
     *
     * @return the string
     */
    @RequestMapping("/sendmail")
    public String sendMail() {
        mailService.sendMail("to@no-spam.com",
                "Testing123",
                "Testing only \n\n Hello Spring Email Sender");

        return "index";
    }


}

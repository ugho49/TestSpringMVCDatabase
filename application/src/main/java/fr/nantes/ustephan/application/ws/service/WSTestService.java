package fr.nantes.ustephan.application.ws.service;

import fr.nantes.ustephan.application.ws.output.ProjectOutput;

import java.util.List;

/**
 * Created by ughostephan on 26/12/2016.
 */
public interface WSTestService {

    List<ProjectOutput> getProjects();
    ProjectOutput getProjectById(int id);

}

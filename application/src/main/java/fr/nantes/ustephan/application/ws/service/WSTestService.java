package fr.nantes.ustephan.application.ws.service;

import fr.nantes.ustephan.application.ws.output.ProjectOutput;

import java.util.List;

/**
 * Created by ughostephan on 26/12/2016.
 */
public interface WSTestService {

    /**
     * Gets projects.
     *
     * @return the projects
     */
    List<ProjectOutput> getProjects();

    /**
     * Gets project by id.
     *
     * @param id the id
     * @return the project by id
     */
    ProjectOutput getProjectById(int id);

}

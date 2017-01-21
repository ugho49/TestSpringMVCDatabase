package fr.nantes.ustephan.application.ws.service;

import fr.nantes.ustephan.application.ws.output.ProjectOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ughostephan on 26/12/2016.
 */
@Component
public class WSTestServiceImpl implements WSTestService {

    @Value("#{'${ws.endpoint}' + '${ws.language}'}")
    private String URL;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Instantiates a new Ws test service.
     */
    public WSTestServiceImpl() {
    }

    @Override
    public List<ProjectOutput> getProjects() {
        final String uri = URL + "/projects";

        final List<ProjectOutput> output = Arrays.asList(restTemplate.getForObject(uri, ProjectOutput[].class));

        return output;
    }

    @Override
    public ProjectOutput getProjectById(int id) {
        final String uri = URL + "/projects/{id}";

        Map<String, String> params = new HashMap<>();
        params.put("id", "1");

        final ProjectOutput output = restTemplate.getForObject(uri, ProjectOutput.class, params);

        return output;
    }
}

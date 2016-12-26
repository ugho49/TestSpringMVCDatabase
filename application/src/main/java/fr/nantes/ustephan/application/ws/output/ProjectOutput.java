package fr.nantes.ustephan.application.ws.output;

/**
 * Created by ughostephan on 26/12/2016.
 */
public class ProjectOutput {

    private int id;
    private String url;
    private String imagePath;
    private boolean enabled;
    private String title;
    private String description;
    private String action;

    public ProjectOutput() {
    }

    public ProjectOutput(int id, String url, String imagePath, boolean enabled, String title, String description, String action) {
        this.id = id;
        this.url = url;
        this.imagePath = imagePath;
        this.enabled = enabled;
        this.title = title;
        this.description = description;
        this.action = action;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}

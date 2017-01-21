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

    /**
     * Instantiates a new Project output.
     */
    public ProjectOutput() {
    }

    /**
     * Instantiates a new Project output.
     *
     * @param id          the id
     * @param url         the url
     * @param imagePath   the image path
     * @param enabled     the enabled
     * @param title       the title
     * @param description the description
     * @param action      the action
     */
    public ProjectOutput(int id, String url, String imagePath, boolean enabled, String title, String description, String action) {
        this.id = id;
        this.url = url;
        this.imagePath = imagePath;
        this.enabled = enabled;
        this.title = title;
        this.description = description;
        this.action = action;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets image path.
     *
     * @return the image path
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * Sets image path.
     *
     * @param imagePath the image path
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * Is enabled boolean.
     *
     * @return the boolean
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets enabled.
     *
     * @param enabled the enabled
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets action.
     *
     * @return the action
     */
    public String getAction() {
        return action;
    }

    /**
     * Sets action.
     *
     * @param action the action
     */
    public void setAction(String action) {
        this.action = action;
    }
}

package udemy.json.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class UdemySchemaLecture {
    @JsonPropertyDescription (value = "id of udemySchema unit")
    private long id;
    @JsonPropertyDescription (value = "name of udemySchema unit")
    @JsonProperty (required = true)
    private String name;
    @JsonPropertyDescription(value = "description of udemySchema unit")
    private String description;
    private boolean enabled;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}

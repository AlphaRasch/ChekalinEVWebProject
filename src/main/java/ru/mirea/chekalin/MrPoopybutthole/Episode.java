package ru.mirea.chekalin.MrPoopybutthole;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Episode {

    @JsonProperty
    private int id;

    @JsonProperty
    private String name;

    @JsonProperty
    private List<String> characters;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getCharacters() {
        return characters;
    }

}

package ru.mirea.chekalin.MrPoopybutthole;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Result {

    @JsonProperty("info")
    private Info info;

    @JsonProperty("results")
    List<Episode> results;

    public List<Episode> getResults() {
        return results;
    }

    public Info getInfo() {
        return info;
    }
}

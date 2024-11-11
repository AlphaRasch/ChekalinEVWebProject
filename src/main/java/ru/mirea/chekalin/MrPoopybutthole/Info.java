package ru.mirea.chekalin.MrPoopybutthole;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Info {

    @JsonProperty
    private int count;

    @JsonProperty
    private int pages;

    @JsonProperty("next")
    private String next;

    public int getCount() {
        return count;
    }

    public int getPages() {
        return pages;
    }

    public String getNext() {
        return next;
    }
}

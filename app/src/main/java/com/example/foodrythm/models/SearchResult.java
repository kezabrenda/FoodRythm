package com.example.foodrythm.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchResult {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("totalResults")
    @Expose
    private Integer totalResults;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SearchResult() {
    }

    /**
     * 
     * @param totalResults
     * @param name
     * @param results
     */
    public SearchResult(String name, Integer totalResults, List<Result> results) {
        super();
        this.name = name;
        this.totalResults = totalResults;
        this.results = results;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

}

package com.example.foodrythm.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpoonacularSearchResponse {

    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("totalResults")
    @Expose
    private Integer totalResults;
    @SerializedName("limit")
    @Expose
    private Integer limit;
    @SerializedName("offset")
    @Expose
    private Integer offset;
    @SerializedName("searchResults")
    @Expose
    private List<SearchResult> searchResults = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SpoonacularSearchResponse() {
    }

    /**
     * 
     * @param totalResults
     * @param offset
     * @param query
     * @param limit
     * @param searchResults
     */
    public SpoonacularSearchResponse(String query, Integer totalResults, Integer limit, Integer offset, List<SearchResult> searchResults) {
        super();
        this.query = query;
        this.totalResults = totalResults;
        this.limit = limit;
        this.offset = offset;
        this.searchResults = searchResults;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public List<SearchResult> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(List<SearchResult> searchResults) {
        this.searchResults = searchResults;
    }

}

package com.example.foodrythm.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("link")
    @Expose
    private Object link;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("relevance")
    @Expose
    private Integer relevance;
    @SerializedName("content")
    @Expose
    private String content;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Result() {
    }

    /**
     * 
     * @param image
     * @param name
     * @param link
     * @param id
     * @param type
     * @param relevance
     * @param content
     */
    public Result(Integer id, String name, String image, Object link, String type, Integer relevance, String content) {
        super();
        this.id = id;
        this.name = name;
        this.image = image;
        this.link = link;
        this.type = type;
        this.relevance = relevance;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Object getLink() {
        return link;
    }

    public void setLink(Object link) {
        this.link = link;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getRelevance() {
        return relevance;
    }

    public void setRelevance(Integer relevance) {
        this.relevance = relevance;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}

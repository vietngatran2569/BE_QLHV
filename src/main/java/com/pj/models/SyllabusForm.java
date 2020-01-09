package com.pj.models;

import lombok.Data;

@Data
public class SyllabusForm {
    private Long id;
    private String name;
    private String image;
    private String description;
    private Iterable<Long> objectiveList;

    public SyllabusForm() {
    }

    public SyllabusForm(Long id, String name, String image, String description, Iterable<Long> objectiveList) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.objectiveList = objectiveList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Iterable<Long> getObjectiveList() {
        return objectiveList;
    }

    public void setObjectiveList(Iterable<Long> objectiveList) {
        this.objectiveList = objectiveList;
    }
}

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
}

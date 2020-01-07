package com.pj.controllers;

import com.pj.models.Objective;
import com.pj.models.Syllabus;
import com.pj.models.SyllabusForm;
import com.pj.services.IObjectiveService;
import com.pj.services.ISyllabusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class SyllabusController {
    @Autowired
    private ISyllabusService syllabusService;
    @Autowired
    private IObjectiveService objectiveService;

    @GetMapping("/syllabus")
    public ResponseEntity<List<Syllabus>> getList() {
        List<Syllabus> syllabusList = (List<Syllabus>) syllabusService.findAll();
        return new ResponseEntity<>(syllabusList, HttpStatus.OK);
    }

    @PostMapping("/syllabus/create")
    public ResponseEntity<Syllabus> addSyllabus(@RequestBody SyllabusForm syllabusForm) {
        Syllabus syllabus = new Syllabus();
        saveSyllabusFromForm(syllabus, syllabusForm);
        syllabusService.save(syllabus);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/syllabus/{id}")
    public ResponseEntity<Void> deleteSyllabus(@PathVariable Long id) {
        syllabusService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/syllabus/update")
    public ResponseEntity<Syllabus> updateSyllabus(@RequestBody SyllabusForm syllabusForm) {
        Syllabus syllabus = new Syllabus();
        saveSyllabusFromForm(syllabus, syllabusForm);
        syllabusService.save(syllabus);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void saveSyllabusFromForm(Syllabus syllabus, SyllabusForm syllabusForm) {
//        List<Objective> objectives = objectiveService.findAllById(syllabusForm.getObjectiveList());
        if (!Objects.isNull(syllabusForm.getId())) {
            syllabus.setId(syllabusForm.getId());
        }
        syllabus.setName(syllabusForm.getName());
        syllabus.setImage(syllabusForm.getImage());
        syllabus.setDescription(syllabusForm.getDescription());
//        syllabus.setObjectiveList(objectives);
    }
}

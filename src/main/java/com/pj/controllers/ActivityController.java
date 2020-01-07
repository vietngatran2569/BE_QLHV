package com.pj.controllers;

import com.pj.models.Activity;
import com.pj.services.impl.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    @GetMapping("/activity")
    public ResponseEntity<List<Activity>> getList(){
        List<Activity> activities = (List<Activity>) activityService.findAll();
        return  new ResponseEntity<>(activities, HttpStatus.OK);
    }

    @PostMapping("/activity/create")
    public ResponseEntity<Void> addActivity(@RequestBody Activity activity){
        activityService.save(activity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/activity/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable Long id){
        activityService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/activity/update")
    public ResponseEntity<Activity> updateActivity(@RequestBody Activity activity){
        activityService.save(activity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

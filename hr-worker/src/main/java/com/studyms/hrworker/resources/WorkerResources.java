package com.studyms.hrworker.resources;

import com.studyms.hrworker.entities.Worker;
import com.studyms.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResources {

    @Autowired
    private WorkerRepository repository;


    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        return ResponseEntity.ok(this.repository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable final Long id) {
        return ResponseEntity.ok(this.repository.findById(id).get());
    }


}

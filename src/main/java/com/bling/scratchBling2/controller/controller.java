package com.bling.scratchBling2.controller;

import com.bling.scratchBling2.model.ScratcherModel;
import com.bling.scratchBling2.repo.scratcherRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class controller {
    private static final Logger logger = LoggerFactory.getLogger(ScratcherModel.class);

    @Autowired
    private scratcherRepo repo;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/scratchers")
    public List<ScratcherModel> getScratchers() {
        logger.info("Getting all scratchers");
        return repo.findAll();
    }

    @PostMapping("/newScratcher")
    public ScratcherModel createScratcher(@RequestBody ScratcherModel scratcher) {
        logger.info("adding new scratcher");
         return repo.save(scratcher);
    }
}

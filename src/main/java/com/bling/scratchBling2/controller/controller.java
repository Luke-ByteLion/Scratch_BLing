package com.bling.scratchBling2.controller;

import com.bling.scratchBling2.model.ScratcherModel;
import com.bling.scratchBling2.repo.scratcherRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

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

    /**
     * gets scratchers with mathing name parameter
     * @param name name of scratcher to be found
     * @return the scratcher mathcing the name parameter
     */
   @GetMapping("/scratchers/{name}")
    public ResponseEntity<ScratcherModel> getScratcherByName(@PathVariable(value = "name") String name) {
        logger.info("Getting sratcher by name...");
        ScratcherModel scratcher = repo.findByName(name);
        return ResponseEntity.ok().body(scratcher);
    }

    /**
     * add new scratcher to the database
     * @param scratcher scratcher to be added, defined in request body
     * @return new scratcher entry in database
     */
    @PostMapping("/scratcher")
    public ScratcherModel createScratcher(@RequestBody ScratcherModel scratcher) {
        logger.info("adding new scratcher");
         return repo.save(scratcher);
    }

    @PutMapping("/scratcher/{name}")
    public ResponseEntity<ScratcherModel> scratcherByName(@PathVariable(value = "name") String scratcherName,
                                                          @RequestParam(required = false) ScratcherModel updateScratcher) {
        logger.info("attempting to update scratcher...");
        ScratcherModel scratcher = repo.findByName(scratcherName);
        scratcher.setPrice(updateScratcher.getPrice());
        repo.save(scratcher);
        return ResponseEntity.ok().body(updateScratcher);
    }

    @DeleteMapping("/scratcher/{name}")
    public void deleteScratcher(@PathVariable(value="name") String name) {
        logger.info("delete scratcher...");
        ScratcherModel scratcher = repo.findByName(name);
        repo.delete(scratcher);
    }
}

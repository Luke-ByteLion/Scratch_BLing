package com.bling.scratchBling2.controller;

import com.bling.scratchBling2.Exception.ScratcherNotFoundException;
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

    controller(scratcherRepo repo) {
        this.repo = repo;
    }

    /**
     * gets all the available scratchers in the database
     * @return
     */
    @GetMapping("/scratchers")
    public List<ScratcherModel> getScratchers() {
        logger.info("Getting all scratchers");
        return repo.findAll();
    }

    /**
     * gets scratchers with matching name parameter
     * @param id id of scratcher to be found
     * @return the scratcher matching the name parameter
     */
   @GetMapping("/scratch{id}")
    public ScratcherModel oneScratch(@PathVariable("id") Long id) {
        logger.info("Getting scratcher by name...");
       return repo.findById(id)
               .orElseThrow(() -> new ScratcherNotFoundException(id));
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

    /**
     * updates a scratehr the exists in the repo. creates a new scratcher if it does not exist
     * @param id scratcher id
     * @param updateScratcher the new info to change in the scratcher
     * @return
     */
    @PutMapping("/scratcher{id}")
    public ScratcherModel scratcherByName(@PathVariable("id") Long id,
                                                          @RequestBody ScratcherModel updateScratcher) {
        logger.info("attempting to update scratcher...");
        repo.findById(id)
                .map(scratcher ->{
                    scratcher.setId(id);
                    scratcher.setName(updateScratcher.getName());
                    scratcher.setDescription(updateScratcher.getDescription());
                    scratcher.setSizes(updateScratcher.getSizes());
                    scratcher.setPrice(updateScratcher.getPrice());
                    logger.info("Found scratcher and updated info...");
                    return repo.save(scratcher);
                })
                .orElseGet(() -> {
                    logger.info("No scratcher exists with that id... creating new scratcher...");
                    updateScratcher.setId(id);
                    return repo.save(updateScratcher);
                });
        return updateScratcher;
    }

    /**
     * Deletes a scratcher from the repo
     * @param id id of scratcher to be deleted
     */
    @DeleteMapping("/scratcher{id}")
    public void deleteScratcher(@PathVariable("id") Long id) {
        logger.info("delete scratcher...");
        repo.deleteById(id);
        logger.info("Scratcher succesfully deleted");
    }
}

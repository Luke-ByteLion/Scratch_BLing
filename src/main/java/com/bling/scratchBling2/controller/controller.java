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

    @GetMapping("/hello")
    public String hello() {
        return "hello";
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
       /* ScratcherModel scratcher = repo.findById(id);
        return ResponseEntity.ok().body(scratcher);*/
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

   /* @PutMapping("/scratcher{id}")
    public ResponseEntity<ScratcherModel> scratcherByName(@PathVariable(value = "id") long id,
                                                          @RequestParam(required = false) ScratcherModel updateScratcher) {
        logger.info("attempting to update scratcher...");
        ScratcherModel scratcher = repo.findById(id);
        scratcher.setPrice(updateScratcher.getPrice());
        repo.save(scratcher);
        return ResponseEntity.ok().body(updateScratcher);
    }*/

   /* @DeleteMapping("/scratcher{id}")
    public void deleteScratcher(@PathVariable(value="id") long id) {
        logger.info("delete scratcher...");
        ScratcherModel scratcher = repo.findById(id);
        repo.delete(scratcher);
    }*/
}

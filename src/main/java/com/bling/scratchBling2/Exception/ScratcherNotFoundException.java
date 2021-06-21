package com.bling.scratchBling2.Exception;

public class ScratcherNotFoundException extends RuntimeException{

    public ScratcherNotFoundException(Long id) {
        super("No Scratcher found with id: " + id);
    }
}

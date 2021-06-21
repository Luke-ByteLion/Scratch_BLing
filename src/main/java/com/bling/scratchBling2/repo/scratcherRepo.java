package com.bling.scratchBling2.repo;

import com.bling.scratchBling2.model.ScratcherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface scratcherRepo extends JpaRepository<ScratcherModel, Long> {

}

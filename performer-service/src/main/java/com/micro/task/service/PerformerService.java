package com.micro.task.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.micro.task.model.Performer;
import com.micro.task.model.Role;
import com.micro.task.model.Task;
import com.micro.task.repo.PerformerRepo;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PerformerService {
    private final PerformerRepo performerRepo;

    @Autowired
    public PerformerService(PerformerRepo performerRepo) {
        this.performerRepo = performerRepo;
    }

    public Performer findById(Long id) {
        return performerRepo.findById(id).orElseThrow(
                EntityNotFoundException::new
        );
    }

    public Performer findByName(String name) {
        return performerRepo.findByName(name).orElseThrow(
                EntityNotFoundException::new
        );
    }

    public List<Performer> findAll() {
        return performerRepo.findAll();
    }

    @Transactional
    public Performer create(Performer performer) {
        performer.getRoles().add(Role.USER);
//        performer.getRoles().add(Role.ADMIN);
        return performerRepo.save(performer);
    }

    @Transactional
    public void addTask(Long id, Long taskId) {
        performerRepo.addTask(id, taskId);
    }
}

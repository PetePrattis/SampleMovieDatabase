package com.prattis.samplemoviedatabase.service.impl;

import com.prattis.samplemoviedatabase.model.Director;
import com.prattis.samplemoviedatabase.repository.DirectorRepository;
import com.prattis.samplemoviedatabase.service.DirectorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DirectorServiceImpl implements DirectorService {
    
    private final DirectorRepository directorRepository;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Director create(Director object) {
        return directorRepository.save(object);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Director> read() {
        return directorRepository.findAll();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Director read(Long id) {
        return directorRepository.findById(id).orElse(null);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Director update(Long id, Director updatedObject) {
        Director director = read(id);
        if (director != null) {
            director.setName(updatedObject.getName());
            director.setSalary(updatedObject.getSalary());
            director.setSalaryType(updatedObject.getSalaryType());
            directorRepository.save(director);
        }
        return director;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Director delete(Long id) {
        Director director = read(id);
        if (director != null) {
            directorRepository.delete(director);
        }
        return director;
    }
}

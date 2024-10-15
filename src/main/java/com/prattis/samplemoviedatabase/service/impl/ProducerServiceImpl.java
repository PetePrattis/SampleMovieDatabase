package com.prattis.samplemoviedatabase.service.impl;

import com.prattis.samplemoviedatabase.model.Producer;
import com.prattis.samplemoviedatabase.repository.ProducerRepository;
import com.prattis.samplemoviedatabase.service.ProducerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProducerServiceImpl implements ProducerService {
    
    private final ProducerRepository producerRepository;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Producer create(Producer object) {
        return producerRepository.save(object);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Producer> read() {
        return producerRepository.findAll();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Producer read(Long id) {
        return producerRepository.findById(id).orElse(null);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Producer update(Long id, Producer updatedObject) {
        Producer producer = read(id);
        if (producer != null) {
            producer.setName(updatedObject.getName());
            producer.setSalary(updatedObject.getSalary());
            producer.setSalaryType(updatedObject.getSalaryType());
            producerRepository.save(producer);
        }
        return producer;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Producer delete(Long id) {
        Producer producer = read(id);
        if (producer != null) {
            producerRepository.delete(producer);
        }
        return producer;
    }
}

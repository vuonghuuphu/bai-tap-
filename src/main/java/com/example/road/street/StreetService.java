package com.example.road.street;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreetService {
    @Autowired
    StreetRepository streetRepository;

    public List<Street> findAll() {
        return streetRepository.findAll();
    }
    public Optional<Street> findById(int id) {
        return streetRepository.findById(id);
    }

    public Street save(Street product) {
        return streetRepository.save(product);
    }

    public void deleteById(int id) {streetRepository.deleteById(id); }

    public List<Street> findbytitle (String key){
        return streetRepository.search(key);
    }
}

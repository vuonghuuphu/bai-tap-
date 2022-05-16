package com.example.road.street;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/V1/streets")
public class StreetApi {

    @Autowired
    StreetService streetService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Street>> getlist() {
        return ResponseEntity.ok(streetService.findAll());
    }

    @PostMapping
    public ResponseEntity<Street> save(@RequestBody Street p) {
        return ResponseEntity.ok(streetService.save(p));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> detail(@PathVariable int id) {
        Optional<Street> optionalStudent = streetService.findById(id);
        if (!optionalStudent.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalStudent.get());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/search")
    public ResponseEntity<List<Street>> search(@RequestParam String Key) {
        return ResponseEntity.ok(streetService.findbytitle(Key));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<Street> update(@PathVariable int id, @RequestBody Street p) {
        Optional<Street> optionalStudent = streetService.findById(id);
        if (!optionalStudent.isPresent()){
            ResponseEntity.badRequest().build();
        }
        Street found = optionalStudent.get();
        if (found != null) {
            found.setName(p.getName());
            found.setDescription(p.getDescription());
            found.setDistrict(p.getDistrict());
            found.setStatus(p.getStatus());
        }
        return ResponseEntity.ok(streetService.save(found));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (!streetService.findById(id).isPresent()){
            ResponseEntity.badRequest().build();
        }
        streetService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

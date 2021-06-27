package com.example.springrestsample.resource;

import com.example.springrestsample.entity.Category;
import com.example.springrestsample.entity.Pet;
import com.example.springrestsample.entity.PetStatus;
import com.example.springrestsample.repository.PetRepository;
import com.example.springrestsample.storage.PetStorage;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pet")
public class PetResource {

    @Autowired
    private PetRepository petRepository;

    @PostMapping("save")
    public ResponseEntity<Pet> save(@RequestBody Pet pet) {
        Pet save = petRepository.save(pet);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @PostMapping("update")
    public ResponseEntity<Pet> update(@RequestBody Pet pet) {
        Pet save = petRepository.save(pet);
        return new ResponseEntity<>(save, HttpStatus.OK);


    }

    @PostMapping("getByStatus")
    public ResponseEntity<List<Pet>> getByStatus(PetStatus petStatus) {
        List<Pet> byStatus = petRepository.getAllByStatus(petStatus);
        if (byStatus.size() != 0) {
            return new ResponseEntity<>(byStatus, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("getById")
    public ResponseEntity<Pet> getById(long id) {
        Optional<Pet> byId = petRepository.findById(id);
        return new ResponseEntity<>(byId.get(), HttpStatus.OK);
    }

    @PostMapping("deleteById")
    public ResponseEntity<?> deleteById(long id) {
        if (petRepository.existsById(id)) {
            petRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

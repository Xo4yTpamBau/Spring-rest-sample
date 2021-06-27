package com.example.springrestsample.resource;

import com.example.springrestsample.entity.User;
import com.example.springrestsample.repository.UserRepository;
import com.example.springrestsample.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        User save = userRepository.save(user);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @PostMapping("updateName")
    public ResponseEntity<User> updateName(long id, String name) {
        User byId = userRepository.getById(id);
        byId.setName(name);
        User save = userRepository.save(byId);
        return new ResponseEntity<>(save, HttpStatus.OK);

    }

    @PostMapping("deleteById")
    public ResponseEntity<?> deleteById(long id) {
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("containsById")
    public ResponseEntity<?> containsById(long id) {
        if (userRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("findAllByName")
    public ResponseEntity<List<User>> findAllByName(String name) {
        List<User> allByName = userRepository.findAllByName(name);
        if (allByName.size() != 0) {
            return new ResponseEntity<>(allByName, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("findByUsername")
    public ResponseEntity<User> findByUsername(String username) {
        User byUsername = userRepository.findByUsername(username);
        if (byUsername != null) {
            return new ResponseEntity<>(byUsername, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

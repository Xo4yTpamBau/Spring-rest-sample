package com.example.springrestsample.storage;

import com.example.springrestsample.entity.Category;
import com.example.springrestsample.entity.Pet;
import com.example.springrestsample.entity.PetStatus;
import com.example.springrestsample.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PetStorage {

    private List<Pet> pets = new ArrayList<>();
    private static long incId;

    private Pet incId(Pet pet){
        pet.setId(incId++);
        return pet;
    }

    public Pet save(Pet pet) {
        incId(pet);
        pets.add(pet);
        return pet;
    }

    public List<Pet> getByStatus(PetStatus petStatus){
        List<Pet> allStatus = new ArrayList<>();
        for (Pet pet : pets) {
            if (pet.getStatus().equals(petStatus)) {
                allStatus.add(pet);
            }
        }
        return allStatus;
    }

    public boolean update(long id, Category category, String name, PetStatus petStatus) {
        for (Pet pet : pets) {
            if (pet.getId() == id) {
                pet.setCategory(category);
                pet.setName(name);
                pet.setStatus(petStatus);
                return true;
            }
        }
        return false;
    }

    public Pet getById(long id) {
        for (Pet pet : pets) {
            if (pet.getId() == id) {
                return pet;
            }
        }
        return null;
    }

    public boolean deleteById(long id) {
        for (Pet pet : pets) {
            if (pet.getId() == id) {
                pets.remove(pet);
                return true;
            }
        }
        return false;
    }

}

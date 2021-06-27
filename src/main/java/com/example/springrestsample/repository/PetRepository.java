package com.example.springrestsample.repository;

import com.example.springrestsample.entity.Pet;
import com.example.springrestsample.entity.PetStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> getAllByStatus (PetStatus petStatus);
}

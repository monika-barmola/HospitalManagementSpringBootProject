package com.example.contactmanagerh2spring.repository;

import com.example.contactmanagerh2spring.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

}

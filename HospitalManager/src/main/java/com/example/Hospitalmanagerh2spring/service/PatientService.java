package com.example.contactmanagerh2spring.service;

import com.example.contactmanagerh2spring.model.Patient;
import com.example.contactmanagerh2spring.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public Patient addPatient(Patient patient) {
        try{
            patient.setStatus("Admitted");
            return patientRepository.save(patient);
        }
        catch (Exception e){
//            logger.error("Error while creating new contact", e);
            return null;
        }
    }


    public List<Patient> getAllPatients() {
        try{
            return (List<Patient>) patientRepository.findAll();
        }
        catch (Exception e){
//            logger.error("Error while fecting all contacts", e);
            return null;
        }
    }

    public Patient discharePatient(Long id){
        try{
            Patient patient = patientRepository.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Patient not found with id: " + id));
            patient.setStatus("discharged");
            return patientRepository.save(patient);
        }
        catch (Exception e){
//            logger.error("Error while fecting all contacts", e);
            return null;
        }
    }



}

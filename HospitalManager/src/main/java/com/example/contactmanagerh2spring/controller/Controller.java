package com.example.contactmanagerh2spring.controller;

import com.example.contactmanagerh2spring.model.Patient;
import com.example.contactmanagerh2spring.model.User;
import com.example.contactmanagerh2spring.service.PatientService;
import com.example.contactmanagerh2spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    PatientService patientService;

    @Autowired
    UserService userService;

    @PostMapping("/patient")
    public ResponseEntity<Patient> admitPatient(@RequestBody Patient patient) {

        try{
            Patient p = patientService.addPatient(patient);
            return ResponseEntity.status(HttpStatus.CREATED).body(p);
        }
        catch (Exception e){
            //LOG

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/patients")
    public ResponseEntity< List<Patient> > getAllPatients() {
        return ResponseEntity.of(Optional.of(
                patientService.getAllPatients()
        ));
    }

    @PutMapping("/patient/discharge/{id}")
    public ResponseEntity<Patient> dischargePatient(@PathVariable("id") Long id) {
        try{
            Patient p = patientService.discharePatient(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(p);
        }
        catch (Exception e){
            //LOG

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    @PostMapping("/signup")
    public ResponseEntity addUser(@RequestBody User user) {

        try{
            User p = userService.addUser(user);
            return new ResponseEntity(HttpStatus.CREATED);
        }
        catch (Exception e){
            //LOG
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> validateUser(@RequestBody User user) {
        try{
            if (userService.validateUser(user)) {
                return ResponseEntity.ok("Login successful");
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
        catch (Exception e){
            //LOG
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users")
    public ResponseEntity< List<User> > getAllUsers() {
        return ResponseEntity.of(Optional.of(
                userService.getAllUsers()
        ));
    }
}


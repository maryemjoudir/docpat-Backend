package com.example.docpat_Backend.controller;

import com.example.docpat_Backend.dto.PatientDTO;
import com.example.docpat_Backend.serviceImpl.PatientServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/patients")
public class PatientController {
    private final PatientServiceImpl patientService;

    @PostMapping()
    public ResponseEntity<String> add(@RequestBody PatientDTO patientDTO){
        patientService.add(patientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Dossier de patient s'écrit avec succès");
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> read(@PathVariable Long id){
        return ResponseEntity.ok(patientService.read(id));
    }

    @GetMapping()
    public ResponseEntity<List<PatientDTO>> findAll(){
        return ResponseEntity.ok(patientService.findAll());
    }
}

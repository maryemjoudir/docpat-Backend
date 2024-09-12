package com.example.docpat_Backend.service;

import com.example.docpat_Backend.dto.PatientDTO;

import java.util.List;

public interface PatientService {
    PatientDTO add(PatientDTO patient);
    PatientDTO read(Long id);
    List<PatientDTO> findAll();
}

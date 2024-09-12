package com.example.docpat_Backend.serviceImpl;

import com.example.docpat_Backend.dto.PatientDTO;
import com.example.docpat_Backend.entity.Patient;
import com.example.docpat_Backend.repository.PatientRepository;
import com.example.docpat_Backend.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public PatientDTO add(PatientDTO patientDTO) {
        Patient savedPatient = patientRepository.save(new Patient(
                patientDTO.getId(),
                patientDTO.getFirstName(),
                patientDTO.getLastName(),
                patientDTO.getBirthDate(),
                patientDTO.getSex(),
                patientDTO.getRegion(),
                patientDTO.getCity(),
                patientDTO.getDistrict(),
                patientDTO.getMobilePhone(),
                patientDTO.getNationalId(),
                patientDTO.getCoverage(),
                patientDTO.getAddress(),
                patientDTO.getComplementAdresse()
        ));

        return new PatientDTO(
                savedPatient.getId(),
                savedPatient.getFirstName(),
                savedPatient.getLastName(),
                savedPatient.getBirthDate(),
                savedPatient.getSex(),
                savedPatient.getRegion(),
                savedPatient.getCity(),
                savedPatient.getDistrict(),
                savedPatient.getMobilePhone(),
                savedPatient.getNationalId(),
                savedPatient.getCoverage(),
                savedPatient.getAddress(),
                savedPatient.getComplementAdresse()
        );
    }

    @Override
    public PatientDTO read(Long id) {
        Optional<Patient> p = patientRepository.findById(id);
        if (p.isPresent()) {
            Patient patient = p.get();
            return new PatientDTO(
                    patient.getId(),
                    patient.getFirstName(),
                    patient.getLastName(),
                    patient.getBirthDate(),
                    patient.getSex(),
                    patient.getRegion(),
                    patient.getCity(),
                    patient.getDistrict(),
                    patient.getMobilePhone(),
                    patient.getNationalId(),
                    patient.getCoverage(),
                    patient.getAddress(),
                    patient.getComplementAdresse()
            );
        }
        return null;
    }

    @Override
    public List<PatientDTO> findAll() {
        List<Patient> patients = patientRepository.findAll();

        return patients.stream()
                .map(patient -> new PatientDTO(
                        patient.getId(),
                        patient.getFirstName(),
                        patient.getLastName(),
                        patient.getBirthDate(),
                        patient.getSex(),
                        patient.getRegion(),
                        patient.getCity(),
                        patient.getDistrict(),
                        patient.getMobilePhone(),
                        patient.getNationalId(),
                        patient.getCoverage(),
                        patient.getAddress(),
                        patient.getComplementAdresse()
                ))
                .collect(Collectors.toList());
    }

}

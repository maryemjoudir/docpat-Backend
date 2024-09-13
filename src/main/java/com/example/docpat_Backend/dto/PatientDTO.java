package com.example.docpat_Backend.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private String sex;

    private String region;

    private String city;

    private String district;

    private String mobilePhone;

    private String nationalId;

    private String coverage;

    private String address;

    private String complementAdresse;

    private Date dateEdition;

    private Date dateCreation;
}

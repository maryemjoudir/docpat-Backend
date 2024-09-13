package com.example.docpat_Backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient extends Auditable<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private String sex;

    private String region;

    private String city;

    private String district;

    @Column(name = "mobile_phone")
    private String mobilePhone;

    @Column(name = "national_id")
    private String nationalId;

    private String coverage;

    private String address;

    @Column(name = "complement_adresse")
    private String complementAdresse;



}

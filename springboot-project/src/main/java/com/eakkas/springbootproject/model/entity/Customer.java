package com.eakkas.springbootproject.model.entity;


import com.eakkas.springbootproject.model.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    // entity clası oluşturduk.Fieldları içinde tanımladık.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "name", length = 40)
    private String name;

    @Column(name= "email", unique = true, length = 100)
    private String email;

    @Column(name= "phone", length = 13)
    private String phone;

    @Column(name = "address", length = 250)
    private String address;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}

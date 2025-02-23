package com.example.CarAPI.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Model model;
    private Double price;
    private Double discount;
    @Column(length = 20000)
    private String description;

    @ManyToOne
    private Brand brand;

    @OneToMany(mappedBy = "car")
    private List<Photo> photos;
}

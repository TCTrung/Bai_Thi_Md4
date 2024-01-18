package com.example.md4exam.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Entity
@Table(name = "cities")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name is required")
    private String name;

    @NotNull(message = "Area is required")
    private Long area;

    @NotNull(message = "Population is required")
    private Long population;

    @NotNull(message = "GDP is required")
    private Long GDP;

    @NotEmpty(message = "Description is required")
    private String description;

    @ManyToOne
    @JoinColumn(name = "c_id")
    private Country country;
}

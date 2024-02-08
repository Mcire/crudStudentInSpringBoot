package com.groupeisi.crudStudent.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    @NotNull(message = "Le name ne doit pas etre null")
    private String name;
    @NotNull(message = "L'age ne doit pas etre null")
    private int age;
    @NotNull(message = "L'email ne doit pas etre null")
    private String email;
}

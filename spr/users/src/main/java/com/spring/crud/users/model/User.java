package com.spring.crud.users.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 30, message = "Количество символов в имене должно быть в диапозоне от 2 до 30")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Почта не должна быть пустой")
    @Email(message = "Не корректный адрес почты")
    @Column(name = "email")
    private String email;


}

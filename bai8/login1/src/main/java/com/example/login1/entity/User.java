package com.example.login1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "First name không được để trống")
    @Size(min = 5, max = 45, message = "First name phải từ 5-45 ký tự")
    private String firstname;
    @NotBlank(message = "Last name không được để trống")
    @Size(min = 5, max = 45, message = "Last name phải từ 5-45 ký tự")
    private String lastname;
    @NotBlank(message = "SĐT không được để trống")
    @Pattern(regexp = "^\\d{10,11}$", message = "SĐT phải 10-11 số")
    private String phoneNumber;
    @NotNull(message = "Tuổi không được để trống")
    @Min(value = 18, message = "Tuổi >=18")
    private Integer age;
    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    private String email;
}

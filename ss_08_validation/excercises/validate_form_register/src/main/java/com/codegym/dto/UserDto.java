package com.codegym.dto;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {
    private Integer id;

    @NotBlank(message = "(*)firstName: Không được để trống ! Vui lòng nhập lại !")
    @Size(min = 5, max = 45)
    private String firstName;

    @NotBlank(message = "(*)lastName: Không được để trống ! Vui lòng nhập lại !")
    @Size(min = 5, max = 45)
    private String lastName;

    @NotBlank(message = "(*)Số điện thoại không được để trống")
    @Pattern(message = "Số điện thoại không hợp lệ !", regexp = "^090\\d{7}$")
    private String phone;

    @NotNull
    @Min(18)
    private Integer age;

    @NotBlank(message = "Email không được để trống !")
    @Email(message = "Email không hợp lệ ! Phải là ...@gmail.com", regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;

    public UserDto() {
    }

    public UserDto(Integer id, String firstName, String lastName, String phone, Integer age, String email) {
        this.id =id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto registerDto = (UserDto) target;
    }
}

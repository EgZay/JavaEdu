package ru.noorsoft.javaeducation;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import  javax.validation.constraints.Email ;

@Entity
@Table(name="users")

public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "FIRST_NAME")
    @NotBlank(message = "This field should not be empty")
    @Pattern(message = "Bad formed person first name: ${validatedValue}",
            regexp = "^[A-Z][a-z]*(\\s(([a-z]{1,3})|(([a-z]+\\')?[A-Z][a-z]*)))*$")
    private String firstName;

    @Column(name = "LAST_NAME")
    @NotBlank(message = "This field should not be empty")
    @Pattern(message = "Bad formed person last name: ${validatedValue}",
            regexp = "^[A-Z][a-z]*(\\s(([a-z]{1,3})|(([a-z]+\\')?[A-Z][a-z]*)))*$")
    private String lastName;

    @Column(name = "PHONE_NUMBER")
    @NotBlank(message = "This field should not be empty")
    @Size(min = 11, max = 11, message = "The phone number must consist of 11 digits")
    private String phone_number;

    @Column(name = "EMAIL")
    @Email(message = "Email is not correct")
    @NotBlank(message = "This field should not be empty")
    private String email;

    protected User() {
    }

    public User( String firstName, String lastName,String phone_number,String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone_number = phone_number;
        this.email = email;

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone_number=" + phone_number +
                ", email='" + email + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
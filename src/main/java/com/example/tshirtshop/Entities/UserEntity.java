package com.example.tshirtshop.Entities;

import com.example.tshirtshop.Models.Role;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usr")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String lastName;
    @Column
    private String email;

    transient private String confirmPassword;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    private boolean active = false;

    public UserEntity() {}

    public UserEntity(String username, String password, String name, String surname, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.lastName = lastName;
        this.email = email;
    }

    public Integer getId() {return id;}

    //public void setId(Integer id) {this.id = id;}

    public Set<Role> getRoles() {return roles;}

    public void setRoles(Set<Role> roles) {this.roles = roles;}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getSurname() {return surname;}

    public void setSurname(String surname) {this.surname = surname;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getConfirmPassword() {return confirmPassword;}

    public void setConfirmPassword(String confirmPassword) {this.confirmPassword = confirmPassword;}

    public boolean isActive() {return active;}

    public void setActive(boolean active) {this.active = active;}


}

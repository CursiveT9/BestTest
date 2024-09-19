package com.example.besttest.models.entities;

//import jakarta.persistence.*;
//import com.example.besttest.models.baseEntities.TimestampedEntity;
//
//@Entity
//@Table(name = "users")
//public class User extends TimestampedEntity {
//
//    private String username;
//    private String password;
//    private String firstName;
//    private String lastName;
//    private String email;
//    private int points;
//    private Boolean isActive;
//    private String imageUrl;
//    @ManyToOne
//    @JoinColumn(name = "role_id")
//    private UserRole role;
//
//    public User(UserRole role, String imageUrl, Boolean isActive, int points, String email, String lastName, String firstName, String password, String username) {
//        this.role = role;
//        this.imageUrl = imageUrl;
//        this.isActive = isActive;
//        this.points = points;
//        this.email = email;
//        this.lastName = lastName;
//        this.firstName = firstName;
//        this.password = password;
//        this.username = username;
//    }
//
//    public User() {
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//    public void setRole(UserRole role) {
//        this.role = role;
//    }
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }
//    public void setActive(Boolean active) {
//        isActive = active;
//    }
//    public void setPoints(int points) {
//        this.points = points;
//    }
//    public void setEmail(String email) {
//        this.email = email;
//    }
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @Column(name = "username", length = 255, nullable = false)
//    public String getUsername() {
//        return username;
//    }
//    @Column(name = "password", length = 255, nullable = false)
//    public String getPassword() {
//        return password;
//    }
//    @Column(name = "firstName", length = 255, nullable = false)
//    public String getFirstName() {
//        return firstName;
//    }
//    @Column(name = "lastName", length = 255, nullable = false)
//    public String getLastName() {
//        return lastName;
//    }
//    @Column(name = "isActive")
//    public Boolean getActive() {
//        return isActive;
//    }
//    @Column(name = "imageUrl", length = 512, nullable = false)
//    public String getImageUrl() {
//        return imageUrl;
//    }
//    @Column(name = "email", nullable = false)
//    public String getEmail() {
//        return email;
//    }
//    @Column(name = "points", nullable = false)
//    public int getPoints() {
//        return points;
//    }
//    public UserRole getRole() {
//        return role;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", email='" + email + '\'' +
//                ", points=" + points +
//                ", isActive=" + isActive +
//                ", imageUrl='" + imageUrl + '\'' +
//                ", role=" + role +
//                '}';
//    }
//}


import com.example.besttest.models.baseEntities.TimestampedEntity;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")

public class User extends TimestampedEntity {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Boolean isActive;
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private UserRole role;
    private String email;
    private int points;

    public User(UserRole role, String imageUrl, Boolean isActive, String lastName, String firstName, String password, String username, String email) {
        this.role = role;
        this.imageUrl = imageUrl;
        this.isActive = isActive;
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
        this.username = username;
        this.email = email;
        this.points = 0;
    }

    public User() {
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setActive(Boolean active) {
        isActive = active;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public void setRole(UserRole role) {
        this.role = role;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPoints(int points) {
        this.points = points;
    }

    @Column(name = "username", length = 255, nullable = false)
    public String getUsername() {
        return username;
    }
    @Column(name = "password", length = 255, nullable = false)
    public String getPassword() {
        return password;
    }
    @Column(name = "firstName", length = 255, nullable = false)
    public String getFirstName() {
        return firstName;
    }
    @Column(name = "lastName", length = 255, nullable = false)
    public String getLastName() {
        return lastName;
    }
    @Column(name = "isActive")
    public Boolean getActive() {
        return isActive;
    }
    @Column(name = "imageUrl", length = 512, nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }
    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }
    @Column(name = "points", nullable = false)
    public int getPoints() {
        return points;
    }

    public UserRole getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isActive=" + isActive +
                ", imageUrl='" + imageUrl + '\'' +
                ", role=" + role +
                ", email='" + email + '\'' +
                ", points=" + points +
                '}';
    }
}
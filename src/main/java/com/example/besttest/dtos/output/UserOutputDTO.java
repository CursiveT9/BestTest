package com.example.besttest.dtos.output;

import com.example.besttest.dtos.baseEntities.BaseEntityDTO;
import com.example.besttest.enums.UserRoleType;

public class UserOutputDTO extends BaseEntityDTO {

    private String username;
    private String firstName;
    private String lastName;
    private Boolean isActive;
    private String imageUrl;
    private UserRoleType role;
    private String email;
    private int points;

    public UserOutputDTO(String username, String firstName, String lastName, Boolean isActive, String imageUrl, UserRoleType role, String email, int points) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.imageUrl = imageUrl;
        this.role = role;
        this.email = email;
        this.points = points;
    }

    public UserOutputDTO() {
    }

    public void setUsername(String username) {
        this.username = username;
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
    public void setRole(UserRoleType role) {
        this.role = role;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPoints(int points) {
        this.points = points;
    }

    public String getUsername() {
        return username;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public Boolean getActive() {
        return isActive;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public UserRoleType getRole() {
        return role;
    }
    public String getEmail() {
        return email;
    }
    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "UserOutputDTO{" +
                "username='" + username + '\'' +
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

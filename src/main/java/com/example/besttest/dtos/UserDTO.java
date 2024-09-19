package com.example.besttest.dtos;

import com.example.besttest.enums.UserRoleType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserDTO {
    private String id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Boolean isActive;
    private String imageUrl;
    private UserRoleType role;
    private String email;
    private int points;

    public UserDTO(String username, String password, String firstName, String lastName, Boolean isActive, String imageUrl, UserRoleType role, String email, int points) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.imageUrl = imageUrl;
        this.role = role;
        this.email = email;
        this.points = points;
    }

    public UserDTO(String username, String password, String firstName, String lastName, Boolean isActive, String imageUrl, String email, int points) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.imageUrl = imageUrl;
        this.role = UserRoleType.USER;
        this.email = email;
        this.points = points;
    }

    public UserDTO() {
    }

    public void setId(String id) {
        this.id = id;
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
    public void setIsActive(Boolean active) {
        isActive = active;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getId() {
        return id;
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

    @NotBlank(message = "Username name cannot be blank")
    public String getUsername() {
        return username;
    }
    @NotBlank(message = "Password cannot be blank")
    public String getPassword() {
        return password;
    }
    @NotBlank(message = "First name cannot be blank")
    public String getFirstName() {
        return firstName;
    }
    @NotBlank(message = "Last name cannot be blank")
    public String getLastName() {
        return lastName;
    }
    public Boolean getActive() {
        return isActive;
    }
    @NotNull(message = "Is active cannot be null")
    public Boolean getIsActive() {
        return isActive;
    }
    @NotBlank(message = "Image URL cannot be blank")
    public String getImageUrl() {
        return imageUrl;
    }
    @NotNull(message = "Role cannot be null")
    public UserRoleType getRole() {
        return role;
    }
    @NotBlank(message = "Email cannot be blank")
    public String getEmail() {
        return email;
    }
    @NotNull(message = "Points cannot be null")
    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isActive=" + isActive +
                ", imageUrl='" + imageUrl + '\'' +
                ", role=" + role +
                '}';
    }
}

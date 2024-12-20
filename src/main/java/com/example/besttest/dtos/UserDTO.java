package com.example.besttest.dtos;

import com.example.besttest.enums.UserRoleType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;

public class UserDTO extends BaseDTO {

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

    private final Map<String, Action> actions = new HashMap<>();
    public Map<String, Action> getActions() {
        return actions;
    }
    public void addAction(String rel, Action action) {
        this.actions.put(rel, action);
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
    public void setRole(UserRoleType role) {
        this.role = role;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPoints(int points) {
        this.points = points;
    }

    @NotBlank(message = "Username is mandatory")
    @Size(min = 2, max = 30, message = "Username must be between 2 and 30 characters")
    public String getUsername() {
        return username;
    }
    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, max = 30, message = "Password must be between 8 and 30 characters")
    public String getPassword() {
        return password;
    }
    @NotBlank(message = "First name is mandatory")
    @Size(max = 20, message = "First name must be less than 20 characters")
    public String getFirstName() {
        return firstName;
    }
    @NotBlank(message = "Last name is mandatory")
    @Size(max = 20, message = "Last name must be less than 20 characters")
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
    @NotBlank(message = "Image URL is mandatory")
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

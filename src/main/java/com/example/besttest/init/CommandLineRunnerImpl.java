package com.example.besttest.init;

import com.example.besttest.dtos.UserDTO;
import com.example.besttest.dtos.UserRoleDTO;
import com.example.besttest.enums.UserRoleType;
import com.example.besttest.models.entities.User;
import com.example.besttest.services.UserRoleService;
import com.example.besttest.services.UserService;
import com.example.besttest.services.internal.InternalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Autowired
    private UserService userService;
    @Autowired
    private InternalUserService internalUserService;
    @Autowired
    private UserRoleService userRoleService;

    @Transactional
    public void createData() {

        UserRoleDTO userRole = userRoleService.createUserRole(new UserRoleDTO(UserRoleType.USER));
        UserRoleDTO adminRole = userRoleService.createUserRole(new UserRoleDTO(UserRoleType.ADMIN));

        String user1 = userService.createUser(new UserDTO("LadyBug", "user", "Marinette", "Dupain-Cheng", true, "/images/users/ladyBug.jpg", "sas@gmail.com", 0)).getId();
        String user2 = userService.createUser(new UserDTO("MrPs", "password4", "Mr", "Ps", true, "/images/users/mrPs.jpg", "sas@gmail.com", 0)).getId();
        String user3 = userService.createUser(new UserDTO("Never", "123456", "Rick", "Astley", true, "/images/users/rickAstley.jpg", "sas@gmail.com", 0)).getId();
        String user4 = userService.createUser(new UserDTO("user", "user", "User", "User", true, "userImageUrl6", "sas@gmail.com", 0)).getId();
        String user5 = userService.createUser(new UserDTO("username7", "password7", "User7", "Doe", true, "userImageUrl7", "sas@gmail.com", 0)).getId();
        String user6 = userService.createUser(new UserDTO("username8", "password8", "User8", "Doe", false, "userImageUrl8", "sas@gmail.com", 0)).getId();
        String user7 = userService.createUser(new UserDTO("username9", "password9", "User9", "Doe", true, "userImageUrl9", "sas@gmail.com", 0)).getId();
        String user8 = userService.createUser(new UserDTO("username10", "password10", "User10", "Doe", true, "userImageUrl10", "sas@gmail.com", 0)).getId();
        String admin = userService.createUser(new UserDTO("admin", "admin", "Admin", "Admin", true, "adminImageUrl", UserRoleType.ADMIN, "sas@gmail.com", 0)).getId();

        // Получение всех пользователей
        List<UserDTO> allUsers = userService.getAllUsers();
        System.out.println("All Users: " + allUsers);

        // Обновление пользователя
        UserDTO userToUpdate = new UserDTO("LadyBugUpdated", "user", "Marinette", "Dupain-Cheng", true, "/images/users/ladyBugUpdated.jpg", "newemail@gmail.com", 10);
        userToUpdate.setId(user1);
        UserDTO updatedUser = userService.updateUser(userToUpdate);
        System.out.println("Updated User: " + updatedUser);

        // Поиск пользователей по роли
        List<UserDTO> usersByRole = userService.findUsersByRole(UserRoleType.USER);
        System.out.println("Users with USER role: " + usersByRole);

        // Получение пользователя по имени
        UserDTO userByUsername = userService.getUserByUsername("LadyBugUpdated");
        System.out.println("User by username: " + userByUsername);

        // Получение пользователя по ID
        UserDTO userById = userService.getUserDTOById(user2);
        System.out.println("User by ID: " + userById);

        // Получение пользователя по ID
        User userByIdEntity = internalUserService.getUserById(user2);
        System.out.println("User by ID entity: " + userByIdEntity);

        // Редактирование пользователя
        UserDTO userToEdit = new UserDTO("MrPsUpdated222222", "password5", "Mr", "Ps", true, "/images/users/mrPsUpdated.jpg", "newemail2@gmail.com", 5);
        UserDTO editedUser = userService.editUser(user2, userToEdit);
        System.out.println("Edited User: " + editedUser);

        // Удаление пользователя
        userService.deleteUser(user1);
        System.out.println("Deleted User with ID: " + user1);

    }

    @Override
    public void run(String... args) throws Exception {

//        createData();

    }
}

package com.example.besttestapi.controllers;
import com.example.besttestapi.dtos.UserDTOApi;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "users", description = "API для работы с пользователями")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успешная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации", content = @Content),
        @ApiResponse(responseCode = "404", description = "Ресурс не найден", content = @Content),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера", content = @Content)
})
@RequestMapping("/api/users")
public interface UserApi {

    @Operation(summary = "Создать пользователя sas")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserDTOApi> createUser(@RequestBody UserDTOApi userDTO);

    @Operation(summary = "Получить пользователя по ID")
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserDTOApi> getUserById(@PathVariable String id);

    @Operation(summary = "Получить всех пользователей")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<UserDTOApi>> getAllUsers();

    @Operation(summary = "Обновить пользователя")
    @PutMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserDTOApi> updateUser(@PathVariable String id, @RequestBody UserDTOApi userDTO);

    @Operation(summary = "Удалить пользователя")
    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> deleteUser(@PathVariable String id);
}

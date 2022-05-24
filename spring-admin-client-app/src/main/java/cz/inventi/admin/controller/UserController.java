package cz.inventi.admin.controller;

import cz.inventi.admin.dto.UserDto;
import cz.inventi.admin.service.impl.UserRegistrationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(UserController.CONTROLLER_ROOT)
@CrossOrigin
@RequiredArgsConstructor
public class UserController {
    public static final String CONTROLLER_ROOT = "/v1/user";

    private final UserRegistrationServiceImpl userRegistrationService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(userRegistrationService.getUsers());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserDto userDto) {
        UserDto createdUser = userRegistrationService.registerUser(userDto);
        return ResponseEntity
                .created(URI.create(CONTROLLER_ROOT + "/" + createdUser.getId()))
                .body(createdUser);
    }
}


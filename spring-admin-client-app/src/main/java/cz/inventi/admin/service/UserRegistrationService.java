package cz.inventi.admin.service;

import cz.inventi.admin.dto.UserDto;

import java.util.List;

public interface UserRegistrationService {

    UserDto registerUser(UserDto user);

    List<UserDto> getUsers();
}

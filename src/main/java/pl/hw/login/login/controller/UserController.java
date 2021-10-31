package pl.hw.login.login.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.hw.login.login.dto.UserDTO;
import pl.hw.login.login.exception.CustomException;
import pl.hw.login.login.service.UserService;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @GetMapping("{login}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("login") String login) throws CustomException {
        return Optional.ofNullable(userService.getUser(login))
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}

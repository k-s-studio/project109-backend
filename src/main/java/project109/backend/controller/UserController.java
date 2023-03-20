package project109.backend.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.Application;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import project109.backend.dto.LoginDTO;
import project109.backend.entity.LoginToken;
import project109.backend.entity.User;
import project109.backend.service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/user/login")
    public LoginToken userLogin(
            @RequestBody LoginDTO dto)
            throws Exception {
        final LoginToken loginToken;
        try {
            loginToken = service.loginCheck(dto.getStudentId(), dto.getPassword());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
        return loginToken;
    }

    @PostMapping("/user/test/dto")
    public LoginDTO DTOtest(
            @RequestBody LoginDTO dto)
            throws Exception {
                return dto;
    }

    @Consumes("application/json")
    @PostMapping("/user/info")
    public User getUserData(
            @RequestBody LoginToken t)
            throws Exception {
        final User u;
        try {
            u = service.getUserData(t);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
        return u;
    }

    @GetMapping("/user/list")
    public List<User> getUserList() {
        return service.getUserList();
    }
}

package com.example.FinalExamProject.Security;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final LoginHandler loginHandler;
    private final NewUserHandler newUserHandler;

    public LoginController(LoginHandler loginHandler, NewUserHandler newUserHandler) {
        this.loginHandler = loginHandler;
        this.newUserHandler = newUserHandler;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request)
    {
        return loginHandler.executes(request);
    }

    @PostMapping("/createNewUser")
    public ResponseEntity<LoginResponse> createNewUser(@RequestBody LoginRequest request)
    {
        return newUserHandler.executes(request);
    }
}
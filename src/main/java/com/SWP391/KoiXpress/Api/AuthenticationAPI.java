package com.SWP391.KoiXpress.Api;


import com.SWP391.KoiXpress.Model.Request.LoginRequest;
import com.SWP391.KoiXpress.Model.Request.RegisterRequest;
import com.SWP391.KoiXpress.Model.Response.LoginResponse;
import com.SWP391.KoiXpress.Model.Response.RegisterResponse;
import com.SWP391.KoiXpress.Service.AuthenticationService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@SecurityRequirement(name="api")
public class AuthenticationAPI {

    @Autowired
    AuthenticationService authenticationService;


    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody RegisterRequest registerRequest){
        RegisterResponse newUser =  authenticationService.register(registerRequest);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody LoginRequest loginRequest){
        LoginResponse newUser = authenticationService.login(loginRequest);
        return ResponseEntity.ok(newUser);
    }
    @GetMapping
    public ResponseEntity getAllUser(){
        List<RegisterResponse> users = authenticationService.getAllUser();
        return ResponseEntity.ok(users);
    }
}

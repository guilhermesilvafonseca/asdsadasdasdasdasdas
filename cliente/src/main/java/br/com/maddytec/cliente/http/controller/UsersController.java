package br.com.maddytec.cliente.http.controller;

import br.com.maddytec.cliente.dto.AutenticacaoRequest;
import br.com.maddytec.cliente.dto.LoginResponse;
import br.com.maddytec.cliente.entity.Users;
import br.com.maddytec.cliente.repository.UsersRepository;
import br.com.maddytec.cliente.service.UsersServicee;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersServicee service;

    @Autowired
    private UsersRepository repository;

    @PostMapping
    public ResponseEntity registerUsers(@RequestBody Users newUsers){
        return service.registerUser(newUsers);
    }

    @GetMapping
    public ResponseEntity consultUsers(){
        return service.consultUsers();
    }

    @PostMapping("/autenticacao")
    public ResponseEntity autenticao(@RequestBody AutenticacaoRequest loginUser){
        Users user = repository.findByEmailAndPassword(loginUser.getEmail(), loginUser.getPassword());
        if (user != null) {
            return ResponseEntity.status(200).body("Usuario autenticado");
        }
        return ResponseEntity.status(404).body("Usuário ou senha incorretos");
    }

//    @PostMapping("/change-password")
//    public ResponseEntity registerUsers(@RequestBody AutenticacaoRequest newPass){
//        return service.alterPassword(newPass);
//    }

}

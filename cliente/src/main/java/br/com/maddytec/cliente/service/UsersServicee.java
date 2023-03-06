package br.com.maddytec.cliente.service;

import br.com.maddytec.cliente.dto.AutenticacaoRequest;
import br.com.maddytec.cliente.entity.Users;
import br.com.maddytec.cliente.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsersServicee {

    @Autowired
    private UsersRepository repository;

    public ResponseEntity registerUser(Users newUsers){
        repository.save(newUsers);
        return ResponseEntity.status(201).build();
    }

    public ResponseEntity consultUsers(){
        return ResponseEntity.status(200).body(repository.findAll());
    }

    public ResponseEntity alterPassword(AutenticacaoRequest newPass){
        repository.updateUser(newPass.getPassword(), newPass.getEmail());
        return ResponseEntity.status(200).body("Senha alterada com sucesso");
    }

}

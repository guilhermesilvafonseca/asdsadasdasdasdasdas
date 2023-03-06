package br.com.maddytec.cliente.repository;

import br.com.maddytec.cliente.entity.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    Users findByEmailAndPassword(String email, String password);

    @Transactional
    @Modifying
    @Query("UPDATE Users SET password=?2 WHERE email=?1")
    void updateUser(String password, String email);

}

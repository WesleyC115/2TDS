package com.example.user.Repository;

import com.example.user.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<List<User>> findByNomeAndCurso(String nome, String curso);
}

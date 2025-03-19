package com.example.user.Controller;

import com.example.user.Entity.User;
import com.example.user.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        User userBd = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body((userBd));
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return ResponseEntity.status(HttpStatus.FOUND).body(user);
        } else {
            return ResponseEntity.status( HttpStatus.NOT_FOUND).build();
        }
    }

    
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Usuário Deletado");
        } else  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateById( @PathVariable Long id, @RequestBody User user) {
        Optional<User> userBd = userRepository.findById(id);
        if (!userBd.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        User userAtt = userBd.get();
        userAtt.setNome(user.getNome());
        userAtt.setEmail(user.getEmail());
        userRepository.save(userAtt);

        /*
        user.setId();
        userRepository.save(save);
        */
        return ResponseEntity.status(HttpStatus.OK).body(userAtt);
    }

}
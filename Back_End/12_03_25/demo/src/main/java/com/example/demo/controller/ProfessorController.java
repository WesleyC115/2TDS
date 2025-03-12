package com.example.demo.controller;

import com.example.demo.entity.Professor;
import com.example.demo.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProfessorController {
    @Autowired
    private ProfessorRepository pfRepository;

    @PostMapping("/professor/add")
    public ResponseEntity<Boolean> adicionarProfessor (@RequestBody Professor p) {
        pfRepository.save(p);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @GetMapping("/professor")
    public ResponseEntity<List<Professor>> getProfessores() {
        List<Professor> professores = pfRepository.findAll();
        return new ResponseEntity<>(professores, HttpStatus.OK);
    }

    @GetMapping("/professor/nome/{nome}")
    public ResponseEntity<List<Professor>> getProfessorByNome(@PathVariable String nome) {
        List<Professor> professores = pfRepository.findByNome(nome);
        if (professores.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(professores, HttpStatus.OK);
        }
    }
    @PutMapping("/professor/{id}")
    public ResponseEntity<Professor> atualizarProfessor(@PathVariable Integer id, @RequestBody Professor p) {
        Optional<Professor> professorExistente = pfRepository.findById(id);
        if (professorExistente.isPresent()) {
            Professor professor = professorExistente.get();
            professor.setNome(p.getNome());
            professor.setIdade(p.getIdade());
            professor.setSalario(p.getSalario());
            pfRepository.save(professor);
            return new ResponseEntity<>(professor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/professor/{id}")
    public ResponseEntity<Boolean> excluirProfessor(@PathVariable Integer id) {
        Optional<Professor> professorExistente = pfRepository.findById(id);
        if (professorExistente.isPresent()) {
            pfRepository.deleteById(id);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}

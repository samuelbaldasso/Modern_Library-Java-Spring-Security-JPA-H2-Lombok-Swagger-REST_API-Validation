package com.sbaldasso.library.controllers;

import com.sbaldasso.library.domain.Leitor;
import com.sbaldasso.library.dto.LeitorDto;
import com.sbaldasso.library.services.LeitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leitores")
public class LeitorController {

     @Autowired
     private LeitorService leitorService;

     @GetMapping
     public ResponseEntity<Iterable<Leitor>> listarLeitores() {
         Iterable<Leitor> leitores = leitorService.findAll();
         return ResponseEntity.ok(leitores);
     }

     @GetMapping("/{id}")
     public ResponseEntity<Leitor> buscarLeitorPorId(@PathVariable Long id) {
         Leitor leitor = leitorService.findById(id);
         return ResponseEntity.ok(leitor);
     }

     @PostMapping
     public ResponseEntity<Leitor> cadastrarLeitor(@RequestBody LeitorDto leitorDto) {
         Leitor leitor = leitorService.addUser(leitorDto);
         return ResponseEntity.status(HttpStatus.CREATED).body(leitor);
     }

     @PutMapping("/{id}")
     public ResponseEntity<Leitor> atualizarLeitor(@PathVariable Long id, @RequestBody LeitorDto leitorDto) {
         Leitor leitor = leitorService.updateUser(leitorDto, id);
         return ResponseEntity.ok(leitor);
     }

     @DeleteMapping("/{id}")
     public ResponseEntity<Void> excluirLeitor(@PathVariable Long id) {
         leitorService.deleteUser(id);
         return ResponseEntity.noContent().build();
     }
}

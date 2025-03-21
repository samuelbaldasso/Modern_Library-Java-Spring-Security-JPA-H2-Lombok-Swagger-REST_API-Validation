package com.sbaldasso.library.controllers;

import com.sbaldasso.library.domain.Emprestimo;
import com.sbaldasso.library.services.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping
    public ResponseEntity<Iterable<Emprestimo>> listarEmprestimos() {
        Iterable<Emprestimo> emprestimos = emprestimoService.findAll();
        return ResponseEntity.ok(emprestimos);
    }

     @GetMapping("/{id}")
     public ResponseEntity<Emprestimo> buscarEmprestimoPorId(@PathVariable Long id) {
         Emprestimo emprestimo = emprestimoService.findById(id);
         return ResponseEntity.ok(emprestimo);
}
     @PostMapping
     public ResponseEntity<Emprestimo> cadastrarEmprestimo(@RequestBody Long idLeitor, Long idLivro) {
         Emprestimo emprestimo = emprestimoService.emprestarLivro(idLeitor, idLivro);
         return ResponseEntity.status(HttpStatus.CREATED).body(emprestimo);
}
     @PutMapping("/{id}")
     public ResponseEntity<Emprestimo> atualizarEmprestimo(@PathVariable Long id, @RequestBody Long idLeitor, Long idLivro) {
         Emprestimo emprestimo = emprestimoService.updateEmprestimo(id, idLeitor, idLivro);
         return ResponseEntity.ok(emprestimo);
}

     @DeleteMapping("/{id}")
     public ResponseEntity<Void> excluirEmprestimo(@PathVariable Long id) {
         emprestimoService.devolverLivro(id);
         return ResponseEntity.noContent().build();
    }

    @PostMapping("/{idEmprestimo}/renovar")
    public ResponseEntity<Emprestimo> renovarEmprestimo(@PathVariable Long idEmprestimo) {
        Emprestimo emprestimo = emprestimoService.renovarEmprestimo(idEmprestimo);
        return ResponseEntity.ok(emprestimo);
    }
}

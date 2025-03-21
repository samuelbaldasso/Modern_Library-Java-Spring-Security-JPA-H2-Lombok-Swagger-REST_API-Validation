package com.sbaldasso.library.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emprestimos")
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idLeitor;
    private Long idLivro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;
    private LocalDate dataRenovacao;
    private LocalDate dataExclusao;
    private String status;

    private boolean renovado;
}

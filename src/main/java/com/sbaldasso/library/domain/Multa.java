package com.sbaldasso.library.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "multas")
public class Multa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idLeitor;
    private Long idEmprestimo;
    private String dataMulta;
    private String dataPagamento;
    private String dataCadastro;
    private String dataAtualizacao;
    private String dataExclusao;
    private String status;

    public Multa(Long idLeitor, double multa) {
    }
}

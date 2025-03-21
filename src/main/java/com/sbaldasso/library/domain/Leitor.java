package com.sbaldasso.library.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "leitores")
public class Leitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private String cidade;
    private String estado;
    private String cep;
    private String cpf;
    private String rg;
    private String dataNascimento;
    private String dataCadastro;
    private String dataAtualizacao;
    private String dataExclusao;
    private String status;

    @OneToMany(mappedBy = "idLeitor")
    private List<Emprestimo> emprestimos;

    @OneToMany(mappedBy = "idLeitor")
    private List<Multa> multas;

    @OneToMany(mappedBy = "idLeitor")
    private List<Reserva> reservas;

}

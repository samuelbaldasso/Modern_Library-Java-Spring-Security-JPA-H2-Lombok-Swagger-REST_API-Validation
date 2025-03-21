package com.sbaldasso.library.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    private String editora;
    private String edicao;
    private String ano;
    private String isbn;
    private String dataCadastro;
    private String dataAtualizacao;
    private String dataExclusao;
    private String status;
    private int qtd;
}

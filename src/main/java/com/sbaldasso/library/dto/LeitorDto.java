package com.sbaldasso.library.dto;

import com.sbaldasso.library.domain.Emprestimo;
import com.sbaldasso.library.domain.Multa;
import com.sbaldasso.library.domain.Reserva;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeitorDto {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String dataNascimento;
    private String dataCadastro;
    private String dataAtualizacao;
    private String dataExclusao;
    private String status;
    private List<Emprestimo> emprestimos;
    private List<Multa> multas;
    private List<Reserva> reservas;

}

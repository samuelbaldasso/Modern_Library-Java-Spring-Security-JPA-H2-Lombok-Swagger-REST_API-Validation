package com.sbaldasso.library.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idLeitor;
    private Long idLivro;
    private String dataReserva;
    private String dataCadastro;
    private String dataAtualizacao;
    private String dataExclusao;
    private String status;
}

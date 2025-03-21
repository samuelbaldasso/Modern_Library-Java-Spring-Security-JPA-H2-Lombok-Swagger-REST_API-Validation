package com.sbaldasso.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultaDto {
    private Long idLeitor;
    private String dataMulta;
    private String dataPagamento;
    private String dataCadastro;
    private String dataAtualizacao;
    private String dataExclusao;
    private String status;
}

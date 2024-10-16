package com.example.cp5sec.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrinquedoDto {

    @NotNull(message = "O nome do brinquedo não pode estar vazio")
    private String nome_brinquedo;

    @NotNull(message = "A descrição não pode estar vazia")
    private String descricao;

    @NotNull(message = "A classificação não pode estar vazia")
    private String classificacao;

    @NotNull(message = "O preço não pode estar vazio")
    @Positive(message = "O preço deve ser maior que zero")
    private String preco;
}
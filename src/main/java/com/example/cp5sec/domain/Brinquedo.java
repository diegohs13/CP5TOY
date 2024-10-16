package com.example.cp5sec.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "tb_cp5_brinquedo")
@Table(name = "tb_cp5_brinquedo")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Brinquedo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String nome_brinquedo;

    private String descricao;

    private String classificacao;

    private String preco;
}

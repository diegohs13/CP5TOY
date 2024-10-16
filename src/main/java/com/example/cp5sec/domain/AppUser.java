package com.example.cp5sec.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "tb_cp5_user")
@Table(name = "tb_cp5_user")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String nome_completo;

    private String password;

    private String telefone;

}

package com.example.cp5sec.domain;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {

        @NotEmpty
        @Size(min = 6, max = 20, message = "O nome de usuário deve ter entre 6 e 20 caracteres")
        private String username;

        @NotEmpty
        @Size(min = 2, message = "O nome deve ter no mínimo 3 caracteres")
        private String nome_completo;

        @NotEmpty
        @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
        private String password;

        @NotEmpty
        @Size(max = 20, message = "O telefone deve ter no máximo 20 caracteres")
        private String telefone;
}

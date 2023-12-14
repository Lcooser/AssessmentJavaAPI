package model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
public class Usuario {
    private Integer id;
    private String nome;
    private String senha;
}

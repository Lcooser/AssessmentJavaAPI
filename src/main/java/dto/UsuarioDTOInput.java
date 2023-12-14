package dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
public class UsuarioDTOInput {
    private Integer id;
    private String nome;
    private String senha;
}

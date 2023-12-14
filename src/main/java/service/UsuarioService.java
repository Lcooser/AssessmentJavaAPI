package service;

import dto.UsuarioDTOInput;
import dto.UsuarioDTOOutput;
import model.Usuario;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UsuarioService {
    private List<Usuario> listaUsuarios = new ArrayList<>();
    private ModelMapper modelMapper = new ModelMapper();

    public List<UsuarioDTOOutput> listar() {
        List<UsuarioDTOOutput> usuariosDTO = new ArrayList<>();
        for (Usuario usuario : listaUsuarios) {
            usuariosDTO.add(modelMapper.map(usuario, UsuarioDTOOutput.class));
        }
        return usuariosDTO;
    }

    public void inserir(UsuarioDTOInput usuarioDTOInput) {
        Usuario usuario = modelMapper.map(usuarioDTOInput, Usuario.class);
        listaUsuarios.add(usuario);
    }

    public void alterar(UsuarioDTOInput usuarioDTOInput) {
        Usuario usuarioAtualizado = modelMapper.map(usuarioDTOInput, Usuario.class);
        Optional<Usuario> usuarioExistente = listaUsuarios.stream()
                .filter(u -> Objects.equals(u.getId(), usuarioAtualizado.getId()))
                .findFirst();

        usuarioExistente.ifPresent(u -> {

            u.setNome(usuarioAtualizado.getNome());
            u.setSenha(usuarioAtualizado.getSenha());
        });
    }

    public UsuarioDTOOutput buscar(Integer id) {
        Optional<Usuario> usuarioExistente = listaUsuarios.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();

        return usuarioExistente.map(usuario -> modelMapper.map(usuario, UsuarioDTOOutput.class)).orElse(null);
    }

    public void excluir(Integer id) {
        listaUsuarios.removeIf(usuario -> usuario.getId().equals(id));
    }
}
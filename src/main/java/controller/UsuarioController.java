package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.UsuarioDTOInput;
import service.UsuarioService;

import static spark.Spark.*;

public class UsuarioController {
    private final UsuarioService usuarioService;
    private final ObjectMapper objectMapper;

    public UsuarioController(UsuarioService usuarioService, ObjectMapper objectMapper) {
        this.usuarioService = usuarioService;
        this.objectMapper = objectMapper;
        respostasRequisicoes();
    }

    public void respostasRequisicoes() {
        path("/api", () -> {
            before("/*", (req, res) -> res.type("application/json"));

            get("/usuarios", (req, res) -> {
                res.type("application/json");
                return objectMapper.writeValueAsString(usuarioService.listar());
            });

            get("/usuarios/:id", (req, res) -> {
                res.type("application/json");
                int userId = Integer.parseInt(req.params(":id"));
                return objectMapper.writeValueAsString(usuarioService.buscar(userId));
            });

            delete("/usuarios/:id", (req, res) -> {
                int userId = Integer.parseInt(req.params(":id"));
                usuarioService.excluir(userId);
                res.status(204);
                return "";
            });

            post("/usuarios", (req, res) -> {
                UsuarioDTOInput usuarioDTOInput = objectMapper.readValue(req.body(), UsuarioDTOInput.class);
                usuarioService.inserir(usuarioDTOInput);
                res.status(201);
                return "";
            });

            put("/usuarios", (req, res) -> {
                UsuarioDTOInput usuarioDTOInput = objectMapper.readValue(req.body(), UsuarioDTOInput.class);
                usuarioService.alterar(usuarioDTOInput);
                res.status(204);
                return "";
            });
        });
    }
}

package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.UsuarioController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.UsuarioService;

import static spark.Spark.*;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        port(4567);


        UsuarioService usuarioService = new UsuarioService();
        ObjectMapper objectMapper = new ObjectMapper();


        UsuarioController usuarioController = new UsuarioController(usuarioService, objectMapper);


        path("/api", () -> {
            before("/*", (req, res) -> res.type("application/json"));


            usuarioController.respostasRequisicoes();
        });

        logger.info("Aplicativo iniciado.");
    }
}

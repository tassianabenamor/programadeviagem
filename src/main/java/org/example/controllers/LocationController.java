package org.example.controllers;

import spark.Request;
import spark.Response;
import static spark.Spark.*;

public class LocationController {

    public LocationController() {
        get("/locations", (req, res) -> {
            // Implementar lógica para retornar todas as localizações
            return "Lista de todas as localizações";
        });

        get("/locations/:id", (req, res) -> {
            String id = req.params(":id");
            // Implementar lógica para retornar uma localização específica
            return "Detalhes da localização com ID: " + id;
        });

        post("/locations", (req, res) -> {
            String body = req.body();
            // Implementar lógica para criar uma nova localização com o corpo da requisição
            return "Nova localização criada com os dados: " + body;
        });

        put("/locations/:id", (req, res) -> {
            String id = req.params(":id");
            String body = req.body();
            // Implementar lógica para atualizar uma localização existente com o ID e corpo da requisição
            return "Localização com ID " + id + " atualizada com os dados: " + body;
        });

        delete("/locations/:id", (req, res) -> {
            String id = req.params(":id");
            // Implementar lógica para deletar uma localização com o ID especificado
            return "Localização com ID " + id + " deletada";
        });
    }

    // Método auxiliar para tratar exceções e configurar o status de resposta
    private String handleException(Exception e, Response res, int statusCode) {
        res.status(statusCode);
        return e.getMessage();
    }
}

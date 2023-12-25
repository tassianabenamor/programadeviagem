package org.example.controllers;

import org.example.models.Location;
import spark.Request;
import spark.Response;
import static spark.Spark.*;
import org.example.services.LocationService;
import com.google.gson.Gson;

import java.util.List;


public class LocationController {

    private LocationService locationService;
    private Gson gson;

    public LocationController() {
        locationService = new LocationService(); // Serviço que interage com o banco de dados
        gson = new Gson(); // Instância do Gson para converter objetos em JSON

        get("/locations", (req, res) -> {
            res.type("application/json"); // Define o tipo de conteúdo da resposta como JSON

            try {
                // Busca todas as localizações usando o serviço
                List<Location> locations = locationService.getAllLocations();

                // Converte a lista de localizações para JSON
                return gson.toJson(locations);
            } catch (Exception e) {
                res.status(500); // Erro interno do servidor
                return gson.toJson("Erro ao buscar localizações: " + e.getMessage());
            }
        });

        get("/locations/:id", (req, res) -> {
            String id = req.params(":id");
            // Implementar lógica para retornar uma localização específica
            return "Detalhes da localização com ID: " + id;
        });

        // GET: Buscar localizações pelo nome
        get("/locations/nome/:nome", (req, res) -> {
            String nome = req.params(":nome");
            // Implementar lógica para retornar localizações pelo nome
            return "Localizações com o nome: " + nome;
        });

        // GET: Buscar localizações por categoria
        get("/locations/categoria/:categoria", (req, res) -> {
            String categoria = req.params(":categoria");
            // Implementar lógica para retornar localizações por categoria
            return "Localizações na categoria: " + categoria;
        });

        post("/locations", (req, res) -> {
            String body = req.body();
            // Implementar lógica para criar uma nova localização com o corpo da requisição
            return "Nova localização criada com os dados: " + body;
        });

        // POST: Criar um novo evento em uma localização
        post("/locations/eventos", (req, res) -> {
            String body = req.body();
            // Implementar lógica para criar um novo evento com o corpo da requisição
            return "Novo evento criado com os dados: " + body;
        });

        put("/locations/:id", (req, res) -> {
            String id = req.params(":id");
            String body = req.body();
            // Implementar lógica para atualizar uma localização existente com o ID e corpo da requisição
            return "Localização com ID " + id + " atualizada com os dados: " + body;
        });

        // PUT: Atualizar os horários de uma localização
        put("/locations/:id/horarios", (req, res) -> {
            String id = req.params(":id");
            String body = req.body();
            // Implementar lógica para atualizar os horários da localização com ID
            return "Horários da localização com ID " + id + " atualizados com: " + body;
        });

        delete("/locations/:id", (req, res) -> {
            String id = req.params(":id");
            // Implementar lógica para deletar uma localização com o ID especificado
            return "Localização com ID " + id + " deletada";
        });

        // DELETE: Deletar um evento de uma localização
        delete("/locations/eventos/:id", (req, res) -> {
            String id = req.params(":id");
            // Implementar lógica para deletar um evento da localização com ID
            return "Evento com ID " + id + " deletado";
        });
    }

    // Método auxiliar para tratar exceções e configurar o status de resposta
    private String handleException(Exception e, Response res, int statusCode) {
        res.status(statusCode);
        return e.getMessage();
    }
}

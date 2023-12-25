package org.example.controllers;

import org.example.models.Evento;
import org.example.models.Horarios;
import org.example.models.Location;
import spark.Response;
import static spark.Spark.*;
import org.example.services.LocationService;
import com.google.gson.Gson;
import static spark.Spark.delete;

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

        // GET: Buscar uma localização específica pelo ID
        get("/locations/:id", (req, res) -> {
            res.type("application/json");
            try {
                int id = Integer.parseInt(req.params(":id"));
                Location location = locationService.getLocationById(id);
                return location != null ? gson.toJson(location) : "Localização não encontrada";
            } catch (NumberFormatException e) {
                res.status(400); // Bad Request
                return "ID inválido";
            } catch (Exception e) {
                res.status(500); // Internal Server Error
                return "Erro ao buscar localização";
            }
        });

        // GET: Buscar localizações pelo nome
        get("/locations/nome/:nome", (req, res) -> {
            res.type("application/json");
            try {
                String nome = req.params(":nome");
                List<Location> locations = locationService.getLocationsByName(nome);
                return gson.toJson(locations);
            } catch (Exception e) {
                res.status(500); // Internal Server Error
                return "Erro ao buscar localizações por nome";
            }
        });

        // GET: Buscar localizações por categoria
        get("/locations/categoria/:categoria", (req, res) -> {
            res.type("application/json");
            try {
                String categoria = req.params(":categoria");
                List<Location> locations = locationService.getLocationsByCategory(categoria);
                return gson.toJson(locations);
            } catch (Exception e) {
                res.status(500); // Internal Server Error
                return "Erro ao buscar localizações por categoria";
            }
        });

        // POST: Criar uma nova localização
        post("/locations", (req, res) -> {
            res.type("application/json");
            try {
                Location newLocation = gson.fromJson(req.body(), Location.class);
                Location createdLocation = locationService.createLocation(newLocation);
                res.status(201); // HTTP 201 Created
                return gson.toJson(createdLocation);
            } catch (Exception e) {
                res.status(500); // Internal Server Error
                return "Erro ao criar localização: " + e.getMessage();
            }
        });

        // POST: Criar um novo evento em uma localização
        post("/locations/eventos", (req, res) -> {
            res.type("application/json");
            try {
                Evento newEvento = gson.fromJson(req.body(), Evento.class);
                Evento createdEvento = locationService.createEvento(newEvento);
                res.status(201); // HTTP 201 Created
                return gson.toJson(createdEvento);
            } catch (Exception e) {
                res.status(500); // Internal Server Error
                return "Erro ao criar evento: " + e.getMessage();
            }
        });

        // PUT: Atualizar uma localização existente
        put("/locations/:id", (req, res) -> {
            res.type("application/json");
            try {
                int id = Integer.parseInt(req.params(":id"));
                Location updateData = gson.fromJson(req.body(), Location.class);
                Location updatedLocation = locationService.updateLocation(id, updateData);
                return updatedLocation != null ? gson.toJson(updatedLocation) : "Localização não encontrada";
            } catch (NumberFormatException e) {
                res.status(400); // Bad Request
                return "ID inválido";
            } catch (Exception e) {
                res.status(500); // Internal Server Error
                return "Erro ao atualizar localização";
            }
        });

        // PUT: Atualizar os horários de uma localização
        put("/locations/:id/horarios", (req, res) -> {
            res.type("application/json");
            try {
                int id = Integer.parseInt(req.params(":id"));
                // Assumindo que você tem uma classe Horario ou similar
                Horarios horario = gson.fromJson(req.body(), Horarios.class);
                Horarios updatedHorario = locationService.updateHorario(id, horario);
                return updatedHorario != null ? gson.toJson(updatedHorario) : "Horário não encontrado";
            } catch (NumberFormatException e) {
                res.status(400); // Bad Request
                return "ID inválido";
            } catch (Exception e) {
                res.status(500); // Internal Server Error
                return "Erro ao atualizar horário";
            }
        });

        // DELETE: Deletar uma localização com o ID especificado
        delete("/locations/:id", (req, res) -> {
            try {
                int id = Integer.parseInt(req.params(":id"));
                boolean deleted = locationService.deleteLocation(id);
                if (deleted) {
                    return "Localização com ID " + id + " deletada";
                } else {
                    res.status(404); // Not Found
                    return "Localização não encontrada";
                }
            } catch (NumberFormatException e) {
                res.status(400); // Bad Request
                return "ID inválido";
            } catch (Exception e) {
                res.status(500); // Internal Server Error
                return "Erro ao deletar localização";
            }
        });

        // DELETE: Deletar um evento de uma localização
        delete("/locations/eventos/:id", (req, res) -> {
            try {
                int id = Integer.parseInt(req.params(":id"));
                boolean deleted = locationService.deleteEvento(id);
                if (deleted) {
                    return "Evento com ID " + id + " deletado";
                } else {
                    res.status(404); // Not Found
                    return "Evento não encontrado";
                }
            } catch (NumberFormatException e) {
                res.status(400); // Bad Request
                return "ID inválido";
            } catch (Exception e) {
                res.status(500); // Internal Server Error
                return "Erro ao deletar evento";
            }
        });
    }

    // Método auxiliar para tratar exceções e configurar o status de resposta
    private String handleException(Exception e, Response res, int statusCode) {
        res.status(statusCode);
        return e.getMessage();
    }
}

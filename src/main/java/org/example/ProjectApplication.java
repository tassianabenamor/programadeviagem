package org.example;

import static spark.Spark.*;
import org.example.controllers.LocationController;
import org.example.exception.ResourceNotFoundException;

public class ProjectApplication {
    public static void main(String[] args) {
        // Configurar a porta em que o servidor Spark vai rodar
        port(8080);

        // Inicializa o controlador de localizações
        new LocationController();

        // Filtro para log de todas as requisições
        before((request, response) -> {
            System.out.println("Recebida uma requisição: " + request.requestMethod() + " " + request.uri());
        });

        // Tratamento global de exceções
        exception(Exception.class, (e, request, response) -> {
            e.printStackTrace(); // Log da exceção
            response.status(500);
            response.body("Ocorreu um erro interno no servidor.");
        });

        // Tratamento específico para ResourceNotFoundException
        exception(ResourceNotFoundException.class, (e, request, response) -> {
            response.status(404);
            response.body("Recurso não encontrado: " + e.getMessage());
        });

        // Resposta padrão para rotas não encontradas
        notFound((request, response) -> {
            response.type("application/json");
            return "{\"message\":\"Rota não encontrada\"}";
        });

        // Mensagem de inicialização
        System.out.println("Servidor rodando na porta 8080");
    }
}

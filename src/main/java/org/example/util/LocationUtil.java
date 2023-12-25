package org.example.util;

import com.google.gson.Gson;
import org.example.models.Location;

public class LocationUtil {

    // Método para converter um objeto Location em JSON
    public static String toJson(Location location) {
        Gson gson = new Gson();
        return gson.toJson(location);
    }

    // Método para converter JSON em um objeto Location
    public static Location fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Location.class);
    }

    // Método de exemplo para validar dados de uma localização
    public static boolean isValidLocation(Location location) {
        // Exemplo de validação: verifica se o nome e a descrição não são nulos ou vazios
        if (location.getNome() == null || location.getNome().trim().isEmpty()) {
            return false;
        }
        if (location.getDescricao() == null || location.getDescricao().trim().isEmpty()) {
            return false;
        }
        return true;
    }

    // Outros métodos utilitários conforme necessário
    // ...
}

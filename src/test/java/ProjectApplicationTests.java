import org.example.models.Location;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProjectApplicationTests {

    @Test
    public void testLocationCreation() {
        Location location = new Location(1, "Praia de Copacabana", "Uma bela praia no Rio de Janeiro");
        assertNotNull(location);
        assertEquals(1, location.getId());
        assertEquals("Praia de Copacabana", location.getNome());
        assertEquals("Uma bela praia no Rio de Janeiro", location.getDescricao());
    }

    @Test
    public void testLocationSettersAndGetters() {
        Location location = new Location();
        location.setId(2);
        location.setNome("Torre Eiffel");
        location.setDescricao("Famoso marco em Paris");

        assertEquals(2, location.getId());
        assertEquals("Torre Eiffel", location.getNome());
        assertEquals("Famoso marco em Paris", location.getDescricao());
    }

    // Aqui você pode adicionar mais testes para outras classes e funcionalidades
    // Por exemplo, testes para Rotas, Horarios, LocationController, etc.
}

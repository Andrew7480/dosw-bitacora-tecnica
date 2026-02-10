package dosw.bitacora.semana1;
import dosw.bitacora.semana1.util.*;
import dosw.bitacora.semana1.Streams;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StreamsTest {
    private List<Usuario> usuarios;
    private List<Transaction> transacciones;
    private List<Transaction> transacciones2;
    @BeforeEach
	void setUp() {
        usuarios = List.of(
            new Usuario("1","Juan", 25, true),
            new Usuario("2","Maria", 17, false),
            new Usuario("3","Pedro", 30, true),
            new Usuario("4","Ana", 22, false)
        );
        transacciones = List.of(
            new Transaction("T1", 100.0, true),
            new Transaction("T2", 200.0, true),
            new Transaction("T3", 150.0, false)
        );
        transacciones2 = List.of(
            new Transaction("T1", 100.0, false),
            new Transaction("T2", 200.0, false),
            new Transaction("T3", 150.0, false)
        );
	}
    @Test
    void testFiltrarParesMayoresA10() {
        List<Integer> numeros = List.of(5, 12, 18, 7, 22, 9, 3, 14);
        List<Integer> resultado = Streams.filtrarParesMayoresA10(numeros);
        assert(resultado.size() == 4);
    }
    @Test 
    void testContarPalabras() {
        List<String> palabras = List.of("hola", "mundo", "java", "programacion", "stream", "filter");
        Long resultado = Streams.contarPalabrasFiltro(palabras);
        assert(resultado == 4);
    }
    
    @Test
    void testFiltrarUsuariosActivos() {
        List<String> resultado = Streams.filtrarUsusariosActivos(usuarios);
        assert(resultado.size() == 2);
    }
    @Test
    void testFiltrarUsuariosMayoresDeEdad() {
        List<String> resultado = Streams.filtrarMayoresDeEdad(usuarios);
        assert(resultado.size() == 3);
    }

    @Test
    void testValidarTransacciones() {
        assertFalse(Streams.validarTransacciones(transacciones));
        assertFalse(Streams.validarTransacciones(transacciones2));
    }

}

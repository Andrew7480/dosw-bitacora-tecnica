package dosw.bitacora.semana1;
import java.util.List;

import dosw.bitacora.semana1.util.*;

public class Streams {

    // Dada una lista de numeros enteros, necesitamos obtener una nueva lista solo con los numeros pares mayores a diez
    public static List<Integer> filtrarParesMayoresA10(List<Integer> numeros) {
        return numeros.stream()
                    .filter(n -> n > 10 )
                    .filter(n -> n % 2 == 0)
                    .toList();
    }
    // Dada una lista de palabras, se requiere: Filtrar las palabras que tengan mas de 4 caracteres, convertirlas en Mayusculas, ordenarlas alfabeticamente y obtener la cantidad total de palabras resultantes
    public static Long contarPalabrasFiltro(List<String> palabra){
        return palabra.stream()
                    .filter(p -> p.length() > 4 )
                    .map(p -> p.toUpperCase())
                    .sorted()
                    .count();
    }

    // Dada una lista de usuarios, Filtra unicamente los usuarios activos, obten una lista con los nombres en mayuscula y ordena alfabeticamente el resultado
    public static List<String> filtrarUsusariosActivos(List<Usuario> usuarios){
        return usuarios.stream()
                    .filter( u -> u.isActive())
                    .map (u -> u.getName().toUpperCase())
                    .sorted()
                    .toList();
    }

    // Dado un listado de Usuarios y utilizando los mismo atributos anteriores, filtrar las personas mayores de edad y obtener sus nombres.
    public static List<String> filtrarMayoresDeEdad(List<Usuario> usuarios){
        return usuarios.stream()
                    .filter(u -> u.getAge() >= 18)
                    .map(u -> u.getName())
                    .toList();  
    }

    // Dada una lista de transacciones bancarias
    // Se requiere procesar la lista usando Streams para:
    // Usar peek para ver cada transacción procesada (Utilizar System.out.println para ver la transaccion)
    // Verificar si existe al menos una transacción no aprobada
    // Retornar true o false indicando si el lote de transacciones es válido.
    public static boolean validarTransacciones(List<Transaction> transacciones){
        return transacciones.stream()
                    .peek(t -> System.out.println("Procesando transaccion: " + t.getId() + ", Monto: " + t.getAmount() + ", Aprobada? : " + t.isApproved()))
                    .map(t -> t.isApproved())
                    .reduce(true, (a,b) -> a && b);
    }
}

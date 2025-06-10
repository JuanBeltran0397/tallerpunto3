import java.util.*;
//import java.util.stream.*;

public class MainPersona3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//se declara un objeto Scanner para leer datos desde la entrada estándar
        List<Persona> personas = new ArrayList<>();// se declara una lista de objetos tipo Persona

        personas.add(new Persona("Juan", "Morales", 45, "masculino", 56250, "dirEctor"));
        personas.add(new Persona("Andrea", "Martínez", 30, "femenino", 20000, "desarrollador"));
        personas.add(new Persona("Carlos", "Gómez", 28, "masculino", 18000, "desarrollador"));
        personas.add(new Persona("Any", "Mendoza", 32, "femenino", 22000, "analista"));
        personas.add(new Persona("Luis", "Montoya", 40, "masculino", 25000, "director"));
        personas.add(new Persona("Juan", "lopez", 52, "masculino", 100000, "director"));
        personas.add(new Persona("tathiana", "sanchez", 24, "femenino", 50000, "desarrollador"));
        personas.add(new Persona("Carlos", "puerta", 44, "masculino", 18000, "desarrollador"));
        personas.add(new Persona("Ana", "caicedo", 33, "femenino", 22000, "analista"));
        personas.add(new Persona("Luis", "bernal", 27, "masculino", 25000, "director"));

        //metodo para mostras los sueldos por 8 horas de los directores con genero masculino
        System.out.println("sueldo en 8 horas de los directores con genero masculino: ");
        personas.stream()
                .filter(persona -> persona.getCargo().equalsIgnoreCase("director") && persona.getGenero().equalsIgnoreCase("masculino"))
                .peek(persona -> System.out.println("Nombre: "+ persona.getNombre()+" "+ persona.getApellido()))
                .map(persona -> persona.getSueldohora() * 8)
                .forEach(sueldo -> System.out.println("Sueldo por 8 horas: $" + (int)sueldo + " pesos"));

        //metodo para mostrar la primera mujer desarrolladora
        System.out.println("\nPrimera mujer desarrolladora: ");
        Optional<Persona>desarrolladora= personas.stream()
                .filter(persona ->persona.getCargo().equalsIgnoreCase("desarrollador")&& persona.getGenero().equalsIgnoreCase("femenino"))
                .findFirst();
        desarrolladora.ifPresentOrElse(
                persona -> System.out.println("Nombre: " + persona.getNombre() + " " + persona.getApellido()),
                () -> System.out.println("No se encontró una mujer desarrolladora.")
        );

        //metodo para mostrar el desarrollador que mas gana por hora
        System.out.println("\nDesarrollador que más gana por hora: ");
        Optional<Persona> MasGana= personas.stream()
                .filter(persona ->persona.getCargo().equalsIgnoreCase("desarrollador") )
                .max(Comparator.comparingDouble(Persona::getSueldohora));

        if(MasGana.isPresent()){
            System.out.println("El desarrollador que mas gana por hora es: "+ MasGana.get());
        }else{
            System.out.println("No se encontró un desarrollador.");
        }

        // metodo para mostrar todas las mujeres ordenadas por su nombre
        System.out.println("\nMujeres ordenadas por nombre: ");
        personas.stream()
                .filter(persona -> persona.getGenero().equalsIgnoreCase("femenino"))
                .sorted(Comparator.comparing(Persona::getNombre))
                .forEach(System.out::println);
    }
}




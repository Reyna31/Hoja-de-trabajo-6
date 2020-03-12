//Pablo Cesar Reyna #19822


import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Cards mazo = new Cards();

        String opcion;
        int seleccionado = 0;

        ArrayList<Cards> cartas = new ArrayList<>();

        FactoryMap fm = new FactoryMap();
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el tipo de mapa que desea usar: (Textualmente) ");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedMap");
        opcion = sc.nextLine();
        if (opcion.equals("HashMap")){
            seleccionado = 1;
        }else if (opcion.equals("TreeMap")){
            seleccionado = 1;
        }else if (opcion.equals("LinkedMap")){
            seleccionado = 1;
        }
        while ((seleccionado == 0)){
            System.out.println("Error,porfavor ingrese nuevemente el tipo de mapa que desea usar: ");
            System.out.println("1. HashMap");
            System.out.println("2. TreeMap");
            System.out.println("3. LinkedMap");
            opcion = sc.nextLine();
            if (opcion.equals("HashMap")){
                seleccionado = 1;
            }else if (opcion.equals("TreeMap")){
                seleccionado = 1;
            }else if (opcion.equals("LinkedMap")){
                seleccionado = 1;
            };
        }
        Map<Integer, Cards> map = fm.FactoryCards(opcion);
        File archivo = new File("./cards_desc.txt");

        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);

        Scanner loader =new Scanner(br);
        int posicion = 0;

        while(loader.hasNextLine()){
            posicion++;
            String linea = loader.nextLine();
            int a = linea.indexOf("|");
            String name = linea.substring(0,a);
            String type = linea.substring(a+1, linea.length());
            map.put(posicion, new Cards(name, type));
        }
        int respuesta = 1;
        while (respuesta !=0){
            System.out.println("Ingrese el numero de la instruccion que deseas realizar");
            System.out.println("0. Salir.");
            System.out.println("1. Ver todas las cartas.");
            System.out.println("2. Mostrar la coleccion por tipo.");
            System.out.println("3. Agregar carta a la coleccion.");
            System.out.println("4. Mostrar las cartas de mi coleccion y sus cantidades.");
            System.out.println("5. Mostrar por tipo mi coleccion.");
            System.out.println("6. Mostrar tipo de carta ingresada.");
            respuesta = sc.nextInt();
            sc.nextLine();

            if (respuesta == 0){
                System.out.println("Ty");
            }else if (respuesta ==1){
                mazo.mostrarName(map);
            }else if (respuesta==2){
               System.out.println(mazo.ordenarColeccion(map));
            }else if (respuesta ==3){
                System.out.println("Ingrese el nombre de la carta que desea agregar: ");
                String cartaAgregar = sc.nextLine();
                if (mazo.index(map,cartaAgregar)){
                    cartas = mazo.agregarColeccion(map,cartaAgregar,cartas);
                    System.out.println("Se agrego  la carta a la coleccion");
                }else{
                    System.out.println("La carta ingresada no existe");
                }
            }else if (respuesta == 4){
                System.out.println(mazo.mostrarArray(cartas));
            }else if (respuesta == 5){
                System.out.println(mazo.ordenarMazo(cartas));
            }else if (respuesta == 6){
                System.out.println("Ingrese el nombre de la carta");
                String obtenerType = sc.nextLine();
                if(mazo.index(map,obtenerType) == true){
                    System.out.println(mazo.mostrarType(obtenerType, map));
                }else{
                    System.out.println("No se reconoce el nombre de la carta");
                }
            }else{
                System.out.println("Opcion no valida intente nuevamente");
            }
        }
    }
}

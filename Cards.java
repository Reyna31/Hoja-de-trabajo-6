//Pablo Cesar Reyna #19822
//GeeksforGeeks.org

import java.util.Collections;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;


public class Cards {
    private String Name;
    private String Type;

    public Cards(String nombre, String tipo){
        Name = nombre;
        Type = tipo;
    }
    public Cards (){

    }

    public String getName() {
        return Name;
    }

    public String getType() {
        return Type;
    }

    public String toString(){
        return Name + "" + Type;
    }

    public ArrayList<Cards> agregarColeccion(Map<Integer, Cards> map,String opcion, ArrayList<Cards> coleccion ){
        for (Entry<Integer,Cards> carta:map.entrySet()){
            Cards existe = carta.getValue();
            if(existe.getName().equals(opcion)){
                coleccion.add(new Cards(existe.getName(),existe.getType()));
                return coleccion;
            }
        }
        return null;
    }

    public boolean index(Map<Integer, Cards> map,String opcion){
        for(Entry<Integer,Cards> carta:map.entrySet()){
            Cards existe = carta.getValue();
            if (existe.getName().equals(opcion)){
                return true;
            }
        }
        return false;
    }

    public void mostrarName(Map<Integer, Cards> map){
        map.entrySet().forEach((carta) -> {
            Integer key = carta.getKey();
            Cards valor = carta.getValue();
            System.out.println(key + "." + valor.toString());
        });
    }

    public String mostrarType(String opcion,Map<Integer, Cards> map){
        String tipo ="";
        for (Entry<Integer, Cards> carta: map.entrySet()){
            Cards valor = carta.getValue();
            if(valor.getName().equals(opcion)){
                String nom = valor.getName();
                String tip =valor.getType();
                tipo = nom + "es de tipo" + tip;
            }
        }
        return tipo;
    }

    public String mostrarArray(ArrayList<Cards> coleccion){
        String cartas = "";
        int contador = 0;
        int monstruo =0, hechizo = 0, trampa =0;
        for(Cards carta: coleccion){
            contador++;
            cartas += contador + "." + carta.toString() +"\n";
            if(carta.getType().equals("Monstruo")){
                monstruo++;
            }if (carta.getType().equals("Hechizo")){
                hechizo++;
            }if(carta.getType().equals("Trampa")){
                trampa++;
            }
            else{
                return null;
            }
        }
        if (cartas.isEmpty()){
            return "No hay cartas";
        }else{
            cartas += "\nExisten cartas: " + "\n" + "Monstruo:" + monstruo +"\n" + "Hechizo: " + hechizo + "\n" +"Trampas: " + trampa + "\n";
        }
        return cartas;
    }

    public String ordenarMazo(ArrayList<Cards>mazo){
        Collections.sort(mazo,(Cards c1, Cards c2) -> c1.getType().compareTo(c2.getType()));
        String a = "";

        return mostrarArray(mazo);
    }

    public String ordenarColeccion(Map<Integer, Cards>map){
        Cards[] cartas = new Cards[map.size()];
        ArrayList<Cards> arreglo = new ArrayList<>();
        for (Entry<Integer, Cards> nueva: map.entrySet()){
            Cards valor = nueva.getValue();
            Cards nueva1 = new Cards(valor.getName(), valor.getType());
            arreglo.add(nueva1);
        }
        Collections.sort(arreglo, (Cards c1, Cards c2) -> c1.getType().compareTo(c2.getType()));
        for (int i = 0; i < arreglo.size();i++){
            cartas[i] = arreglo.get(i);
        }
        return ordenarMazo(arreglo);
    }

    public String contar (ArrayList<Cards> coleccion){
        String cartas = "";
        int contador = 0;
        int monstruo =0, hechizo = 0,trampa = 0;

        for(Cards carta: coleccion){
            contador++;
            cartas += contador + "." + carta.toString() + "\n";

            if(carta.getType().equals("Monstruo")){
                monstruo++;
            }else if (carta.getType().equals("Hechizo")){
                hechizo++;
            }else if (carta.getType().equals("Trampa")){
                trampa++;
            }
        }
        if(cartas.isEmpty()){
            return "No hay cartas existentes";
        }else{
            cartas += "\nExisten: " + "\n" + "Monstruo: " + monstruo + "\n" + "Hechizos: " + hechizo + "\n" + "Trampa: " + trampa + "\n";
        }
        return cartas;
    }
}


import java.util.Random;
import java.util.Scanner;

public class jugador {
    //Atributo:
    private int tiradas[];
    private int puntuacion;
    private int puntero; //Para poder moverse por el Array
    //Constructor:
    public jugador(){
        this.puntuacion=0;
        this.tiradas= new int[100]; 
        this.puntero = 0;
    }
    //Metodos:

    public int[] getTiradas() {
        return tiradas;
    }

    public void setTiradas(int tirada) {
        this.tiradas[this.getPuntero()] = tirada;
        this.setPuntero();
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntos) {
        this.puntuacion = this.getPuntuacion() + puntos;
    }

    public int getPuntero() {
        return puntero;
    }

    public void setPuntero() {
        this.puntero++;
    }
    
    public int dado(){
        Random rand;
        rand = new Random();
        
        return rand.nextInt(7);
    }
    
    public void jugada(){
        boolean s = true;
        int cont = 0;
        Scanner sca = new Scanner(System.in);
        int opcion = 1;
        
        do{
            int jugada = this.dado();
            
            this.setTiradas(jugada);
            
            System.out.println("Dado: " + jugada);

            if(jugada != 1 && opcion != 0){
                cont = cont + jugada;
                
                System.out.println("Acumulacion de Puntos: "+cont);
                
                System.out.println("Quieres tirar otra vez?: si: 1/no: 0");
                opcion = sca.nextInt();
            }else{
                cont = 0;
                s = false;
                System.out.println("Fin de ronda");
            }

        }while(s && opcion != 0);
                    
        this.setPuntuacion(cont);
    }
}

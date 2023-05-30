
import java.util.Random;
import java.util.Scanner;

public class Ia {
    //Atributo:
    private int puntuacion;
    private int nivel;
    //Constructor:
    public Ia(){
        this.puntuacion=0;
        this.nivel = 1;
    }
    //Metodos:

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntos) {
        this.puntuacion = this.getPuntuacion() + puntos;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    public int verPunciacionJugador(int PuntuacionJugador){
        return PuntuacionJugador;
    }
    
    public int dado(){
        Random rand;
        rand = new Random();
        
        return rand.nextInt(7);
    }
    
    public void nivel1(){
        boolean s = true;
        int cont = 0;
        int tirada=1;
        
        int opcion = 1;
        
        do{
            int jugada = this.dado();
            
            System.out.println("Dado: " + jugada);

            if(jugada != 1 && opcion != 0){
                cont = cont + jugada;
                
                System.out.println("Acumulacion de Puntos: "+cont);
                
                if(tirada >= 2){
                    opcion = 0;
                }

                tirada++;
            }else{
                cont = 0;
                s = false;
                System.out.println("Fin de ronda");
            }

        }while(s && opcion != 0);
                    
        this.setPuntuacion(cont);
    }
    
    public void nivel2(){
        boolean s = true;
        int cont = 0;

        
        int opcion = 1;
        
        do{
            int jugada = this.dado();
            
            System.out.println("Dado: " + jugada);

            if(jugada != 1 && opcion != 0){
                cont = cont + jugada;
                
                System.out.println("Acumulacion de Puntos: "+cont);
                
                if(cont >= 6){
                    opcion = 0;
                }

                
            }else{
                cont = 0;
                s = false;
                System.out.println("Fin de ronda");
            }

        }while(s && opcion != 0);
                    
        this.setPuntuacion(cont);
    }
    
    public void nivel3(int PuntuacionJugador){
        boolean s = true;
        int cont = 0;

        
        int opcion = 1;
        
        do{
            int jugada = this.dado();
            
            System.out.println("Dado: " + jugada);

            if(jugada != 1 && opcion != 0){
                cont = cont + jugada;
                
                System.out.println("Acumulacion de Puntos: "+cont);
                
                if(cont >= 6 || this.verPunciacionJugador(PuntuacionJugador) <= this.getPuntuacion()){
                    opcion = 0;
                }

                
            }else{
                cont = 0;
                s = false;
                System.out.println("Fin de ronda");
            }

        }while(s && opcion != 0);
                    
        this.setPuntuacion(cont);
    }
}

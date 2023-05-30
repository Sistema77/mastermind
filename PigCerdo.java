import java.util.Scanner;

public class PigCerdo {

    //Métodos:
    public int Puntuacion(int[] ListaPoint, int tirada){
        int cont=0;
        for(int i=0;i<tirada;i++){
            cont = cont + ListaPoint[i];
        }
        return cont;
    }
    public static void main(String[] args){
        //Entorno:
        Scanner sca = new Scanner(System.in);
        int opcion;
        jugador jugador = new jugador();
        Ia ia = new Ia();
        //Algoritmo:
        
        System.out.println("Elija el Nivel de la IA (1/2/3): ");
        ia.setNivel(sca.nextInt());

        
        do{
            System.out.println("--------Menu--------");
            System.out.println("1 - Ver Lista tiradas");
            System.out.println("2 - Ver Puntuación actual");
            System.out.println("3 - Tirar Dados");
            System.out.println("4 - Salir de Juego");
            System.out.println("--------------------");
            
            opcion = sca.nextInt();
            switch(opcion){
                case 1:
                    for(int i =0; i<jugador.getPuntero();i++){
                        System.out.print(" - " + jugador.getTiradas()[i]);
                    }
                    System.out.println();
                break;
                case 2:
                    System.out.println("jUGADOR: " + jugador.getPuntuacion());
                    System.out.println("IA: " + ia.getPuntuacion());
                break;
                case 3:
                    
                    jugador.jugada();
                    
                    if(jugador.getPuntuacion()<100){
                        System.out.println("-----------Turno de la IA----------");
                        if(ia.getNivel() == 1){
                            ia.nivel1();
                        }else if(ia.getNivel() == 2){
                            ia.nivel2();
                        }else if(ia.getNivel() == 3){
                            ia.nivel3(jugador.getPuntuacion());
                        }
                    }
                    
                break;
            }
        } while(opcion != 4 && jugador.getPuntuacion() < 100 && ia.getPuntuacion() < 100);
        
        if(jugador.getPuntuacion()>ia.getPuntuacion()){
            System.out.println("HAS GANADO :)");
        }else{
            System.out.println("HAS Perdido :(");
        }
    }
}

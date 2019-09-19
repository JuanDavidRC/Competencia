/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.competencia;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author JUAN DAVID REYES CORTES
 *  @author ALEJANDRO TORRES
 */
public class Competidor extends Thread{
    /**
     * objeto de la clase equipo
     */
    Equipo equipo;
    /**
     * posicion que se compara con los limites dados
     */
    private int posicion;
    /**
     * atrivubuto fin de la pista
     */
    private int fin;
    /**
     * atributo nque muestra en pista el equipo 1
     */
    private String equipo1;
    /**
     * atributo nque muestra en pista el equipo 2
     */
    private String equipo2;
    /**
     * atributo nque muestra en pista el equipo 2
     */
    private String equipo3;
    
    
    /**
     * Constuctor de la clase atleta que recible el equipo al que pertenece el 
     * atleta, su respectiva posicion inicial y final.
     * @param equipo
     * @param posicion
     * @param fin 
     */
    public Competidor(Equipo equipo, int posicion, int fin) {
        this.equipo = equipo;
        this.posicion = posicion;
        this.fin = fin;
    }
    /**
     * metodo con valores aleatorioa hasta 100
     * separados en diferentes rangos
     * @return 
     */
     public static int random(){
        double i=Math.random()*100;
        int j=(int) i;
        if(j<30){
            j=0;
        } 
        else if(j>=30&&j<60){
            j=1;
        }
        else if(j>=60&&j<90){
            j=2;
        }
        else if(j>=90){
            j=3;
        }
        return j;
    }
    /**
     * implementacionde el metodo run 
     */
    @Override
    public void run() {    
        if (posicion == 0) {
            relevo1();
        } else {
            synchronized (equipo) {
                try {
                    equipo.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Competidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        if (posicion == 33) {
            relevo2();            
        } else {
            synchronized (equipo) {
                try {
                    equipo.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Competidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        if (posicion == 66) {
            relevo3();
        } else {
            synchronized (equipo) {
                try {
                    equipo.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Competidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    /**
     * recibe valor entre 1 y 3 cada uno con difirentes limites 
     * para que se vea que continua el relevo con diferente corredor
     * @param competidor
     * @return 
     */
    public int carrera(int competidor) {
        try {
            Thread.sleep(500);            
        } catch (InterruptedException ex) {
            Logger.getLogger(Competidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        int valorAvance = random();      
        if (competidor == 1) {
            equipo.setLimeta1(equipo.getLimeta1() + valorAvance);
               posicion1();              
            return equipo.getLimeta1();
        }       
        if (competidor == 2) {
            equipo.setLimite2(equipo.getLimite2() + valorAvance);
            posicion2();          
            return equipo.getLimite2();
        }      
        if (competidor == 3) {
            equipo.setLimite3(equipo.getLimite3() + valorAvance);
            posicion3();
            return equipo.getLimite3();
        }
        return 0;
    }
        /**
         * bloque hasta el llamdo del metodo wait para
         * que continue al sigiente relevo
         */
    public void relevo1(){
        while (true) {
                int competidor = carrera(1);
                if (competidor >= 33) {
                    equipo.setLimeta1(33);
                    synchronized (equipo) {
                        equipo.notifyAll();
                        posicion = 33;
                    }
                    break;
                }
            }
    }
        /**
         * bloque hasta el llamdo del metodo wait para
         * que continue al sigiente relevo
         */
    public void relevo2(){
        while (true) {
                int competidor = carrera(2);
                if (competidor >= 66) {
                    equipo.setLimite2(66);
                    synchronized (equipo) {
                        equipo.notify();
                    }
                    break;
                }
            }
    }
        /**
         * bloque hasta el llamdo del metodo wait para
         * que continue al sigiente relevo
         */
    public void relevo3(){
        while (true) {
                int competidor = carrera(3);
                if (competidor >= 100) {
                    equipo.setLimite3(100);
                     System.out.println((char)27 + "[34;43mEL GANADOR ES : "+equipo.getNombre());
                    System.out.println("\033[33m _______________________*____________________: ");
                    System.out.println("\033[33m ____________________*     *____________________: ");
                    System.out.println("\033[33m __________________*         *____________________: ");
                    System.out.println("\033[33m _______________**             **___________________: ");
                    System.out.println("\033[33m _________________*           *____________________: ");
                    System.out.println("\033[32m __________________"+equipo.getNombre()+"__________________:");
                    System.out.println("\033[33m __________________*         *____________________: ");
                    System.out.println("\033[33m _________________*           *____________________: ");
                    System.out.println("\033[33m _______________*               *___________________: ");
                    System.out.println("\033[33m _________________*           *____________________: ");
                    System.out.println("\033[33m ____________________*     *____________________: ");
                    System.out.println("\033[33m _______________________*____________________: ");
                    System.exit(0);
                    break;
                }
            }
    }
        /**
         * inicia el relevo desde la posicion cero
         */
    public void posicion1(){
        if(equipo.imprimir().contains("Equipo 1")){
                equipo1=equipo.imprimir();            
            }else if(equipo.imprimir().contains("Equipo 2")){
                equipo2=equipo.imprimir();
            }else if(equipo.imprimir().contains("Equipo 3")){
                equipo3=equipo.imprimir();
                borado(); 
            }
            if(equipo1!=null){
                System.out.println(equipo1);               
            }
            if(equipo3!=null){
                System.out.println(equipo3);                
           }
            if(equipo2!=null){
                System.out.println(equipo2);               
            }
    }
    
        /**
         * da continuacion a el segundo relevo y cambia de color el personaje
         */
    public void posicion2(){
        if(equipo.imprimir().contains("Equipo 1")){
                equipo1=equipo.imprimir();
            }else if(equipo.imprimir().contains("Equipo 2")){
                equipo2=equipo.imprimir();
            }else if(equipo.imprimir().contains("Equipo 3")){
                equipo3=equipo.imprimir();
                borado(); 
            }
            if(equipo1!=null){
                System.out.println(equipo1);                
            }
            if(equipo3!=null){
                System.out.println(equipo3);              
            }
            if(equipo2!=null){
                System.out.println(equipo2);               
            }
    }
        /**
         * da continuacion al tercer relevo y cambia de color al los competidores
         * simultania mente
         */
    public void posicion3(){
        if(equipo.imprimir().contains("Equipo 1")){
                equipo1=equipo.imprimir();
            }else if(equipo.imprimir().contains("Equipo 2")){
                equipo2=equipo.imprimir();
            }else if(equipo.imprimir().contains("Equipo 3")){
                equipo3=equipo.imprimir();
               borado();
            }
            if(equipo1!=null){
                System.out.println(equipo1);   
            }
            if(equipo3!=null){
                System.out.println(equipo3);   
            }
            if(equipo2!=null){
                System.out.println(equipo2);   
            }     
    }
    /**
     *metodo vacio  permite ver con detalle
     * como corren los hilos
     */
    public void borado(){
        for (int i = 0; i < 10; i++) {
            System.out.println("\n");
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.competencia;

/**
 * @author JUAN DAVID REYES CORTES
 *  @author ALEJANDRO TORRES
 */
public class InicioHilo extends Thread{
    /**
     * llamado clase equipo con los parametros 
     * finales y muetra el nombre del ganador
     */
    Equipo equipo1 = new Equipo("Equipo 1", 0, 100);
    Equipo equipo2 = new Equipo("Equipo 2", 0, 100);
    Equipo equipo3 = new Equipo("Equipo 3", 0, 100);
    /**
     * llamado de la clase corredor con sus limites de inicio
     * hasta el primer relevo
     */
    Competidor corredor1 = new Competidor(equipo1, 0, 33);
    Competidor corredor2 = new Competidor(equipo2, 0, 33);
    Competidor corredor3 = new Competidor(equipo3, 0, 33);
    /**
     * llamado de la clase corredor con sus limites de primer relevo
     * hasta el segundo relevo
     */
    Competidor corredor4 = new Competidor(equipo1, 33, 66);
    Competidor corredor5 = new Competidor(equipo2, 33, 66);
    Competidor corredor6 = new Competidor(equipo3, 33, 66);
    /**
     * llamado de la clase corredor con sus limites de segundo relevo
     * hasta el ultimo relevo
     */
    Competidor corredor7 = new Competidor(equipo1, 66, 100);
    Competidor corredor8 = new Competidor(equipo2, 66, 100);
    Competidor corredor9 = new Competidor(equipo3, 66, 100);

    /**
     *constructor de la clase con la funcion de 
     * iniciar los hilos 
     */
    public  InicioHilo(){
         iniciar();
     }
     /**
      * funcion vacia que inicia los hilos 
      * al tiempo
      */
    public void iniciar(){
        /**
         * inicio hilo 1
         */
        corredor1.start ();
        /**
         * inicio hilo 2
         */
        corredor2.start ();
        /**
         * inicio hilo 3
         */
        corredor3.start ();
        /**
         * inicio hilo 4
         */
        corredor4.start ();
        /**
         * inicio hilo 5
         */
        corredor5.start ();
        /**
         * inicio hilo 6
         */
        corredor6.start ();
        /**
         * inicio hilo 7
         */
        corredor7.start ();
        /**
         * inicio hilo 8
         */
        corredor8.start ();
         /**
         * inicio hilo 9
         */
        corredor9.start ();
    }
}

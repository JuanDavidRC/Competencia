/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.competencia;
/**
 * @author JUAN DAVID REYES CORTES
 * @author ALEJANDRO TORRES
 */
public class Equipo extends Thread{
    /**
     * atributo que contiene el nombre del equipo
     */
     private String nombre;
    /**
     * atributo que inicia recoriendo el for hasta el limite
     */
    private int inicio;
    /**
     * atributo con el limite final de el for 
     * para pintar en la consola
     */
    private int fin;
    /***
     * atributo que contiene la primer posocion para los relevos
     */
    private int limeta1;
    /***
     * atributo que contiene la segunda posocion para los relevos
     */
    private int limite2;
    /***
     * atributo que contiene la tercera posocion para los relevos
     */
    private int limite3;
    /**
     * constructor de la clase con el nombre de el equipo
     * el inicio de la pista y el fin de la pista
     * @param nombre
     * @param inicio
     * @param fin 
     */
    public Equipo(String nombre, int inicio, int fin) {
        this.nombre = nombre;
        this.inicio = inicio;
        this.fin = fin;
        this.limeta1 = 0;
        this.limite2 = 33;
        this.limite3 = 66;
    }
    /**
     * metodo de tipo string que retorna la variable 
     * pista que mostrara todo en la consola
     * @return 
     */
    public synchronized String imprimir() {
        String pista = "\033[30m "+nombre+" ";
        for (int i = inicio; i <= fin; i++) {
            if (i == limeta1) {
                pista += "\033[34m¶";                    
            } else if (i == limite2) {
                pista += "\033[31m¶";
            } else if (i == limite3) {
                pista += "\033[32m¶";
            } else {
                pista += "*";
                
            }
        }        
        return pista;    
    }
    
    /**
     * metodo que muestra nombre
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * modica el nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * metodo que muestra inicio
     * @return 
     */
    public int getInicio() {
        return inicio;
    }
    /**
     * modica el inicio
     * @param inicio 
     */
    public void setInicio(int inicio) {
        this.inicio = inicio;
    }
    /**
     * metodo que muestra fin
     * @return 
     */
    public int getFin() {
        return fin;
    }
    /**
     * modica el fin
     * @param fin 
     */
    public void setFin(int fin) {
        this.fin = fin;
    }
    /**
     * metodo que muestra limite
     * @return 
     */
    public int getLimeta1() {
        return limeta1;
    }
    /**
     * modica el limite
     * @param limeta1 
     */
    public void setLimeta1(int limeta1) {
        this.limeta1 = limeta1;
    }
    /**
     * metodo que muestra limite
     * @return 
     */
    public int getLimite2() {
        return limite2;
    }
    /**
     * modica el limite
     * @param limite2 
     */
    public void setLimite2(int limite2) {
        this.limite2 = limite2;
    }
    /**
     * metodo que muestra limite
     * @return 
     */
    public int getLimite3() {
        return limite3;
    }
    /**
     * modica el limite
     * @param limite3 
     */
    public void setLimite3(int limite3) {
        this.limite3 = limite3;
    }
    
    
    
    
}

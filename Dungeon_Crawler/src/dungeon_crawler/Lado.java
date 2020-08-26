/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon_crawler;

/**
 *
 * @author User
 */
public class Lado {
    private char tipo;
    private boolean transito;

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public boolean getTransito() {
        return transito;
    }

    public void setTransito(boolean transito) {
        this.transito = transito;
    }
    
    public Lado (){
        tipo = 'n';
        transito = false;
    }
    
    public Lado(char x, boolean vis){
        tipo = x;
        transito = vis; 
    }
}

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
public class Visible {
    private boolean antorcha;
    private boolean mapa;

    public boolean getAntorcha() {
        return antorcha;
    }

    public void setAntorcha(boolean antorcha) {
        this.antorcha = antorcha;
    }

    public boolean getMapa() {
        return mapa;
    }

    public void setMapa(boolean mapa) {
        this.mapa = mapa;
    }
    
    public Visible(){
        antorcha = false;
        mapa = true;
    }
    
    public Visible(boolean ok){
        mapa = ok;
        antorcha = false;
    }
        
    public Visible(boolean map, boolean ant){
        mapa = map;
        antorcha = ant;
    }
}

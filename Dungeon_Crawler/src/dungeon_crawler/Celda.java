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
public class Celda {
       
    /* puerta: p ¨|'  '|¨   muro: m ¨|'  '|¨  
       puerta: p ¨      ¨   muro: m ¨|    |¨ 
       puerta: p ¨|,  ,|¨   muro: m ¨|,,,,|¨ */
    
    public Lado n;
    public Lado s;
    public Lado e;
    public Lado o;
    private Visible vis;
    private Entidad ent;
  //private Elemento element

    public Entidad getEnt() {
        return ent;
    }

    public void setEnt(Entidad ent) {
        this.ent = ent;
    }

    public Lado getN() {
        return n;
    }

    public void setN(Lado n) {
        this.n = n;
    }

    public Lado getS() {
        return s;
    }

    public void setS(Lado s) {
        this.s = s;
    }

    public Lado getE() {
        return e;
    }

    public void setE(Lado e) {
        this.e = e;
    }

    public Lado getO() {
        return o;
    }

    public void setO(Lado o) {
        this.o = o;
    }

    public Visible getVis() {
        return vis;
    }
    
    public boolean getVisAnt() {
        return vis.getAntorcha();
    }
    
    public boolean getVisMap() {
        return vis.getMapa();
    }
    public void setVis(Visible vis) {
        this.vis = vis;
    }
    
    public Celda (){
        Visible vis = new Visible();
        this.n = new Lado();
        this.s = new Lado();
        this.e = new Lado();
        this.o = new Lado();
    }
        
    public Celda(char n1, char s1, char e1, char o1, boolean ok){
        this.vis = new Visible(ok);
        if(n1 == 'p'){
            n = new Lado('p', ok);
        }
        else{
            n = new Lado('m', ok);
        }
        
        if(e1 == 'p'){
            e = new Lado('p', ok);
        }
        else{
            e = new Lado('m', ok);
        }
        
        if(s1 == 'p'){
            s = new Lado('p', ok);
        }
        else{
            s = new Lado('m', ok);
        }
        
        if(o1 == 'p'){
            o = new Lado('p', ok);
        }
        else{
            o = new Lado('m', ok);
        }
        this.ent = null;
    }   
    
    public void actVis(boolean ant, boolean map){
        Visible visaux = new Visible(map, ant);
        this.setVis(visaux);
    }
    
    public void toStringLineaA(){
        if(this.vis.getAntorcha() || this.vis.getMapa()){
            if(this.n.getTipo() == 'm'){
              System.out.print("|````|");
            }
            else{
                System.out.print("|`  `|");
            }
        }
        else{
            System.out.print("      ");
        }
    }
        
    public void toStringLineaB(){
        if(this.vis.getAntorcha() || this.vis.getMapa()){
            if(this.o.getTipo() == 'p'){
                System.out.print("  ");
            }
            else{
                System.out.print("| ");
            }
            if(this.ent != null){
                System.out.print("PJ");
            }
            else {
                if (this.vis.getMapa() && this.vis.getAntorcha() == false){
                    System.out.print("XX");
                }
                else{
                    System.out.print("  ");
                }
            }
            if(this.e.getTipo() == 'p'){
                System.out.print("  ");
            }
            else{
                System.out.print(" |");
            }        
        }
        else{
            System.out.print("      ");
        }
    }
        
    public void toStringLineaC(){
        if(this.vis.getAntorcha() || this.vis.getMapa()){
            if(this.s.getTipo() == 'm'){
                System.out.print("|,,,,|");
            }
            else{
                System.out.print("|,  ,|");
            }
        }
        else{
            System.out.print("      ");
        }
    }
        
    public void toString(int x){
        if (x == 0){
            this.toStringLineaA();
        }
        else{
            if(x == 1){
                this.toStringLineaB();
            }
            else{
                this.toStringLineaC();
            }
        }
    }

        
    /**static  void celda(){
        System.out.printl ("|````|");
        System.out.printl ("|    |");
        System.out.printl ("|,,,,|");
    }
    
    static  void celda_N(){
        System.out.printl ("|`  `|");
        System.out.printl ("|    |");
        System.out.printl ("|,,,,|");
    }
    
    static  void celda_S(){
        System.out.printl ("|````|");
        System.out.printl ("|    |");
        System.out.printl ("|,  ,|");
    }
    
    static  void celda_O(){
        System.out.printl ("|````|");
        System.out.printl ("     |");
        System.out.printl ("|,,,,|");
    }
    
    static  void celda_E(){
        System.out.printl ("|````|");
        System.out.printl ("|     ");
        System.out.printl ("|,,,,|");
    }
    
    static  void celda_N_O(){
        System.out.printl ("|`  `|");
        System.out.printl ("     |");
        System.out.printl ("|,,,,|");
    }
    
    static  void celda_N_E(){
        System.out.printl ("|`  `|");
        System.out.printl ("|     ");
        System.out.printl ("|,,,,|");
    }
    
    static  void celda_N_S(){
        System.out.printl ("|`  `|");
        System.out.printl ("|    |");
        System.out.printl ("|,  ,|");
    }
    
    static  void celda_N_E_O(){
        System.out.printl ("|`  `|");
        System.out.printl ("      ");
        System.out.printl ("|,,,,|");
    }
    
    static  void celda_N_O_S(){
        System.out.printl ("|`  `|");
        System.out.printl ("     |");
        System.out.printl ("|,  ,|");
    }
    
    static  void celda_N_E_S(){
        System.out.printl ("|`  `|");
        System.out.printl ("|     ");
        System.out.printl ("|,  ,|");
    }
    
    static  void celda_S_E_O(){
        System.out.printl ("|````|");
        System.out.printl ("      ");
        System.out.printl ("|,  ,|");
    }
    
    static  void celda_S_E(){
        System.out.printl ("|````|");
        System.out.printl ("|     ");
        System.out.printl ("|,  ,|");
    }
    
    static  void celda_S_O(){
        System.out.printl ("|````|");
        System.out.printl ("     |");
        System.out.printl ("|,  ,|");
    }
    
    static  void celda_N_S_E_O(){
        System.out.printl ("|`  `|");
        System.out.printl ("      ");
        System.out.printl ("|,  ,|");
    }
    */
    
}

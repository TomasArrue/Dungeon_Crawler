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
public class Mapa {
    private Celda map[][];
    private int fila;
    private int columna;
    private int filaAct;
    private int columnaAct;

    public Celda getMap(int x, int y) {
        return map[x][y];
    }

    private void setMap(Celda cel, int x, int y) {
        this.map[x][y] = cel;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
  
    public Mapa(){
        this.fila = 10;
        this.columna = 10;
        this.map = new Celda[fila][columna];
        int x;
        int y;
        /*
        for(x = 0; x < fila; x++){
            for(y = 0; y < columna; y++){
                this.map[x][y] = new Celda('m', 'm', 'm', 'm', true);
            }
        }
        */
        
        //Este for carga los bordes con paredes
        int auxFila = fila -1 ;
        int auxColumna = columna -1;
        for(x = 1; x < auxFila; x++){
            this.map[x][0] = new Celda('p', 'p', 'p', 'm', true);
            this.map[x][auxColumna] = new Celda('p', 'p', 'm', 'p', true);
            this.map[0][x] = new Celda('m', 'p', 'p', 'p', true);
            this.map[auxFila][x] = new Celda('p', 'm', 'p', 'm', true);    
        }
        
        //Cargando las esquinas del mapa
        this.map[0][0] = new Celda('m', 'p', 'p', 'm', true);
        this.map[auxFila][0] = new Celda('p', 'm', 'p', 'm', true);
        this.map[0][auxColumna] = new Celda('m', 'p', 'm', 'p', true);
        this.map[auxFila][auxColumna] = new Celda('p', 'm', 'm', 'p', true);
        
        // este doble For cargara el rrelleno de la matriz con celdas abiertas 
        for(x = 1; x < auxFila; x++){
            for(y = 1; y < auxColumna; y++){
                this.map[x][y] = new Celda('p', 'p', 'p', 'p', true);
            }
        }
        
    }
    
    public Mapa(int x, int y){
        fila = x;
        columna = y;
        map[fila][columna] = new Celda();
        for(x = 0; x < fila; x++){
            for(y = 0; y < columna; y++){
                this.map[x][y] = new Celda('p', 'p', 'p', 'p', true);
            }
        }
    }
    
    /* public void cargarMapa(){
        int x;
        int y;
        for(x = 0; x < 5; x++){
            for(y = 0; y < 5; x++){
                map[x][y] = new Celda('p', 'p', 'p', 'p', true);
            }
        }
    }
    */
    
    public void tp(int x, int y){
        if((x < fila && x >= 0) && (y < columna && y >= 0)){
            map[x][y].setEnt(map[filaAct][columnaAct].getEnt());
            map[filaAct][columnaAct].setEnt(null);
            filaAct = x;
            columnaAct = y;
        }
    }
    
    public void mapoff(){
        int x, y;
        for(x = 0; x < fila; x++){
            for(y = 0; y < columna; y++){
                 this.actualizarVisionCelda(x, y, this.map[x][y].getVisAnt(), false);
            }
        }
    }
    
    public void actualizarVisionAntorcha()/*modifica la vision de la antorcha*/{
        int x, y;
        for(x = 0; x < fila; x++){
            for(y = 0; y < columna; y++){
                this.actualizarVisionCelda(x, y, false, this.map[x][y].getVisMap());
            }
        }
        this.map[filaAct][columnaAct].actVis(true, true);
        
        if(filaAct + 1 < fila)
        this.map[filaAct + 1][columnaAct].actVis(true, true);
        
        if(filaAct + 2 < fila)
        this.map[filaAct + 2][columnaAct].actVis(true, true);
        
        if(filaAct - 1 >= 0)
        this.map[filaAct - 1][columnaAct].actVis(true, true);
        
        if(filaAct - 2 >= 0)
        this.map[filaAct - 2][columnaAct].actVis(true, true);
        
        if(columnaAct + 1 < columna)
        this.map[filaAct][columnaAct + 1].actVis(true, true);
        
        if(columnaAct + 2 < columna)
        this.map[filaAct][columnaAct + 2].actVis(true, true);
        
        if(columnaAct - 1 >= 0)
        this.map[filaAct][columnaAct - 1].actVis(true, true);
        
        if(columnaAct - 2 >= 0)
        this.map[filaAct][columnaAct - 2].actVis(true, true);
        
        if(filaAct + 1 < fila && columnaAct + 1 < columna)
        this.map[filaAct + 1][columnaAct + 1].actVis(true, true);
        
        if(filaAct - 1 >= 0 && columnaAct - 1 >= 0)
        this.map[filaAct - 1][columnaAct - 1].actVis(true, true);
        
        if(filaAct + 1 < fila && columnaAct - 1 >= 0)
        this.map[filaAct + 1][columnaAct - 1].actVis(true, true);
        
        if(filaAct - 1 >= 0 && columnaAct + 1 < columna)
        this.map[filaAct - 1][columnaAct + 1].actVis(true, true);
    }
    
    public void actualizarVisionCelda(int fil, int col, boolean ant, boolean map)/*este metodo actualiza la iluminacion de una celda*/{
        this.map[fil][col].actVis(ant, map);
    }
    
    public void actualizarCelda(int fil, int col,Lado nAux, Lado sAux, Lado eAux, Lado oAux, Entidad entAux)/*cambia los muros, pasillo y/o el elemento en la celda*/{
        this.map[fil][col].setN(nAux);
        this.map[fil][col].setS(sAux);
        this.map[fil][col].setE(eAux);
        this.map[fil][col].setO(oAux);
        this.map[fil][col].setEnt(entAux);
    }
    
    public void posInicial(int fil, int col)/*establece la posicion de inicio*/{
        Entidad aux = new Entidad();
        map[fil][col].setEnt(aux);
        filaAct = fil;
        columnaAct = col;
    }
    
    public void mover(int filNue, int colNue)/*despaza al jugador una celda por los puntos cardinales*/{
        map[filNue][colNue].setEnt(map[filaAct][columnaAct].getEnt());
        map[filaAct][columnaAct].setEnt(null);
        filaAct = filNue;
        columnaAct = colNue;
}
    
    public void chekMove(char aux)/*corrobora si hay espacio y no alla muros que bloqueen el movimiento*/{
        boolean paso1 =false, paso2  =false, espacio =false;
        if (aux == 'w'){
            if(map[filaAct][columnaAct].n.getTipo() != 'm') {
                paso1 = true;
            }
            else {
                paso1 = false;
            }
            if(paso1){
                if(filaAct > 0){
                    espacio = true;
                }
                else {
                    espacio = false;
                }
                if(espacio){
                    if(map[filaAct - 1][columnaAct].s.getTipo() != 'm'){
                        paso2 = true;
                    }
                    else{
                        paso2 =false;
                    }
                }
            if((paso1) && (paso2) && (espacio))    
                this.mover( filaAct - 1, columnaAct);
            }    
            else {
                System.out.println("Un muro impede tu camino direccion Norte");
            }
        }
        else {
            if (aux == 's'){
                if(map[filaAct][columnaAct].s.getTipo() != 'm') {
                    paso1 = true;
                }
                else {
                    paso1 = false;
                }
                if(paso1){
                    if(filaAct < fila){
                        espacio = true;
                    }
                    else {
                        espacio = false;
                    }
                    if(espacio){
                        if(map[filaAct + 1][columnaAct].n.getTipo() != 'm'){
                            paso2 = true;
                        }
                        else{
                            paso2 =false;
                        }
                    }
                if((paso1) && (paso2) && (espacio))    
                    this.mover( filaAct + 1, columnaAct);
                }
                else {
                    System.out.println("Un muro impede tu camino direccion Sur");
                }
                    
            }
            else{
                if (aux == 'a'){
                    if(map[filaAct][columnaAct].o.getTipo() != 'm') {
                        paso1 = true;
                    }
                    else {
                        paso1 = false;
                    }
                    if(paso1){
                        if(columnaAct > 0){
                        espacio = true;
                        }
                        else {
                            espacio = false;
                        }
                        if(espacio){
                            if(map[filaAct][columnaAct - 1].e.getTipo() != 'm'){
                                paso2 = true;
                            }
                            else{
                                paso2 =false;
                            }
                        }
                    if((paso1) && (paso2) && (espacio))    
                        this.mover( filaAct, columnaAct - 1);
                    }    
                    else {
                        System.out.println("Un muro impede tu camino direccion Oeste");
                    }
                }
                else{
                    if (aux == 'd'){
                        if(map[filaAct][columnaAct].e.getTipo() != 'm') {
                            paso1 = true;
                        }
                        else {
                            paso1 = false;
                        }
                        if(paso1){
                            if(columnaAct < columna){
                            espacio = true;
                            }
                            else {
                                espacio = false;
                            }
                            if(espacio){
                                if(map[filaAct][columnaAct + 1].o.getTipo() != 'm'){
                                    paso2 = true;
                                }
                                else{
                                    paso2 =false;
                                }
                            }
                        if((paso1) && (paso2) && (espacio))    
                            this.mover( filaAct, columnaAct + 1);
                        }    
                        else {
                            System.out.println("Un muro impede tu camino direccion Este");
                        }
                    }
                    }
                }
        }
    }
    
    public void imprimirMapa(){
        this.actualizarVisionAntorcha();
        int x;
        int y;
        int z;
        for(x = 0; x < fila; x++){
            for(z = 0; z <= 2; z++){
                for(y = 0; y < columna; y++){
                    map[x][y].toString(z);
                }
                System.out.println("");
            }
        }
    }
}

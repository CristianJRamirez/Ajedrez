import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 45858000w on 06/02/17.
 */
public class Program {

    private static String[][] tablero;

    ArrayList<String> movimientos = new ArrayList<>();
    public static void main(String[] args) {

        tablero = new String[8][8];

        limpiarTablero();

        Caballo c = new Caballo(0, 0);

        //recorrerTablero(c,c.getX(),c.getY(),0,"");

        recursiva(c,c.getX(),c.getY(),"",tablero);

        mostrarTablero(tablero);

    }

    public static void limpiarTablero() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = "  ";
            }
        }
    }
//TODO: coger una casilla y hacer todos los movimientos desde esa casilla posible, y partir de la nueva repetir el proceso

    private static void recorrerTablero(Caballo c, int x, int y, int i,String camino)
    {
        int posX = x;
        int posY = y;
        tablero[posX][posY] = "X";

        if (posX + 2 <= 7 && posY + 1 <= 7 && tablero[posX + 2][posY + 1].equals("  ")) {
            System.out.println("POS (" + i + ")-> [+2][+1] -> [" + posX + "][" + posY + "] ---> "+camino+"  ----> [" + camino.length()/2 + "]");
            posX = posX + 2;
            posY = posY + 1;
            i++;
            camino=camino+"-A";
            tablero[posX][posY] = i + "";
            recorrerTablero(c,posX,posY,i,camino);
        }
        if (posX + 2 <= 7 && posY - 1 >= 0 && tablero[posX + 2][posY - 1].equals("  ")) {
            System.out.println("POS (" + i + ")-> [+2][-1] -> [" + posX + "][" + posY + "] ---> "+camino+"  ----> [" + camino.length()/2 + "]");
            posX = posX + 2;
            posY = posY - 1;
            i++;
            camino=camino+"-B";
            tablero[posX][posY] = i + "";
            recorrerTablero(c,posX,posY,i,camino);
        }
        if (posX + 1 <= 7 && posY + 2 <= 7 && tablero[posX + 1][posY + 2].equals("  ")) {
            System.out.println("POS (" + i + ")-> [+1][+2] -> [" + posX + "][" + posY + "] ---> "+camino+"  ----> [" + camino.length()/2 + "]");
            posX = posX + 1;
            posY = posY + 2;
            i++;
            camino=camino+"-C";
            tablero[posX][posY] = i + "";
            recorrerTablero(c,posX,posY,i,camino);
        }
        if (posX - 1 >= 0 && posY + 2 <= 7 && tablero[posX - 1][posY + 2].equals("  ")) {
            System.out.println("POS (" + i + ")-> [-1][+2] -> [" + posX + "][" + posY + "] ---> "+camino+"  ----> [" + camino.length()/2 + "]");
            posX = posX - 1;
            posY = posY + 2;
            i++;
            camino=camino+"-D";
            tablero[posX][posY] = i + "";
            recorrerTablero(c,posX,posY,i,camino);
        }
        if (posX - 2 >= 0 && posY + 1 <= 7 && tablero[posX - 2][posY + 1].equals("  ")) {
            System.out.println("POS (" + i + ")-> [-2][+1] -> [" + posX + "][" + posY + "] ---> "+camino+"  ----> [" + camino.length()/2 + "]");
            posX = posX - 2;
            posY = posY + 1;
            i++;
            camino=camino+"-E";
            tablero[posX][posY] = i + "";
            recorrerTablero(c,posX,posY,i,camino);
        }
        if (posX - 2 >= 0 && posY - 1 >= 0 && tablero[posX - 2][posY - 1].equals("  ")) {
            System.out.println("POS (" + i + ")-> [-2][-1] -> [" + posX + "][" + posY + "] ---> "+camino+"  ----> [" + camino.length()/2 + "]");
            posX = posX - 2;
            posY = posY - 1;
            i++;
            camino=camino+"-F";
            tablero[posX][posY] = i + "";
            recorrerTablero(c,posX,posY,i,camino);
        }
        if (posX + 1 <= 7 && posY - 2 >= 0 && tablero[posX + 1][posY - 2].equals("  ")) {
            System.out.println("POS (" + i + ")-> [+1][-2] -> [" + posX + "][" + posY + "] ---> "+camino+"  ----> [" + camino.length()/2 + "]");
            posX = posX + 1;
            posY = posY - 2;
            i++;
            camino=camino+"-G";
            tablero[posX][posY] = i + "";
            recorrerTablero(c,posX,posY,i,camino);

        }
        if (posX - 1 >= 0 && posY - 2 >= 0 && tablero[posX - 1][posY - 2].equals("  ")) {
            System.out.println("POS (" + i + ")-> [-1][-2] -> [" + posX + "][" + posY + "] ---> "+camino+"  ----> [" + camino.length()/2 + "]");
            posX = posX - 1;
            posY = posY - 2;
            i++;
            camino=camino+"-H";
            tablero[posX][posY] = i + "";
            recorrerTablero(c,posX,posY,i,camino);
        } else {
            //System.out.println("intento fallido" + i);


            mostrarTablero(tablero);
            //System.out.println("POS (" + i + ")----> [" + posX + "][" + posY + "] ");
        }
        //System.out.println("POS (" + i + ")----> [" + posX + "][" + posY + "] ");


    }

    public static void mostrarTablero(String[][] tablero) {
        System.out.print("[X]->");
        for (int i = 0; i < 8; i++) {
            System.out.print("[" + i + "]  ");
        }

        System.out.println();
        for (int i = 0; i < 8; i++) {
            System.out.print("[" + i + "]->");
            for (int j = 0; j < 8; j++) {
                System.out.print("[" + tablero[i][j] + "]  ");
            }
            System.out.println();
        }

        comprobarTablero(tablero);

    }

    public static int comprobarTablero(String[][] tablero)
    {
        int c = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero[i][j].equals("  ")) {
                    c++;
                }
                else if (tablero[i][j].equals(" ")) {
                    c++;
                }
            }
        }

        System.out.println("Hay " + c + " posicines vacias");
        return c;
    }

    public static void recursiva(Caballo c, int x, int y,String camino,String[][] tablero){
        Scanner sc = new Scanner(System.in);
        String ss= sc.nextLine();
        do{
            int posX = x;
            int posY = y;
            //tablero[posX][posY] = "X";
            if (posX + 2 <= 7 && posY + 1 <= 7 && tablero[posX + 2][posY + 1].equals("  ")) {
                System.out.println("POS (" + camino.length() + ")-> [+2][+1] -> [" + posX + "][" + posY + "] ---> " + camino + "  ----> [" + camino.length()  + "]");
                marcarCasilla("A",tablero,posX,posY,camino.length());
                mostrarTablero(tablero);
                //posX = posX + 2;
                //posY = posY + 1;
                camino = camino + "A";
                recursiva(c, posX+2, posY+1, camino,tablero);
            }
            if (posX + 2 <= 7 && posY - 1 >= 0 && tablero[posX + 2][posY - 1].equals("  ")) {
                System.out.println("POS (" + camino.length() + ")-> [+2][-1] -> [" + posX + "][" + posY + "] ---> " + camino + "  ----> [" + camino.length()  + "]");
                marcarCasilla("B",tablero,posX,posY,camino.length());
                mostrarTablero(tablero);
                //posX = posX + 2;
                //posY = posY - 1;
                camino = camino + "B";
                recursiva(c, posX+2, posY-1, camino,tablero);
            }
            if (posX + 1 <= 7 && posY + 2 <= 7 && tablero[posX + 1][posY + 2].equals("  ")) {
                System.out.println("POS (" + camino.length() + ")-> [+1][+2] -> [" + posX + "][" + posY + "] ---> " + camino + "  ----> [" + camino.length()  + "]");
                marcarCasilla("C",tablero,posX,posY,camino.length());
                mostrarTablero(tablero);
                //posX = posX + 1;
                //posY = posY + 2;
                camino = camino + "C";
                recursiva(c, posX+1, posY+2, camino,tablero);

            }
            if (posX - 1 >= 0 && posY + 2 <= 7 && tablero[posX - 1][posY + 2].equals("  ")) {
                System.out.println("POS (" + camino.length() + ")-> [-1][+2] -> [" + posX + "][" + posY + "] ---> " + camino + "  ----> [" + camino.length()  + "]");
                marcarCasilla("D",tablero,posX,posY,camino.length());
                mostrarTablero(tablero);
                //posX = posX - 1;
                //posY = posY + 2;
                camino = camino + "D";
                recursiva(c, posX-1, posY+2, camino,tablero);
            }
            if (posX - 2 >= 0 && posY + 1 <= 7 && tablero[posX - 2][posY + 1].equals("  ")) {
                System.out.println("POS (" + camino.length() + ")-> [-2][+1] -> [" + posX + "][" + posY + "] ---> " + camino + "  ----> [" + camino.length()  + "]");
                marcarCasilla("E",tablero,posX,posY,camino.length());
                mostrarTablero(tablero);
                //posX = posX - 2;
                //posY = posY + 1;
                camino = camino + "E";
                recursiva(c, posX-2, posY+1, camino,tablero);
            }
            if (posX - 2 >= 0 && posY - 1 >= 0 && tablero[posX - 2][posY - 1].equals("  ")) {
                System.out.println("POS (" + camino.length() + ")-> [-2][-1] -> [" + posX + "][" + posY + "] ---> " + camino + "  ----> [" + camino.length()  + "]");
                marcarCasilla("F",tablero,posX,posY,camino.length());
                mostrarTablero(tablero);
                //posX = posX - 2;
                //posY = posY - 1;
                camino = camino + "F";
                recursiva(c, posX-2, posY-1, camino,tablero);
            }
            if (posX + 1 <= 7 && posY - 2 >= 0 && tablero[posX + 1][posY - 2].equals("  ")) {
                System.out.println("POS (" + camino.length() + ")-> [+1][-2] -> [" + posX + "][" + posY + "] ---> " + camino + "  ----> [" + camino.length()  + "]");
                marcarCasilla("G",tablero,posX,posY,camino.length());
                mostrarTablero(tablero);
                //posX = posX + 1;
                //posY = posY - 2;
                camino = camino + "G";
                recursiva(c, posX+1, posY-2, camino,tablero);

            }
            if (posX - 1 >= 0 && posY - 2 >= 0 && tablero[posX - 1][posY - 2].equals("  ")) {
                System.out.println("POS (" + camino.length() + ")-> [-1][-2] -> [" + posX + "][" + posY + "] ---> " + camino + "  ----> [" + camino.length() + "]");
                marcarCasilla("H",tablero,posX,posY,camino.length());
                mostrarTablero(tablero);
                //posX = posX - 1;
                //posY = posY - 2;
                camino = camino + "H";
                recursiva(c, posX - 1, posY - 2, camino,tablero);
            }
            if (!(posX - 1 >= 0 && posY - 2 >= 0 && tablero[posX - 1][posY - 2].equals("  ")) &&
                    !(posX - 2 >= 0 && posY + 1 <= 7 && tablero[posX - 2][posY + 1].equals("  "))  &&
                    !(posX - 2 >= 0 && posY - 1 >= 0 && tablero[posX - 2][posY - 1].equals("  ")) &&
                    !(posX + 1 <= 7 && posY - 2 >= 0 && tablero[posX + 1][posY - 2].equals("  ")) &&
                    !(posX + 2 <= 7 && posY + 1 <= 7 && tablero[posX + 2][posY + 1].equals("  ")) &&
                    !(posX + 2 <= 7 && posY - 1 >= 0 && tablero[posX + 2][posY - 1].equals("  ")) &&
                    !(posX + 1 <= 7 && posY + 2 <= 7 && tablero[posX + 1][posY + 2].equals("  ")) &&
                    !(posX - 1 >= 0 && posY + 2 <= 7 && tablero[posX - 1][posY + 2].equals("  ")))
            {
                //System.out.println("intento fallido" + i);
                camino= desmarcarCasilla(camino,tablero,posX,posY);
                mostrarTablero(tablero);
            }
            //System.out.println("POS (" + i + ")----> [" + posX + "][" + posY + "] ");
        }while(comprobarTablero(tablero)>0);
    }


    public static void marcarCasilla(String opcion, String[][] tablero, int X, int Y,int pos)
    {
        int posX=X;
        int posY=Y;
        switch (opcion ) {
            case "A":
                posX = posX + 2;
                posY = posY + 1;
                break;
            case "B":
                posX = posX + 2;
                posY = posY - 1;
                break;
            case "C":
                posX = posX + 1;
                posY = posY + 2;
                break;
            case "D":
                posX = posX - 1;
                posY = posY + 2;
                break;
            case "E":
                posX = posX - 2;
                posY = posY + 1;
                break;
            case "F":
                posX = posX - 2;
                posY = posY - 1;
                break;
            case "G":
                posX = posX + 1;
                posY = posY - 2;
                break;
            case "H":
                posX = posX - 1;
                posY = posY - 2;
                break;
        }
        if (pos<10) {
            tablero[posX][posY] = pos + " ";
        }
        else {
            tablero[posX][posY] = pos + "";
        }

    }

    public static String desmarcarCasilla(String camino,String [][] tablero, int X, int Y)
    {
        int posX=X;
        int posY=Y;
        switch (camino.substring( camino.length()) ) {
            case "A":
                posX = posX - 2;
                posY = posY - 1;
                break;
            case "B":
                posX = posX - 2;
                posY = posY + 1;
                break;
            case "C":
                posX = posX - 1;
                posY = posY - 2;
                break;
            case "D":
                posX = posX + 1;
                posY = posY - 2;
                break;
            case "E":
                posX = posX + 2;
                posY = posY - 1;
                break;
            case "F":
                posX = posX + 2;
                posY = posY + 1;
                break;
            case "G":
                posX = posX - 1;
                posY = posY + 2;
                break;
            case "H":
                posX = posX + 1;
                posY = posY + 2;
                break;
        }

        tablero[posX][posY]="  ";
        return camino.substring(0, camino.length()-1);

    }




}

package Juego;

import java.awt.geom.Rectangle2D;

public class Pelota {

    public static final int TAMX = 15;
    public static final int TAMY = 15;
    public double x = 0;
    public static double y = 0;
    public double dx = 1;
    public double dy = 1;
    public int contador1 = 0;
    public int contador2 = 0;

    private Integer score1 = 0, score2 = 0;
    public static boolean finJuego = false;

    public Rectangle2D getShape() {
        return new Rectangle2D.Double(x, y, TAMX, TAMY);
    }

    public void moverPelota(Rectangle2D limites, boolean colisionR1, boolean colisionR2) {
        x += dx;
        y += dy;

        if (colisionR1) {
            dx = -dx;
            x = 20;

        }
        if (colisionR2) {
            dx = -dx;
            x = 755;

        }

        if (x < limites.getMinX()) {
            score2++; //el puntaje del jugador2 aumenta en uno

            x = limites.getCenterX();
            y = limites.getCenterY();
            dx = -dx;

        }

        if (x + TAMX >= limites.getMaxX()) {
            score1++; //el puntaje del jugador1 aumenta en uno

            x = limites.getCenterX();
            y = limites.getCenterY();
            dx = -dx;

        }

        if (y < limites.getMinY()) {

            y = limites.getMinY();

            dy = -dy;

        }

        if (y + TAMY >= limites.getMaxY()) {

            y = limites.getMaxY() - TAMY;

            dy = -dy;

        }

    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

}

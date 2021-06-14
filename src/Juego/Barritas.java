package Juego;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Barritas {

    public int x, y;
    public static final int ANCHO = 10, ALTO = 40;

    public Barritas(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Rectangle2D getBarrita() {
        return new Rectangle2D.Double(x, y, ANCHO, ALTO);
    }

    public void moverJ1(Rectangle limites) {
        if (Controles.w && y > limites.getMinY()) {
            y--;
        }
        if (Controles.s && y < limites.getMaxY() - ALTO) {
            y++;
        }
    }

    public void moverJ2(Rectangle limites) {
        if (Controles.up && y > limites.getMinY()) {
            y--;
        }
        if (Controles.down && y < limites.getMaxY() - ALTO) {
            y++;
        }
    }
}

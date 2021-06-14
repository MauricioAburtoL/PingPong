package Juego;

import Vista.*;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class Mesa extends JPanel {

    Barritas r1 = new Barritas(10, 200);
    Barritas r2 = new Barritas(794 - 10 - Barritas.ANCHO, 200);
    Pelota p = new Pelota();

    public Mesa() {
        this.setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(new Color((int)(Math.random() * 0x1000000)));
        dibujarPuntaje(g2);
        dibujar(g2);

    }

    public void dibujar(Graphics2D g) {
        Line2D.Double linea = new Line2D.Double(getBounds().getCenterX(), 0, getBounds().getCenterX(), getBounds().getMaxY());

        g.draw(linea);

        g.fill(r1.getBarrita());
        update();

        g.fill(r2.getBarrita());
        update();

        g.fill(p.getShape());
        update();
    }

//actualiza el estado (posicion) de las raquetas y pelota
    public void update() {

        p.moverPelota(getBounds(), colision(r1.getBarrita()), colision(r2.getBarrita()));

        r1.moverJ1(getBounds());
        r2.moverJ2(getBounds());
    }

    //detecta si existe una colision entre la raqueta y la pelota
    public boolean colision(Rectangle2D r) {
        return p.getShape().intersects(r);
    }

    public void dibujarPuntaje(Graphics2D g) {
        Graphics2D g1 = g, g2 = g;
        Font score = new Font("Century Gothic", Font.BOLD, 20);
        g.setFont(score);

        g1.drawString("Rondas jugador 1: " + Integer.toString(p.getScore1()), (float) getBounds().getCenterX() - 230, 20);
        g2.drawString("Rondas jugador 2: " + Integer.toString(p.getScore2()), (float) getBounds().getCenterX() + 30, 20);
        if (p.getScore1() == 5) {
            g.drawString("GANÓ EL JUGADOR 1", (float) getBounds().getCenterX() - 100, (float) getBounds().getCenterY() - 90);
            Pelota.finJuego = true;
            FinJuego fj = new FinJuego();
           // cerrar();
        }
        if (p.getScore2() == 5) {
            g.drawString("GANÓ EL JUGADOR 2", (float) getBounds().getCenterX() - 100, (float) getBounds().getCenterY() - 90);
            Pelota.finJuego = true;
            FinJuego fj = new FinJuego();
           // cerrar();
        }

    }

    public void cerrar(){
        
         this.setVisible(false);
    }

}

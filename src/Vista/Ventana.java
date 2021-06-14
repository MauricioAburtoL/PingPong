package Vista;

import Juego.*;
import Juego.Mesa;
import javax.swing.*;

public class Ventana extends JFrame {

    Mesa canvas;
    Pelota p = new Pelota();

    public Ventana() {
        setTitle("Ping Pong");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        canvas = new Mesa();
        add(canvas);

        addKeyListener(new Controles());
        new Repintado(canvas).start();
    }

}

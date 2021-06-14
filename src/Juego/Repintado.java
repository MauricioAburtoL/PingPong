package Juego;
        
public class Repintado extends Thread {

    public final Mesa canvas;
    public static int velocidad;

    public Repintado(Mesa canvas) {
        this.canvas = canvas;
    }

    @Override
    public void run() {
        while (!Pelota.finJuego) {
            canvas.repaint();
            try {
                //Velocidad de la pelota y barras 
                Thread.sleep(velocidad);
            } catch (Exception ex) {
                System.out.println("error in graphics engine: " + ex.getMessage());
            }
        }
    }
}

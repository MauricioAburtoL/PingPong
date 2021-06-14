package Modelo;

public class InfoJugador {

    public int id;
    public String nombre;
    public int triunfos;
    public int rondas;

    public InfoJugador(int id, String nombre, int triunfos, int rondas) {
        this.id = id;
        this.nombre = nombre;
        this.triunfos = triunfos;
        this.rondas = rondas;
    }

    public InfoJugador() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTriunfos() {
        return triunfos;
    }

    public void setTriunfos(int triunfos) {
        this.triunfos = triunfos;
    }

    public int getRondas() {
        return rondas;
    }

    public void setRondas(int rondas) {
        this.rondas = rondas;
    }

}

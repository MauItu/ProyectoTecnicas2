package co.edu.konradlorenz.modelo;

public class Mantenimiento {
    public double afilar(int cantidad) {
        return cantidad * 10;
    }

    public double desmanchar(int cantidad) {
        return cantidad * 15;
    }

    public double alineacion(int cantidad) {
        return cantidad * 20;
    }

    public double correccionPuntas(int cantidad) {
        return cantidad * 12;
    }

    public double perforacion(int cantidad) {
        return cantidad * 25;
    }
}

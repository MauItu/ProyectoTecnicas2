package co.edu.konradlorenz.modelo;

public class Capacitador extends Trabajador {
    public Capacitador(String nombre, String cedula, String codigo) {
        super(nombre, cedula, codigo);
    }

    @Override
    public double calcularComision(double costo) {
        return costo * PorsCapa;
    }
}

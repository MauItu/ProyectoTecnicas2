package co.edu.konradlorenz.modelo;

public class Trabajador extends Persona implements Empleado {
    private String codigo;

    public Trabajador(String nombre, String cedula, String codigo) {
        super(nombre, cedula);
        this.codigo = codigo;
    }

    @Override
    public double calcularComision(double costo) {
        return costo * PorsTrab;
    }

    @Override
    public double quitarImpuesto(double pago) {
        return pago * 0.8;
    }

    public String getCodigo() {
        return codigo;
    }
}

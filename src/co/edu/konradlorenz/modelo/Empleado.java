package co.edu.konradlorenz.modelo;

public interface Empleado {
    double PorsTrab = 0.18;
    double PorsCapa = 0.35; // Corregido el porcentaje para los capacitadores

    double calcularComision(double costo);
    double quitarImpuesto(double pago);
}

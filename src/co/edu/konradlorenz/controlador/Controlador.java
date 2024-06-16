package co.edu.konradlorenz.controlador;

import co.edu.konradlorenz.modelo.*;
import co.edu.konradlorenz.vista.*;

import javax.swing.*;
import java.util.ArrayList;

public class Controlador {
    private ArrayList<Cliente> listaPedidos = new ArrayList<>();
    private ArrayList<Trabajador> listaEmpleados = new ArrayList<>();
    private Cliente pedidoActual;
    private Trabajador empleadoActual;

    public void iniciar() {
        // Inicializar datos de ejemplo
        listaEmpleados.add(new Trabajador("Juan", "1234", "5001"));
        listaEmpleados.add(new Capacitador("Ana", "5678", "9001"));

        SwingUtilities.invokeLater(() -> new Home(this).setVisible(true));
    }

    public void gestionarCliente(Cliente cliente) {
        listaPedidos.add(cliente);
        JOptionPane.showMessageDialog(null, "Pedido registrado exitosamente.");
    }

    public ArrayList<Cliente> getListaPedidos() {
        return listaPedidos;
    }

    public Trabajador loginEmpleado(String codigo, String cedula) {
        for (Trabajador empleado : listaEmpleados) {
            if (empleado.getCodigo().equals(codigo) && empleado.getCedula().equals(cedula)) {
                return empleado;
            }
        }
        return null;
    }

    public double calcularCosto(Cliente cliente) {
        Mantenimiento mantenimiento = new Mantenimiento();
        switch (cliente.getTipoMantenimiento().toLowerCase()) {
            case "afilar":
                return mantenimiento.afilar(cliente.getCantMante());
            case "desmanchar":
                return mantenimiento.desmanchar(cliente.getCantMante());
            case "alineacion":
                return mantenimiento.alineacion(cliente.getCantMante());
            case "correccion puntas":
                return mantenimiento.correccionPuntas(cliente.getCantMante());
            case "perforacion":
                return mantenimiento.perforacion(cliente.getCantMante());
            default:
                return 0;
        }
    }

    public void eliminarPedido(Cliente cliente) {
        listaPedidos.remove(cliente);
    }
}

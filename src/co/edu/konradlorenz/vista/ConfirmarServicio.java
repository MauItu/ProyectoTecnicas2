package co.edu.konradlorenz.vista;

import co.edu.konradlorenz.controlador.Controlador;
import co.edu.konradlorenz.modelo.Cliente;
import co.edu.konradlorenz.modelo.Trabajador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmarServicio extends JFrame {
    private Controlador controlador;
    private Trabajador empleado;
    private Cliente pedido;

    public ConfirmarServicio(Controlador controlador, Trabajador empleado, Cliente pedido) {
        this.controlador = controlador;
        this.empleado = empleado;
        this.pedido = pedido;
        setTitle("Confirmar Servicio");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        panel.setBackground(Color.ORANGE); // Cambio de color a naranja

        panel.add(new JLabel("Está realizando el servicio:"));
        panel.add(new JLabel("Nombre: " + pedido.getNombre()));
        panel.add(new JLabel("Cédula: " + pedido.getCedula()));
        panel.add(new JLabel("Hospital: " + pedido.getNombreHospital()));
        panel.add(new JLabel("Tipo de Mantenimiento: " + pedido.getTipoMantenimiento()));

        JButton btnFinalizar = new JButton("Finalizar Servicio");
        btnFinalizar.setBackground(Color.DARK_GRAY); // Cambio de color a gris oscuro
        btnFinalizar.setForeground(Color.WHITE); // Cambio de color del texto a blanco
        btnFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double costo = controlador.calcularCosto(pedido);
                double comision = empleado.calcularComision(costo);
                controlador.eliminarPedido(pedido);
                JOptionPane.showMessageDialog(null, "Servicio finalizado. Comisión: " + comision);
                new HomeEmpleado(controlador, empleado).setVisible(true);
                dispose();
            }
        });

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBackground(Color.DARK_GRAY); // Cambio de color a gris oscuro
        btnVolver.setForeground(Color.WHITE); // Cambio de color del texto a blanco
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HomeEmpleado(controlador, empleado).setVisible(true);
                dispose();
            }
        });

        panel.add(btnFinalizar);
        panel.add(btnVolver);

        add(panel);
    }
}

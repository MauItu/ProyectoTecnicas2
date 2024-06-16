package co.edu.konradlorenz.vista;

import co.edu.konradlorenz.controlador.Controlador;
import co.edu.konradlorenz.modelo.Cliente;
import co.edu.konradlorenz.modelo.Trabajador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetallePedido extends JFrame {
    private Controlador controlador;
    private Trabajador empleado;
    private Cliente pedido;

    public DetallePedido(Controlador controlador, Trabajador empleado, Cliente pedido) {
        this.controlador = controlador;
        this.empleado = empleado;
        this.pedido = pedido;
        setTitle("Detalle del Pedido");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        panel.setBackground(Color.ORANGE); // Cambio de color a naranja

        panel.add(new JLabel("Nombre: " + pedido.getNombre()));
        panel.add(new JLabel("Cédula: " + pedido.getCedula()));
        panel.add(new JLabel("Hospital: " + pedido.getNombreHospital()));
        panel.add(new JLabel("Dirección: " + pedido.getDireccion()));
        panel.add(new JLabel("Tipo de Mantenimiento: " + pedido.getTipoMantenimiento()));
        panel.add(new JLabel("Cantidad de Implementos: " + pedido.getCantMante()));

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBackground(Color.DARK_GRAY); // Cambio de color a gris oscuro
        btnAceptar.setForeground(Color.WHITE); // Cambio de color del texto a blanco
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConfirmarServicio(controlador, empleado, pedido).setVisible(true);
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

        panel.add(btnAceptar);
        panel.add(btnVolver);

        add(panel);
    }
}

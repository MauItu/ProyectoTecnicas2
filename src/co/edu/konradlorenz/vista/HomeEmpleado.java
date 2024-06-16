package co.edu.konradlorenz.vista;

import co.edu.konradlorenz.controlador.Controlador;
import co.edu.konradlorenz.modelo.Cliente;
import co.edu.konradlorenz.modelo.Trabajador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HomeEmpleado extends JFrame {
    private Controlador controlador;
    private Trabajador empleado;

    public HomeEmpleado(Controlador controlador, Trabajador empleado) {
        this.controlador = controlador;
        this.empleado = empleado;
        setTitle("Home Empleado");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        panel.setBackground(Color.ORANGE); // Cambio de color a naranja

        ArrayList<Cliente> listaPedidos = controlador.getListaPedidos();

        for (Cliente pedido : listaPedidos) {
            JButton btnPedido = new JButton("Pedido de " + pedido.getNombreHospital());
            btnPedido.setBackground(Color.DARK_GRAY); // Cambio de color a gris oscuro
            btnPedido.setForeground(Color.WHITE); // Cambio de color del texto a blanco
            btnPedido.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new DetallePedido(controlador, empleado, pedido).setVisible(true);
                    dispose();
                }
            });
            panel.add(btnPedido);
        }

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBackground(Color.DARK_GRAY); // Cambio de color a gris oscuro
        btnVolver.setForeground(Color.WHITE); // Cambio de color del texto a blanco
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Home(controlador).setVisible(true);
                dispose();
            }
        });

        panel.add(btnVolver);

        add(panel);
    }
}

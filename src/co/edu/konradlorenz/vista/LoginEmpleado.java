package co.edu.konradlorenz.vista;

import co.edu.konradlorenz.controlador.Controlador;
import co.edu.konradlorenz.modelo.Trabajador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginEmpleado extends JFrame {
    private Controlador controlador;

    public LoginEmpleado(Controlador controlador) {
        this.controlador = controlador;
        setTitle("Login Empleado");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.setBackground(Color.ORANGE); // Cambio de color a naranja

        JTextField txtCodigo = new JTextField();
        JTextField txtCedula = new JTextField();

        panel.add(new JLabel("Código:"));
        panel.add(txtCodigo);
        panel.add(new JLabel("Cédula:"));
        panel.add(txtCedula);

        JButton btnIniciarSesion = new JButton("Iniciar Sesión");
        btnIniciarSesion.setBackground(Color.DARK_GRAY); // Cambio de color a gris oscuro
        btnIniciarSesion.setForeground(Color.WHITE); // Cambio de color del texto a blanco
        btnIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = txtCodigo.getText();
                String cedula = txtCedula.getText();
                Trabajador empleado = controlador.loginEmpleado(codigo, cedula);
                if (empleado != null) {
                    new HomeEmpleado(controlador, empleado).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Código o cédula incorrectos.");
                }
            }
        });

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

        panel.add(btnIniciarSesion);
        panel.add(btnVolver);

        add(panel);
    }
}

package co.edu.konradlorenz.vista;

import co.edu.konradlorenz.controlador.Controlador;
import co.edu.konradlorenz.modelo.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pedido extends JFrame {
    private Controlador controlador;

    public Pedido(Controlador controlador) {
        this.controlador = controlador;
        setTitle("Pedido");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2));
        panel.setBackground(Color.ORANGE); // Cambio de color a naranja

        JTextField txtNombre = new JTextField();
        JTextField txtCedula = new JTextField();
        JTextField txtNombreHospital = new JTextField();
        JTextField txtDireccion = new JTextField();
        String[] tiposMantenimiento = {"Afilar", "Desmanchar", "Alineacion", "Correccion Puntas", "Perforacion"};
        JComboBox<String> comboTipoMantenimiento = new JComboBox<>(tiposMantenimiento);
        JTextField txtCantMante = new JTextField();
        JTextField txtTelHospital = new JTextField();

        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Cédula:"));
        panel.add(txtCedula);
        panel.add(new JLabel("Nombre del Hospital:"));
        panel.add(txtNombreHospital);
        panel.add(new JLabel("Dirección:"));
        panel.add(txtDireccion);
        panel.add(new JLabel("Tipo de Mantenimiento:"));
        panel.add(comboTipoMantenimiento);
        panel.add(new JLabel("Cantidad de Implementos:"));
        panel.add(txtCantMante);
        panel.add(new JLabel("Teléfono del Hospital:"));
        panel.add(txtTelHospital);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBackground(Color.DARK_GRAY); // Cambio de color a gris oscuro
        btnAceptar.setForeground(Color.WHITE); // Cambio de color del texto a blanco
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = txtNombre.getText();
                    String cedula = txtCedula.getText();
                    String nombreHospital = txtNombreHospital.getText();
                    String direccion = txtDireccion.getText();
                    String tipoMantenimiento = (String) comboTipoMantenimiento.getSelectedItem();
                    String cantManteStr = txtCantMante.getText();
                    String telHospital = txtTelHospital.getText();

                    if (nombre.isEmpty() || cedula.isEmpty() || nombreHospital.isEmpty() || direccion.isEmpty() || tipoMantenimiento.isEmpty() || cantManteStr.isEmpty() || telHospital.isEmpty()) {
                        throw new IllegalArgumentException("Debe completar todos los campos.");
                    }

                    int cantMante = Integer.parseInt(cantManteStr);

                    if (cantMante <= 0) {
                        throw new IllegalArgumentException("Cantidad de implementos no puede ser cero o un número negativo.");
                    }

                    Cliente cliente = new Cliente(nombre, cedula, nombreHospital, direccion, tipoMantenimiento, cantMante, telHospital);
                    double costo = controlador.calcularCosto(cliente);
                    int respuesta = JOptionPane.showConfirmDialog(null, "Este servicio tendrá un costo de " + costo + " pesos. ¿Está de acuerdo?");
                    if (respuesta == JOptionPane.YES_OPTION) {
                        controlador.gestionarCliente(cliente);
                        new Home(controlador).setVisible(true);
                        dispose();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Formato inválido en número o cantidad.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        panel.add(btnAceptar);
        panel.add(btnVolver);

        add(panel);
    }
}

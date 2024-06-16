package co.edu.konradlorenz.vista;

import co.edu.konradlorenz.controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {
    private Controlador controlador;

    public Home(Controlador controlador) {
        this.controlador = controlador;
        setTitle("Home");
        setSize(1920, 1080); // Tamaño ajustado a 1920x1080
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.ORANGE); // color de fondo
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Bienvenido a Mantenimiento Medico Avanzado");
        label.setBounds(1, 1, 2000, 100);
        label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 70));
        add(label);

        JLabel pregunta = new JLabel("Disponemos de los siguientes servicios");
        pregunta.setBounds(1, 150, 2000, 40);
        pregunta.setFont(new Font(label.getFont().getName(), Font.PLAIN, 50));
        add(pregunta);

        agregarTextoConFondo("Afilado", "<html>El afilado restaura el filo de tus instrumentos quirúrgicos, garantizando cortes precisos y eficientes en cada procedimiento.</html>", 80, 300, 500, 160);
        agregarTextoConFondo("Desmanchado", "<html>El desmanchado elimina manchas y residuos de tus instrumentos quirúrgicos, manteniéndolos limpios y en perfecto estado para su uso.</html>", 600, 300, 500, 160);
        agregarTextoConFondo("Corregir Puntas", "<html>La corrección de puntas mantiene tus instrumentos quirúrgicos afilados y precisos, asegurando su rendimiento óptimo en cada cirugía.</html>", 80, 540, 500, 160);
        agregarTextoConFondo("Perforación", "<html>La perforación de bandejas crea orificios para mejorar la circulación del aire y el drenaje, asegurando una esterilización más efectiva de tus instrumentos quirúrgicos.</html>", 600, 540, 500, 160);
        agregarTextoConFondo("Alineación", "<html>La alineación ajusta tus instrumentos quirúrgicos, asegurando que sus componentes funcionen de manera correcta y precisa durante las operaciones.</html>", 80, 790, 500, 160);

        JButton botonAcceso = new JButton("Acceso");
        botonAcceso.setBounds(1600, 10, 300, 70);
        botonAcceso.setBackground(Color.DARK_GRAY);
        botonAcceso.setForeground(Color.WHITE);
        botonAcceso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameAcceso = new JFrame("Seleccionar Acceso");
                frameAcceso.setSize(400, 200);
                frameAcceso.setLayout(new GridLayout(1, 2));
                frameAcceso.setLocationRelativeTo(null);

                JButton btnCliente = new JButton("Cliente");
                btnCliente.setBackground(Color.DARK_GRAY);
                btnCliente.setForeground(Color.WHITE);
                btnCliente.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Pedido(controlador).setVisible(true);
                        frameAcceso.dispose();
                        dispose();
                    }
                });

                JButton btnEmpleado = new JButton("Empleado");
                btnEmpleado.setBackground(Color.DARK_GRAY);
                btnEmpleado.setForeground(Color.WHITE);
                btnEmpleado.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new LoginEmpleado(controlador).setVisible(true);
                        frameAcceso.dispose();
                        dispose();
                    }
                });

                frameAcceso.add(btnCliente);
                frameAcceso.add(btnEmpleado);

                frameAcceso.setVisible(true);
            }
        });
        add(botonAcceso);

        revalidate();
        repaint();
    }

    private void agregarTextoConFondo(String titulo, String texto, int x, int y, int ancho, int alto) {
        JPanel panel = new JPanel();
        panel.setBounds(x, y, ancho, alto);
        panel.setBackground(Color.WHITE); // Fondo blanco
        panel.setLayout(new BorderLayout());

        JLabel labelTitulo = new JLabel(titulo);
        labelTitulo.setFont(new Font(labelTitulo.getFont().getName(), Font.PLAIN, 25));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel labelTexto = new JLabel(texto);
        labelTexto.setFont(new Font(labelTexto.getFont().getName(), Font.PLAIN, 25));
        labelTexto.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(labelTitulo, BorderLayout.NORTH);
        panel.add(labelTexto, BorderLayout.CENTER);
        add(panel);
    }


}

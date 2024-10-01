import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SimulacinAtencionAlCliente extends JFrame {

    private JTextField cedulaField;
    private JComboBox<String> categoriaComboBox;
    private JComboBox<String> servicioComboBox;
    private JTextField horaLlegadaField;
    private JSlider tiempoAtencionSlider;
    private JLabel tiempoAtencionLabel;
    private DefaultListModel<String> colaModel;
    private JList<String> colaList;
    private JButton registrarButton;
    private JButton guardarButton;
    private File archivoLog;

    public SimulacinAtencionAlCliente() {

        setLayout(new BorderLayout());


        JPanel panelSuperior = new JPanel(new GridLayout(4, 2));
        inicializarCampos(panelSuperior);

        add(panelSuperior, BorderLayout.NORTH);


        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.Y_AXIS));
        inicializarPanelInferior(panelInferior);

        add(panelInferior, BorderLayout.CENTER);

    
        configurarEventos();

    
        inicializarArchivoLog();

    
        configurarVentana();
    }

    private void inicializarCampos(JPanel panelSuperior) {
        cedulaField = new JTextField();
        categoriaComboBox = new JComboBox<>(new String[]{"Adulto Mayor", "Persona con Discapacidad", "Menor de 10 años", "Persona Gestante", "Personal General"});
        servicioComboBox = new JComboBox<>(new String[]{"Consulta Médica General", "Consulta Médica Especializada", "Prueba de Laboratorio", "Cita médica Prioritaria","Odontologia","Pediatria"});
        horaLlegadaField = new JTextField();

        panelSuperior.add(new JLabel("Cédula:"));
        panelSuperior.add(cedulaField);
        panelSuperior.add(new JLabel("Categoría:"));
        panelSuperior.add(categoriaComboBox);
        panelSuperior.add(new JLabel("Servicio Solicitado:"));
        panelSuperior.add(servicioComboBox);
        panelSuperior.add(new JLabel("Hora de Llegada:"));
        panelSuperior.add(horaLlegadaField);
    }
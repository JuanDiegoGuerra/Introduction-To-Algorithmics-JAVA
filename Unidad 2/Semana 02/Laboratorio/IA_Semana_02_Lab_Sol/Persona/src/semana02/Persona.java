package semana02;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Persona extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNombresApellidos;
	private JLabel lblA�oNacimiento;
	private JTextField txtNombresApellidos;
	private JTextField txtA�oNacimiento;
	private JButton btnPocesar;
	private JButton btnBorrar;
	private JScrollPane scp;
	private JTextArea txtS;
	private JLabel lblPesoKilogramos;
	private JTextField txtPesoKilogramos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Persona frame = new Persona();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Persona() {
		setTitle("Persona");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(new Rectangle(100, 100, 450, 285));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNombresApellidos = new JLabel("Nombres y apellidos");
		lblNombresApellidos.setBounds(10, 11, 106, 14);
		contentPane.add(lblNombresApellidos);

		lblA�oNacimiento = new JLabel("A\u00F1o de nacimiento");
		lblA�oNacimiento.setBounds(10, 36, 106, 14);
		contentPane.add(lblA�oNacimiento);

		txtNombresApellidos = new JTextField();
		txtNombresApellidos.setBounds(126, 8, 126, 20);
		contentPane.add(txtNombresApellidos);
		txtNombresApellidos.setColumns(10);

		txtA�oNacimiento = new JTextField();
		txtA�oNacimiento.setBounds(126, 33, 126, 20);
		contentPane.add(txtA�oNacimiento);
		txtA�oNacimiento.setColumns(10);

		btnPocesar = new JButton("Procesar");
		btnPocesar.addActionListener(this);
		btnPocesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnPocesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 32, 89, 23);
		contentPane.add(btnBorrar);

		scp = new JScrollPane();
		scp.setBounds(10, 89, 414, 148);
		contentPane.add(scp);

		txtS = new JTextArea();
		scp.setViewportView(txtS);

		lblPesoKilogramos = new JLabel("Peso en kilogramos");
		lblPesoKilogramos.setBounds(10, 61, 106, 14);
		contentPane.add(lblPesoKilogramos);

		txtPesoKilogramos = new JTextField();
		txtPesoKilogramos.setBounds(126, 58, 126, 20);
		contentPane.add(txtPesoKilogramos);
		txtPesoKilogramos.setColumns(10);
	}

	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(arg0);
		}
		if (arg0.getSource() == btnPocesar) {
			actionPerformedBtnPocesar(arg0);
		}
	}

	// Procesa la pulsaci�n del bot�n Procesar
	protected void actionPerformedBtnPocesar(ActionEvent arg0) {
		// Declaraci�n de variables
		String nomape;
		int a�onac;
		double pesokg;

		// Entrada de datos
		nomape = txtNombresApellidos.getText();
		a�onac = Integer.parseInt(txtA�oNacimiento.getText());
		pesokg = Double.parseDouble(txtPesoKilogramos.getText());

		// Salida de resultados
		txtS.setText("DATOS INGRESADOS" + "\n\n");
		txtS.append ("Nombres y apellidos  : " + nomape + "\n");
		txtS.append ("A�o de nacimiento    : " + a�onac + "\n");
		txtS.append ("Peso en kilogramos   : " + pesokg + "\n");
	}

	// Procesa la pulsaci�n del bot�n Borrar
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtS.setText("");
		txtNombresApellidos.setText("");
		txtA�oNacimiento.setText("");
		txtPesoKilogramos.setText("");
		txtNombresApellidos.requestFocus();
	}
}

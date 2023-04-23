package semana01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Persona extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNombres;
	private JTextField txtNombres;
	private JLabel lblApellidos;
	private JTextField txtApellidos;
	private JLabel lblEdad;
	private JTextField txtEdad;
	private JLabel lblPeso;
	private JTextField txtPeso;
	private JButton btnGuardar;
	private JButton btnNuevo;
	private JButton btnCerrar;

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
		setTitle("Registro de personas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 432, 161);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(10, 11, 46, 14);
		contentPane.add(lblNombres);

		txtNombres = new JTextField();
		txtNombres.setBounds(66, 8, 201, 20);
		contentPane.add(txtNombres);
		txtNombres.setColumns(10);

		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 36, 46, 14);
		contentPane.add(lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setBounds(66, 33, 201, 20);
		contentPane.add(txtApellidos);
		txtApellidos.setColumns(10);

		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 61, 46, 14);
		contentPane.add(lblEdad);

		txtEdad = new JTextField();
		txtEdad.setBounds(66, 58, 89, 20);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);

		lblPeso = new JLabel("Peso");
		lblPeso.setBounds(10, 86, 46, 14);
		contentPane.add(lblPeso);

		txtPeso = new JTextField();
		txtPeso.setBounds(66, 83, 89, 20);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(317, 7, 89, 23);
		contentPane.add(btnGuardar);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(317, 32, 89, 23);
		contentPane.add(btnNuevo);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(317, 57, 89, 23);
		contentPane.add(btnCerrar);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(arg0);
		}
		if (arg0.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(arg0);
		}
	}

	protected void actionPerformedBtnGuardar(ActionEvent arg0) {
	}

	protected void actionPerformedBtnNuevo(ActionEvent arg0) {
	}

	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
	}
}

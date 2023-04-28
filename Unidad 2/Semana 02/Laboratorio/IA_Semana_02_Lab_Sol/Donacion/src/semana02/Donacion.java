package semana02;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Donacion extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblMoneda;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JComboBox<Object> cboMoneda;
	private JButton btnBorrar;
	private JButton btnDonar;
	private JScrollPane scpScroll;
	private JTextArea txtS;

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
					Donacion frame = new Donacion();
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
	public Donacion() {
		setTitle("Donaci\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblMoneda = new JLabel("Moneda");
		lblMoneda.setBounds(10, 11, 46, 14);
		contentPane.add(lblMoneda);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 36, 46, 14);
		contentPane.add(lblCantidad);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(66, 33, 86, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);

		cboMoneda = new JComboBox<Object>();
		cboMoneda.setModel(new DefaultComboBoxModel<Object>(new String[] { "Soles", "D\u00F3lares", "Euros" }));
		cboMoneda.setBounds(66, 8, 86, 20);
		contentPane.add(cboMoneda);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 32, 89, 23);
		contentPane.add(btnBorrar);

		btnDonar = new JButton("Donar");
		btnDonar.addActionListener(this);
		btnDonar.setBounds(335, 7, 89, 23);
		contentPane.add(btnDonar);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 61, 414, 190);
		contentPane.add(scpScroll);

		txtS = new JTextArea();
		scpScroll.setViewportView(txtS);
	}

	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(arg0);
		}
		if (arg0.getSource() == btnDonar) {
			actionPerformedBtnDonar(arg0);
		}
	}

	// Procesa la pulsación del botón Procesar
	protected void actionPerformedBtnDonar(ActionEvent arg0) {
	}

	// Procesa la pulsación del botón Borrar
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
	}
}

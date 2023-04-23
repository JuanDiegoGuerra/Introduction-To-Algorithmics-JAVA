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

public class Producto extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNombre;
	private JTextField textField;
	private JLabel lblMarca;
	private JTextField textField_1;
	private JLabel lblPrecio;
	private JTextField textField_2;
	private JLabel lblStock;
	private JTextField textField_3;
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
					Producto frame = new Producto();
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
	public Producto() {
		setTitle("Registro de productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 172);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 46, 14);
		contentPane.add(lblNombre);

		textField = new JTextField();
		textField.setBounds(66, 8, 180, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 36, 46, 14);
		contentPane.add(lblMarca);

		textField_1 = new JTextField();
		textField_1.setBounds(66, 33, 180, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 61, 46, 14);
		contentPane.add(lblPrecio);

		textField_2 = new JTextField();
		textField_2.setBounds(66, 58, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		lblStock = new JLabel("Stock");
		lblStock.setBounds(10, 86, 46, 14);
		contentPane.add(lblStock);

		textField_3 = new JTextField();
		textField_3.setBounds(66, 83, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(335, 7, 89, 23);
		contentPane.add(btnGuardar);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(335, 32, 89, 23);
		contentPane.add(btnNuevo);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(335, 57, 89, 23);
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

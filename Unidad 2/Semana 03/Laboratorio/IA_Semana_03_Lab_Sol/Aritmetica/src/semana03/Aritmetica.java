package semana03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.Font;

public class Aritmetica extends JFrame implements ActionListener {

	// Declaración de variables
	private static final long serialVersionUID = 9206324162700448001L;
	private JPanel contentPane;
	private JLabel lblNumero1;
	private JLabel lblNumero2;
	private JTextField txtNumero1;
	private JTextField txtNumero2;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scpScroll;
	private JTextArea txtS;

	// Lanza la aplicación
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
					Aritmetica frame = new Aritmetica();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Crea la GUI
	public Aritmetica() {
		setTitle("Aritmetica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNumero1 = new JLabel("N\u00FAmero 1");
		lblNumero1.setBounds(10, 11, 80, 14);
		contentPane.add(lblNumero1);

		lblNumero2 = new JLabel("N\u00FAmero 2");
		lblNumero2.setBounds(10, 36, 80, 14);
		contentPane.add(lblNumero2);

		txtNumero1 = new JTextField();
		txtNumero1.setBounds(100, 8, 100, 20);
		contentPane.add(txtNumero1);
		txtNumero1.setColumns(10);

		txtNumero2 = new JTextField();
		txtNumero2.setBounds(100, 33, 100, 20);
		contentPane.add(txtNumero2);
		txtNumero2.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 32, 89, 23);
		contentPane.add(btnBorrar);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 61, 414, 190);
		contentPane.add(scpScroll);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scpScroll.setViewportView(txtS);
	}

	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(arg0);
		}
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}

	// Procesa la pulsación del botón Borrar
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtNumero1.setText("");
		txtNumero2.setText("");
		txtS.setText("");
		txtNumero1.requestFocus();
	}

	// Procesa la pulsación del botón Procesar
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		// Declaración de variables
		double num1, num2, sum, res, pro, coc;

		// Entrada de datos
		num1 = Double.parseDouble(txtNumero1.getText());
		num2 = Double.parseDouble(txtNumero2.getText());

		// Proceso de cálculo
		sum = num1 + num2;
		res = num1 - num2;
		pro = num1 * num2;
		coc = num1 / num2;

		// Salida de resultados
		txtS.setText("Suma     : " + sum + "\n");
		txtS.append ("Resta    : " + res + "\n");
		txtS.append ("Producto : " + pro + "\n");
		txtS.append ("Cociente : " + coc);
	}
}
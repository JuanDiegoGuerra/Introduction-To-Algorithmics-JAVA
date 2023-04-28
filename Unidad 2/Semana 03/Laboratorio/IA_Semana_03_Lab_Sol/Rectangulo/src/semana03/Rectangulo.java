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

public class Rectangulo extends JFrame implements ActionListener {

	// Declaración de variables
	private static final long serialVersionUID = 9206324162700448001L;
	private JPanel contentPane;
	private JLabel lblBase;
	private JLabel lblAltura;
	private JTextField txtBase;
	private JTextField txtAltura;
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
					Rectangulo frame = new Rectangulo();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Crea la GUI
	public Rectangulo() {
		setTitle("Rectangulo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblBase = new JLabel("Base");
		lblBase.setBounds(10, 11, 80, 14);
		contentPane.add(lblBase);

		lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 36, 80, 14);
		contentPane.add(lblAltura);

		txtBase = new JTextField();
		txtBase.setBounds(100, 8, 100, 20);
		contentPane.add(txtBase);
		txtBase.setColumns(10);

		txtAltura = new JTextField();
		txtAltura.setBounds(100, 33, 100, 20);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);

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
		txtBase.setText("");
		txtAltura.setText("");
		txtS.setText("");
		txtBase.requestFocus();
	}

	// Procesa la pulsación del botón Procesar
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		// Declaración de variables
		double b, h, are, per;

		// Entrada de datos
		b = Double.parseDouble(txtBase.getText());
		h = Double.parseDouble(txtAltura.getText());

		// Proceso de cálculo
		are = b * h;
		per = 2 * (b + h);

		// Salida de resultados
		txtS.setText("PROPIEDADES GEOMÉTRICAS DEL RECTÁNGULO\n\n");
		txtS.append ("Area      : " + are + "\n");
		txtS.append ("Perímetro : " + per);
	}
}
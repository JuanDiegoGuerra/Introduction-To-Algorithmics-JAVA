package semana05;

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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;

public class Mochila extends JFrame implements ActionListener {

	// Declaración de variables
	private static final long serialVersionUID = 9206324162700448001L;
	private JPanel contentPane;
	private JLabel lblModelo;
	private JLabel lblCantidad;
	private JComboBox<String> cboModelo;
	private JTextField txtCantidad;
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
					Mochila frame = new Mochila();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Crea la GUI
	public Mochila() {
		setTitle("Tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 224);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 11, 65, 14);
		contentPane.add(lblModelo);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 36, 65, 14);
		contentPane.add(lblCantidad);

		cboModelo = new JComboBox<String>();
		cboModelo.setModel(new DefaultComboBoxModel<String>(new String[] {"Sherman", "Faguo", "Aldo", "Suburban"}));
		cboModelo.setBounds(85, 8, 100, 20);
		contentPane.add(cboModelo);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(85, 33, 100, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 32, 89, 23);
		contentPane.add(btnBorrar);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 61, 414, 114);
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
		txtCantidad.setText("");
		txtS.setText("");
		cboModelo.setSelectedIndex(0);
		txtCantidad.requestFocus();
	}

	// Procesa la pulsación del botón Procesar
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		// Declaración de variables
		int mod, can, cho;
		double icom, ides, ipag;

		// Entrada de datos
		mod = cboModelo.getSelectedIndex();
		can = Integer.parseInt(txtCantidad.getText());

		// Cálculo del importe compra
		if (mod == 0)
			icom = 149.9 * can;
		else if (mod == 1)
			icom = 89.9 * can;
		else if (mod == 2)
			icom = 119.9 * can;
		else
			icom = 174.9 * can;

		// Cálculo del importe del descuento
		if (can < 5)
			ides = 0;
		else if(can < 10)
			ides = 0.05*icom;
		else if(can < 20)
			ides = 0.07*icom;
		else
			ides = 0.09*icom;
		
		// Cálculo del importe a pagar
		ipag = icom - ides;

		// Cálculo de los lapiceros de regalo
		if (ipag  < 2000)
			cho = 0;
		else if(ipag < 500)
			cho = 1 *can;
		else if(ipag < 700)
			cho = 2 * can;
		else
			cho = 3 * can;
		
		// Salida de resultados
		txtS.setText("Importe compra    : S/. " + icom + "\n");
		txtS.append ("Importe descuento : S/. " + ides + "\n");
		txtS.append ("Importe pagar     : S/. " + ipag + "\n");
		txtS.append ("Chocolates        : " + cho);
	}
}
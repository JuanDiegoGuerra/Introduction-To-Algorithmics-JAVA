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

public class Hospital extends JFrame implements ActionListener {

	// Declaraci�n de variables
	private static final long serialVersionUID = 9206324162700448001L;
	private JPanel contentPane;
	private JLabel lblDonacionSoles;
	private JTextField txtDonacionSoles;
	private JButton btnProcesar;
	private JScrollPane scpScroll;
	private JTextArea txtS;
	private JButton btnBorrar;

	// Lanza la aplicaci�n
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
					Hospital frame = new Hospital();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Crea la GUI
	public Hospital() {
		setTitle("Hospital");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblDonacionSoles = new JLabel("Donaci\u00F3n (S/.)");
		lblDonacionSoles.setBounds(10, 11, 80, 14);
		contentPane.add(lblDonacionSoles);

		txtDonacionSoles = new JTextField();
		txtDonacionSoles.setBounds(100, 8, 100, 20);
		contentPane.add(txtDonacionSoles);
		txtDonacionSoles.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 38, 414, 213);
		contentPane.add(scpScroll);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scpScroll.setViewportView(txtS);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(236, 7, 89, 23);
		contentPane.add(btnBorrar);
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

	// Procesa la pulsaci�n del bot�n Borrar
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtDonacionSoles.setText("");
		txtS.setText("");
		txtDonacionSoles.requestFocus();
	}

	// Procesa la pulsaci�n del bot�n Procesar
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		// Declaraci�n de variables
		double don, mgen, pedi, trau, neum, gine;

		// Entrada de datos
		don = Double.parseDouble(txtDonacionSoles.getText());

		// Proceso de c�lculo
		mgen = 0.17 * don;
		pedi = 0.35 * don;
		trau = 0.23 * don;
		neum = 0.15 * don;
		gine = don - (mgen + pedi + trau + neum);

		// Salida de resultados
		txtS.setText("REPARTO DE LA DONACI�N\n\n");
		txtS.append ("Medicina General : S/. " + mgen + "\n");
		txtS.append ("Pediatr�a        : S/. " + pedi + "\n");
		txtS.append ("Traumatolog�a    : S/. " + trau + "\n");
		txtS.append ("Neumolog�a       : S/. " + neum + "\n");
		txtS.append ("Ginecolog�a      : S/. " + gine);
	}
}
package semana13;

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

public class Empresa extends JFrame implements ActionListener {

	// Declaración de variables
	private static final long serialVersionUID = 9206324162700448001L;
	private JPanel contentPane;
	private JLabel lblVersion;
	private JLabel lblCantidad;
	private JComboBox<String> cboVersion;
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
					Empresa frame = new Empresa();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Crea la GUI
	public Empresa() {
		setTitle("Empresa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 409);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblVersion = new JLabel("Version");
		lblVersion.setBounds(10, 11, 80, 14);
		contentPane.add(lblVersion);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 36, 80, 14);
		contentPane.add(lblCantidad);

		cboVersion = new JComboBox<String>();
		cboVersion.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Estudiante", "Profesional", "Empresarial" }));
		cboVersion.setBounds(100, 8, 100, 20);
		contentPane.add(cboVersion);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(100, 33, 100, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(429, 7, 89, 23);
		contentPane.add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(429, 32, 89, 23);
		contentPane.add(btnBorrar);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 61, 508, 299);
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
		cboVersion.setSelectedIndex(0);
		txtCantidad.requestFocus();
	}

	// Procesa la pulsación del botón Procesar
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
mostrarResultados();

	}

	void imprimir(String cad) {
		txtS.append(cad + "\n");
	}

	void mostrarResultados() {
		txtS.setText("");
		imprimir("Importe a pagar................................................: ");
		imprimir("Cantidad total de ventas de la versión Estudiante..............: ");
		imprimir("Cantidad total de ventas de la versión Profesional.............: ");
		imprimir("Cantidad total de ventas de la versión Empresarial.............: ");
		imprimir("Cantidad total de licencias vendidas de la versión Estudiante..: ");
		imprimir("Cantidad total de licencias vendidas de la versión Profesional.: ");
		imprimir("Cantidad total de licencias vendidas de la versión Empresarial.: ");
		imprimir("Importe total pagado de la versión Estudiante..................: ");
		imprimir("Importe total pagado de la versión Profesional.................: ");
		imprimir("Importe total pagado de la versión Empresarial.................: ");
		imprimir("Mayor cantidad total de ventas.................................: ");
		imprimir("Mayor cantidad total de licencias vendidas.....................: ");
		imprimir("Cantidad de versiones sin ventas...............................: ");
	}

}
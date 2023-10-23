package semana12;

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

public class Peaje extends JFrame implements ActionListener {

	// Declaración de variables
	private static final long serialVersionUID = 9206324162700448001L;
	private JPanel contentPane;
	private JLabel lblTipoVehiculo;
	private JLabel lblCantidadPasajeros;
	private JComboBox<String> cboTipoVehiculo;
	private JTextField txtCantidadPasajeros;
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
					Peaje frame = new Peaje();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Crea la GUI
	public Peaje() {
		setTitle("Peaje");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 269);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTipoVehiculo = new JLabel("Tipo de veh\u00EDculo");
		lblTipoVehiculo.setBounds(10, 11, 127, 14);
		contentPane.add(lblTipoVehiculo);

		lblCantidadPasajeros = new JLabel("Cantidad de pasajeros");
		lblCantidadPasajeros.setBounds(10, 36, 127, 14);
		contentPane.add(lblCantidadPasajeros);

		cboTipoVehiculo = new JComboBox<String>();
		cboTipoVehiculo.setModel(new DefaultComboBoxModel<String>(new String[] {"Omnibus", "Minivan", "Autom\u00F3vil"}));
		cboTipoVehiculo.setBounds(147, 8, 147, 20);
		contentPane.add(cboTipoVehiculo);

		txtCantidadPasajeros = new JTextField();
		txtCantidadPasajeros.setBounds(147, 33, 147, 20);
		contentPane.add(txtCantidadPasajeros);
		txtCantidadPasajeros.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(380, 7, 89, 23);
		contentPane.add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(380, 32, 89, 23);
		contentPane.add(btnBorrar);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 61, 459, 159);
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
		txtCantidadPasajeros.setText("");
		cboTipoVehiculo.setSelectedIndex(0);
		txtCantidadPasajeros.requestFocus();
	}

	void imprimir(String cad) {
		txtS.append(cad + "\n");
	}

	
	// Procesa la pulsación del botón Procesar
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {

	}
	int getMoneda() {
		return cboTipoVehiculo.getSelectedIndex();
	}
	int getCantidad() {
		return Integer.parseInt(txtCantidadPasajeros.getText());
	}
	
	
	void mostrarResultados() {
		txtS.setText("");
		imprimir("Cantidad de omnibuses                    : ");
		imprimir("Cantidad total de pasajeros en omnibus   : ");
		imprimir("Cantidad de minivanes                    : ");
		imprimir("Cantidad total de pasajeros en minivan   : ");
		imprimir("Cantidad de automóviles                  : ");
		imprimir("Cantidad total de pasajeros en automóvil : ");
	}
}
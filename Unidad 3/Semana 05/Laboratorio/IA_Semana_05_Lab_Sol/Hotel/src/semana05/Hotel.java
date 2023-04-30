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

public class Hotel extends JFrame implements ActionListener {

	// Declaración de variables
	private static final long serialVersionUID = 9206324162700448001L;
	private JPanel contentPane;
	private JLabel lblTipoHabitacion;
	private JLabel lblCantidadDias;
	private JComboBox<String> cboTipoHabitacion;
	private JTextField txtCantidadDias;
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
					Hotel frame = new Hotel();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Crea la GUI
	public Hotel() {
		setTitle("Hotel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTipoHabitacion = new JLabel("Tipo de habitaci\u00F3n");
		lblTipoHabitacion.setBounds(10, 11, 87, 14);
		contentPane.add(lblTipoHabitacion);

		lblCantidadDias = new JLabel("Cantidad de d\u00EDas");
		lblCantidadDias.setBounds(10, 36, 80, 14);
		contentPane.add(lblCantidadDias);

		cboTipoHabitacion = new JComboBox<String>();
		cboTipoHabitacion.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Simple", "Matrimonial", "Doble", "Triple" }));
		cboTipoHabitacion.setBounds(107, 8, 100, 20);
		contentPane.add(cboTipoHabitacion);

		txtCantidadDias = new JTextField();
		txtCantidadDias.setBounds(107, 33, 100, 20);
		contentPane.add(txtCantidadDias);
		txtCantidadDias.setColumns(10);

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
		txtCantidadDias.setText("");
		txtS.setText("");
		cboTipoHabitacion.setSelectedIndex(0);
		txtCantidadDias.requestFocus();
	}

	// Procesa la pulsación del botón Procesar
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		// Declaración de variables
		int tipohab, candi, canlap = 0;
		double isub = 0, ides = 0, itot;

		// Entrada de datos
		tipohab = cboTipoHabitacion.getSelectedIndex();
		candi = Integer.parseInt(txtCantidadDias.getText());

		// Cálculo del importe subtotal
		if(tipohab == 0)
			isub = 80.0 * candi;
		if(tipohab == 1)
			isub = 130.0 * candi;
		if(tipohab == 2)
			isub = 140.0 * candi;
		if(tipohab == 3)
			isub = 180.0 * candi;

		// Cálculo del importe del descuento
		if (candi >= 12)
			ides = 0.075 * isub;
		if (candi >= 6 && candi < 12)
			ides = 0.05 * isub;
		if (candi >= 3 && candi < 6)
			ides = 0.025 * candi;
		if(candi < 3)
			ides = 0;

		// Cálculo del importe total a pagar
		itot = isub - ides;

		// Cálculo de los lapiceros de obsequio
		if (itot < 100)
			canlap = 2 * candi;
		if (itot >= 100 && itot < 150)
			canlap = 3 * candi;
		if(itot >= 150)
			canlap = 4 * candi;

		// Salida de resultados
		txtS.setText("Importe subtotal   : " + isub + "\n");
		txtS.append ("Importe descuento  : " + ides + "\n");
		txtS.append ("Importe total      : " + itot + "\n");
		txtS.append ("Lapiceros          : " + canlap);
	}
}
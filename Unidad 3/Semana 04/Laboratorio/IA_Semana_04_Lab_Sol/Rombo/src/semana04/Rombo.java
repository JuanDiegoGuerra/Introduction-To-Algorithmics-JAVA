package semana04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Rombo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblDiagonalMayor;
	private JTextField txtDiagonalMayor;
	private JLabel lblDiagonalMenor;
	private JTextField txtDiagonalMenor;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scpScroll;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rombo frame = new Rombo();
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
	public Rombo() {
		setTitle("Rombo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblDiagonalMayor = new JLabel("Diagonal mayor");
		lblDiagonalMayor.setBounds(10, 11, 89, 14);
		contentPane.add(lblDiagonalMayor);

		txtDiagonalMayor = new JTextField();
		txtDiagonalMayor.setBounds(109, 8, 86, 20);
		contentPane.add(txtDiagonalMayor);
		txtDiagonalMayor.setColumns(10);

		lblDiagonalMenor = new JLabel("Diagonal menor");
		lblDiagonalMenor.setBounds(10, 36, 89, 14);
		contentPane.add(lblDiagonalMenor);

		txtDiagonalMenor = new JTextField();
		txtDiagonalMenor.setBounds(109, 33, 86, 20);
		contentPane.add(txtDiagonalMenor);
		txtDiagonalMenor.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 32, 89, 23);
		contentPane.add(btnBorrar);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 64, 414, 117);
		contentPane.add(scpScroll);

		txtS = new JTextArea();
		scpScroll.setViewportView(txtS);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(arg0);
		}
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}

	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		// Declaración de variables
		double diagmay, diagmen, area;

		// Entrada de datos
		diagmay = Double.parseDouble(txtDiagonalMayor.getText());
		diagmen = Double.parseDouble(txtDiagonalMenor.getText());

		// Proceso de cálculo
		area = (diagmay * diagmen) / 2;

		// Salida de resultados
		txtS.setText("Área : " + area + "\n");
	}

	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtDiagonalMayor.setText("");
		txtDiagonalMenor.setText("");
		txtS.setText("");
		txtDiagonalMayor.requestFocus();
	}
}

package semana06;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Principal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnuArchivo;
	private JMenuItem mnuSalir;
	private JMenu mnMantenimiento;
	private JMenuItem mntmConsultar;
	private JMenu mnAyuda;
	private JMenuItem mntmAcercaDeTienda;
	private JMenuItem mntmListar;
	
	public static String codigo0 = "c001"; 
	public static String codigo1 = "c002"; 
	public static String codigo2 = "c003"; 
	public static String titulo0 = "Como Programar en Java";
	public static String titulo1 = "Aplique SQL";
	public static String titulo2 = "Metodología de la Programación";
	public static String autor0 = "Deitel & Deitel";
	public static String autor1 = "James R Groft";
	public static String autor2 = "Osvaldo Cairo";
	public static double precio0 = 150;
	public static double precio1 = 85;
	public static double precio2 = 120;

	
	
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
					Principal frame = new Principal();
					frame.setLocationRelativeTo(null);
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
	public Principal() {
		setTitle("Tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 401);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnuArchivo = new JMenu("Archivo");
		menuBar.add(mnuArchivo);

		mnuSalir = new JMenuItem("Salir");
		mnuSalir.addActionListener(this);
		mnuArchivo.add(mnuSalir);

		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);

		mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.addActionListener(this);
		mnMantenimiento.add(mntmConsultar);

		mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(this);
		mnMantenimiento.add(mntmListar);

		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);

		mntmAcercaDeTienda = new JMenuItem("Acerca de Tienda");
		mntmAcercaDeTienda.addActionListener(this);
		mnAyuda.add(mntmAcercaDeTienda);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmListar) {
			actionPerformedMntmListar(arg0);
		}
		if (arg0.getSource() == mntmAcercaDeTienda) {
			actionPerformedMntmAcercaDeTienda(arg0);
		}
		if (arg0.getSource() == mntmConsultar) {
			actionPerformedMntmConsultar(arg0);
		}
		if (arg0.getSource() == mnuSalir) {
			actionPerformedMnuSalir(arg0);
		}
	}

	protected void actionPerformedMnuSalir(ActionEvent arg0) {
		System.exit(0);
	}

	protected void actionPerformedMntmConsultar(ActionEvent arg0) {
		DialogoConsultar d = new DialogoConsultar();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}

	protected void actionPerformedMntmAcercaDeTienda(ActionEvent arg0) {
		DialogoAcercaDeTienda d = new DialogoAcercaDeTienda();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}

	protected void actionPerformedMntmListar(ActionEvent arg0) {
		DialogoListar d = new DialogoListar();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
}
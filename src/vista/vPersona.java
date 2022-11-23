package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.daoPersona;
import dao.daoUsuario;
import modelo.Persona;
import modelo.Usuario;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;

public class vPersona extends JFrame {

	private JPanel contentPane;
	private JTextField txtApellidoP;
	private JTextField txtApellidoM;
	private JTextField txtEdad;
	private JLabel lblId;
	private JTextField txtNombre;
	daoPersona dao = new daoPersona();
	DefaultTableModel modelo = new DefaultTableModel();
	ArrayList<Persona> lista = new ArrayList<Persona>();
	Persona persona;
	int fila = -1;
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnBorrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vPersona frame = new vPersona();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public vPersona() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(vPersona.class.getResource("/img/jyujyu.png")));
		setTitle("CRUD PERSONAL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(23, 33, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(23, 72, 108, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellidoPaterno = new JLabel("APELLIDO PATERNO");
		lblApellidoPaterno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblApellidoPaterno.setBounds(23, 111, 255, 14);
		contentPane.add(lblApellidoPaterno);
		
		JLabel lblApellidoMaterno = new JLabel("APELLIDO MATERNO");
		lblApellidoMaterno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblApellidoMaterno.setBounds(23, 153, 255, 14);
		contentPane.add(lblApellidoMaterno);
		
		JLabel lblEdad = new JLabel("EDAD");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEdad.setBounds(23, 196, 58, 14);
		contentPane.add(lblEdad);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(203, 71, 185, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellidoP = new JTextField();
		txtApellidoP.setBounds(203, 110, 185, 20);
		contentPane.add(txtApellidoP);
		txtApellidoP.setColumns(10);
		
		txtApellidoM = new JTextField();
		txtApellidoM.setBounds(204, 152, 184, 20);
		contentPane.add(txtApellidoM);
		txtApellidoM.setColumns(10);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(203, 195, 185, 20);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);
		
		lblId = new JLabel("1");
		lblId.setBounds(203, 35, 46, 14);
		contentPane.add(lblId);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 236, 566, 171);
		contentPane.add(scrollPane);
		
		JTable tblPersonas = new JTable();
		tblPersonas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		tblPersonas.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(tblPersonas);
		
		
		
		btnAgregar = new JButton("AGREGAR");
		btnAgregar.setBounds(23, 440, 89, 23);
		contentPane.add(btnAgregar);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.setBounds(152, 440, 89, 23);
		contentPane.add(btnEditar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(274, 440, 89, 23);
		contentPane.add(btnEliminar);
		
		btnBorrar = new JButton("BORRAR");
		btnBorrar.setBounds(418, 440, 89, 23);
		contentPane.add(btnBorrar);
		
		
	}
}

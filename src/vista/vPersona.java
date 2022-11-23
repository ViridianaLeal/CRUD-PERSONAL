package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.daoPersona;

import modelo.Persona;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.PublicKey;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vPersona extends JFrame {

	private JPanel contentPane;
	private JTextField txtApellidoP;
	private JTextField txtApellidoM;
	private JTextField txtEdad;
	private JLabel lblId;
	private JTextField txtNombre;
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JTable tblPersonas;
	daoPersona dao = new daoPersona();
	DefaultTableModel modelo = new DefaultTableModel();
	ArrayList<Persona> lista = new ArrayList<Persona>();
	Persona persona;
	int fila = -1;

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

	public void limpiar() {
		lblId.setText("");
		txtNombre.setText("");
		txtApellidoP.setText("");
		txtApellidoM.setText("");
		txtEdad.setText("");
	}

	public vPersona() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(vPersona.class.getResource("/img/jyujyu.png")));
		setTitle("CRUD PERSONAL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 473);
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

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtNombre.getText().equals("") || txtApellidoP.getText().equals("")
							|| txtApellidoM.getText().equals("") || txtEdad.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "CAMPOS VACIOS ");
						return;
					}
					Persona user = new Persona();
					user.setNombre(txtNombre.getText());
					user.setApellidopaterno(txtApellidoP.getText());
					user.setApellidomaterno(txtApellidoM.getText());
					user.setEdad(Integer.parseInt(txtEdad.getText().toString()));
					if (dao.insertarPersona(user)) {
						actualizarTabla();
						limpiar();
						JOptionPane.showMessageDialog(null, "SE AGREGO CORRECTAMENTE");
					} else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "ERROR");
				}
			}
		});
		btnAgregar.setBounds(455, 51, 89, 23);
		contentPane.add(btnAgregar);

		btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtNombre.getText().equals("") || txtApellidoP.getText().equals("")
							|| txtApellidoM.getText().equals("") || txtEdad.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "CAMPOS VACIOS ");
						return;
					}
					persona.setNombre(txtNombre.getText());
					persona.setApellidopaterno(txtApellidoP.getText());
					persona.setApellidomaterno(txtApellidoM.getText());
					persona.setEdad(Integer.parseInt(txtEdad.getText().toString()));
					if (dao.editarPersona(persona)) {
						actualizarTabla();
						limpiar();
						JOptionPane.showMessageDialog(null, "SE ACTUALIZO  CORRECTAMENTE");
					} else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR");
				}
			}
		});
		btnEditar.setBounds(455, 109, 89, 23);
		contentPane.add(btnEditar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					int opcion = JOptionPane.showConfirmDialog(null, "¿ESTA SEGURO DE ELIMINAR A ESTA PERSONA?",
							"ELIMINAR PERSONA", JOptionPane.YES_NO_OPTION);
					if (opcion == 0) {
						if (dao.EliminarPersona(lista.get(fila).getId())) {
							actualizarTabla();
							limpiar();
							JOptionPane.showMessageDialog(null, "SE ELIMINO CORRECTAMENTE");
						} else {
							JOptionPane.showMessageDialog(null, "ERROR");
						}
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "ERROR");
				}
			}
		});
		btnEliminar.setBounds(455, 164, 89, 23);
		contentPane.add(btnEliminar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 236, 566, 171);
		contentPane.add(scrollPane);

		tblPersonas = new JTable();
		tblPersonas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila = tblPersonas.getSelectedRow();
				fila = tblPersonas.getSelectedRow();
				persona = lista.get(fila);
				lblId.setText("" + lista.get(fila).getId());
				txtNombre.setText(persona.getNombre());
				txtApellidoP.setText(persona.getApellidopaterno());
				txtApellidoM.setText(persona.getApellidomaterno());
				txtEdad.setText("" + persona.getEdad());

			}
		});
		tblPersonas.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, },
				new String[] { "New column", "New column", "New column", "New column", "New column" }));
		scrollPane.setViewportView(tblPersonas);
		modelo.addColumn("ID");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("APELLIDO PATERNO");
		modelo.addColumn("APELLIDO MATERNO");
		modelo.addColumn("EDAD");
		tblPersonas.setModel(modelo);
		actualizarTabla();

	}

	public void actualizarTabla() {
		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}
		lista = dao.fetchPersonas();
		for (Persona u : lista) {
			Object o[] = new Object[5];
			o[0] = u.getId();
			o[1] = u.getNombre();
			o[2] = u.getApellidopaterno();
			o[3] = u.getApellidomaterno();
			o[4] = u.getEdad();
			modelo.addRow(o);
		}
		tblPersonas.setModel(modelo);
	}

}

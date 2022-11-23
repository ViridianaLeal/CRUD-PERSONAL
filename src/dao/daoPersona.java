package dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexión.conexion;
import modelo.Persona;



public class daoPersona {
	conexion cx=null;
	public daoPersona() {
		cx = new Conexión.conexion();
	}

	public boolean insertarPersona(Persona user) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("INSERT INTO persona VALUES(null,?,?,?,?)");
			ps.setString(1, user.getNombre());
			ps.setString(2, user.getApellidopaterno());
			ps.setString(3, user.getApellidomaterno());
			ps.setInt(4, user.getEdad());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public ArrayList<Persona> fetchPersonas() {
		ArrayList<Persona> lista = new ArrayList<Persona>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = cx.conectar().prepareStatement("SELECT * FROM persona");
			rs = ps.executeQuery();
			while (rs.next()) {
				Persona u = new Persona();
				u.setId(rs.getInt("id"));
				u.setNombre(rs.getString("nombre"));
				u.setApellidopaterno(rs.getString("apellidopaterno"));
				u.setApellidomaterno(rs.getString("apellidomaterno"));
				u.setEdad(rs.getInt("edad"));
				lista.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	
	public boolean EliminarUsuario(int Id) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("DELETE FROM usuario WHERE id=?");
			ps.setInt(1, Id);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean editarUsuario(Persona user) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("UPDATE persona SET nombre=?,apellidopaterno=?,apellidopaterno=?,edad=? WHERE id=?");
			ps.setInt(1, user.getId());
			ps.setString(2,user.getNombre());
			ps.setString(3,user.getApellidopaterno() );
			ps.setString(4,user.getApellidomaterno());
			ps.setInt(5, user.getEdad());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	
}

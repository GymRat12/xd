package com.cibertec.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conectar {

	private static String driver = "com.mysql.jdbc.Driver";
	private static String database = "dbcursos";
	private static String host = "localhost";
	private static String port = "3306";
	private static String url = "jdbc:mysql://"+host+":"+port+"/"+database+"?characterEncoding=latin1";
	private static String user = "cibertec";
	private static String password = "davalossanchez";
	
	public Connection conectarMySQL() {
		Connection conexion = null;
		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conexion;
	}
	
}

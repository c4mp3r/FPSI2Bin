package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CNXHSQLDB {
	
	private String usuario = "SA";
	private String senha = "";
	private String PathBase = "C:\\Users\\Public\\Documents\\Eclipse x64 Portable\\Data\\workspace\\FPSI\\base\\cadastro";
	private String URL = "jdbc:hsqldb:file:" + PathBase + ";";

	public Connection conectar() {
		try {
			return DriverManager.getConnection(URL, usuario, senha);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}

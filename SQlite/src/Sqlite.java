import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sqlite {
	
	private static Connection conn = null;
	private static final String dbName = "C:\\Users\\Chelsea\\Documents\\Databases\\celtek";
	
	public Sqlite() {
		
	}
	
	public static Connection connect() throws SQLException, ClassNotFoundException {
		
		Class.forName("org.sqlite.JDBC");
		
		conn = DriverManager.getConnection("jdbc:sqlite:" + dbName);
		
		return conn;
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Connection exec = connect();
	}

}

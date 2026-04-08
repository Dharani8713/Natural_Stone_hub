package emailBreach;

import java.sql.*;

public class DBConnection {

	private Connection con;

	public DBConnection(String user, String password) throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.cj.jdbc.Driver"); // load driver
			this.con = DriverManager.getConnection(
				    "jdbc:mysql://localhost:3306/practice?allowPublicKeyRetrieval=true&useSSL=false",
				    "root",
				    "db@87$"
				);

		}

	public boolean isEmailLeaked(String email) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement("SELECT COUNT(*) FROM leakedEmails WHERE email = ?");
		pstmt.setString(1, email);
		ResultSet rs = pstmt.executeQuery();
		return rs.next() && rs.getInt(1) > 0;
	}

	// Admin-only insert
	public void insertLeakedEmail(String email) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO leakedEmails (email) VALUES (?)");
		pstmt.setString(1, email);
		pstmt.executeUpdate();
	}

	public void close() throws SQLException {
		if (con != null)
			con.close();
	}

}

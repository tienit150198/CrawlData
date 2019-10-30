import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class Connect {
	static Map<String, String> config;
	private static String dbURL;
	private static String server;
	private static String host;
	private static String database;
	private static String userName;
	private static String Password;
	private static String forName;

	public Connect() {
		init();
	}

	static Connection conn = null;

	// connect SQL
	public static Connection getConnection() {
		try {
			Class.forName(forName);
			conn = DriverManager.getConnection(dbURL, userName, Password);

		} catch (ClassNotFoundException e) {
			System.err.println("connection failure NotFound!");
		} catch (SQLException e) {
			System.err.println("connection failure SQL!");
		}
		return conn;
	}

	private static void init() {
		
		config = Config.getConfig();
		server = config.get("server").trim();
		host = config.get("host").trim();
		database = config.get("database").trim();
		userName = config.get("userName").trim();
		Password = config.get("password").trim();
		forName = config.get("forName").trim();
		dbURL = server + "://" + host + "; " + "databaseName = " + database;
	}

	public void Insert(Date timePost, String uRL, String title, String author, String description, String content,
			String type, String infoImage, String tags) {
		try {
			CallableStatement cstm = conn.prepareCall("{CALL DT_Add(?, ?, ?, ?, ?, ?, ?, ?, ?)};");

			System.err.println("url = " + uRL + " --> timepost = " + timePost);

			cstm.setString(1, uRL);
			cstm.setString(2, title);
			cstm.setString(3, type);
			cstm.setDate(4, timePost);
			cstm.setString(5, description);
			cstm.setString(6, content);
			cstm.setString(7, tags);
			cstm.setString(8, author);
			cstm.setString(9, infoImage);

			cstm.executeUpdate();

		} catch (SQLException e) {
			System.err.println("add data failure!");
			System.err.println(e.getMessage());
		}
	}
	
	public void getData(String sql) {
		CallableStatement cstm = null;
		ResultSet res = null;
		try {
			System.err.println(sql);
			conn = Connect.getConnection();
			cstm = conn.prepareCall(sql);
			cstm.setInt(1, 10);
			
			cstm.executeQuery();
			
			res = cstm.getResultSet();
			while(res.next())
				System.out.println(res.getString(1));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
//		return res;
	}
}

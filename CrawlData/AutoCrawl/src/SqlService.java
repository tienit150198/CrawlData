import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlService {
	Connect connect = new Connect();
	Connection connection = null;
	
	public ResultSet getDataFromId(int id) {
		String sql = "{call DT_Get_AllFromId(?)}";
		
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			connection = Connect.getConnection();
			cstm = connection.prepareCall(sql);
			cstm.setInt(1, id);
			
			cstm.executeQuery();
			
			rs = cstm.getResultSet();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return rs;
	}
	public ResultSet getDataFromUrl(String url) {
		String sql = "{call DT_Get_AllFromUrl(?)}";
		
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			connection = Connect.getConnection();
			cstm = connection.prepareCall(sql);
			cstm.setString(1, url);
			
			cstm.executeQuery();
			
			rs = cstm.getResultSet();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return rs;
	}
	
	/*------------------- start get in day ------------------*/
	public ResultSet getIdAndUrlAndTag_inday() {
		String sql = "{call DT_Get_IdAndUrlAndTag_inday}";
		
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			connection = Connect.getConnection();
			cstm = connection.prepareCall(sql);

			cstm.executeQuery();
			
			rs = cstm.getResultSet();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet getUrlAndTag_inday() {
		String sql = "{call DT_Get_UrlAndTag_inday}";
		
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			connection = Connect.getConnection();
			cstm = connection.prepareCall(sql);

			cstm.executeQuery();
			
			rs = cstm.getResultSet();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet getIdAndTag_inday() {
		String sql = "{call DT_Get_IdAndTag_inday}";
		
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			connection = Connect.getConnection();
			cstm = connection.prepareCall(sql);

			cstm.executeQuery();
			
			rs = cstm.getResultSet();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet getUrlAndId_inday() {
		String sql = "{call DT_Get_UrlAndId_inday}";
		
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			connection = Connect.getConnection();
			cstm = connection.prepareCall(sql);

			cstm.executeQuery();
			
			rs = cstm.getResultSet();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	/* ----------- end get in day ----------------*/
	
	/*------------------- start get in week ------------------*/
	public ResultSet getIdAndUrlAndTag_inweek() {
		String sql = "{call DT_Get_IdAndUrlAndTag_inweek}";
		
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			connection = Connect.getConnection();
			cstm = connection.prepareCall(sql);

			cstm.executeQuery();
			
			rs = cstm.getResultSet();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet getUrlAndTag_inweek() {
		String sql = "{call DT_Get_UrlAndTag_inweek}";
		
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			connection = Connect.getConnection();
			cstm = connection.prepareCall(sql);

			cstm.executeQuery();
			
			rs = cstm.getResultSet();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet getIdAndTag_inweek() {
		String sql = "{call DT_Get_IdAndTag_inweek}";
		
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			connection = Connect.getConnection();
			cstm = connection.prepareCall(sql);

			cstm.executeQuery();
			
			rs = cstm.getResultSet();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet getUrlAndId_inweek() {
		String sql = "{call DT_Get_UrlAndId_inweek}";
		
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			connection = Connect.getConnection();
			cstm = connection.prepareCall(sql);

			cstm.executeQuery();
			
			rs = cstm.getResultSet();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	/* ----------- end get in week ----------------*/
	
	/*------------------- start get in month ------------------*/
	public ResultSet getIdAndUrlAndTag_inmonth() {
		String sql = "{call DT_Get_IdAndUrlAndTag_inmonth}";
		
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			connection = Connect.getConnection();
			cstm = connection.prepareCall(sql);

			cstm.executeQuery();
			
			rs = cstm.getResultSet();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet getUrlAndTag_inmonth() {
		String sql = "{call DT_Get_UrlAndTag_inmonth}";
		
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			connection = Connect.getConnection();
			cstm = connection.prepareCall(sql);

			cstm.executeQuery();
			
			rs = cstm.getResultSet();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet getIdAndTag_inmonth() {
		String sql = "{call DT_Get_IdAndTag_inmonth}";
		
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			connection = Connect.getConnection();
			cstm = connection.prepareCall(sql);

			cstm.executeQuery();
			
			rs = cstm.getResultSet();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet getUrlAndId_inmonth() {
		String sql = "{call DT_Get_UrlAndId_inmonth}";
		
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			connection = Connect.getConnection();
			cstm = connection.prepareCall(sql);

			cstm.executeQuery();
			
			rs = cstm.getResultSet();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	/* ----------- end get in month ----------------*/
	
}

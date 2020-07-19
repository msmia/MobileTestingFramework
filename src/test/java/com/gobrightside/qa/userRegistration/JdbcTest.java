package com.gobrightside.qa.userRegistration;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.testng.annotations.Test;
import com.gobrightside.qa.util.SqlConnection;

public class JdbcTest {

	boolean tf = true;

	@Test
	public void t() {

		SqlConnection j = new SqlConnection();
		String guid = "a3052aca-f227-45ff-b415-983ed9aaccc2";
		ResultSet rs = j.getResultSet("select username FROM comcast.client_registration where guid = '" + guid + "'");

		try {
			while (rs.next()) {
				System.out.println(rs.getInt("username"));
			}
		} catch (SQLException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public void delete_card_savings_workflow(SqlConnection sql, ResultSet rs, String query) {
		sql = new SqlConnection();
		rs = sql.getResultSet(query);
	}

}

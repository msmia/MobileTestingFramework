package com.gobrightside.qa.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gobrightside.qa.models.TestUsers;
import com.gobrightside.qa.testbase.TestBase;

public class SqlConnection {

	private String connectionStirng;
	private Connection sqlConnection;
	private Statement statement;
	private ResultSet resultSet;

	private String[] a = System.getProperty("user.name").split("\\.");
	private String un = a[0];
	private String pwd = "H3@1thyD011@r2018";

	/**
	 * ResultSet This is the only method that needs to be run to get sql result
	 * 
	 * @param query
	 * @return
	 */
	public ResultSet getResultSet(String query) {
		try {
			sqlConnection = getConnectedSql();
			statement = getSqlStatement(sqlConnection);
			resultSet = statement.executeQuery(query);
		} catch (SQLException | NullPointerException e) {
			System.out.println("Unable to get resultset: " + e.getMessage());
		}

		return resultSet;
	}

	/**
	 * Execute this query only to update something
	 * @param query
	 */
	public void updateUserInfo(TestUsers[] testUsers, int i, String guid) {
		try {
			sqlConnection = getConnectedSql();
			statement = getSqlStatement(sqlConnection);
			
			String query = "UPDATE comcast.client_info " + "SET " + "mailing_address1 = '"
					+ testUsers[i].getAddress().getMailingAddress1() + "', " + "mailing_city = '"
					+ testUsers[i].getAddress().getMailingCity() + "', " + "mailing_state = '"
					+ testUsers[i].getAddress().getMailingState() + "', " + "mailing_zip_code = '"
					+ testUsers[i].getAddress().getMailingZip() + "' " + "WHERE guid = '" + guid + "'";

			statement.executeUpdate(query);
		} catch (SQLException | NullPointerException e) {
			System.out.println("Unable to get resultset: " + e.getMessage());
		}
	}

	/**
	 * Activate the SQL connection
	 * 
	 * @return
	 */
	private Connection getConnectedSql() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			sqlConnection = DriverManager.getConnection(getConnectionStirng(), un, pwd);
		} catch (NullPointerException | ClassNotFoundException | SQLException e) {
			System.out.println("Unable to initiate the sql connection: " + e.getMessage());
		}
		return sqlConnection;
	}

	/**
	 * Connection String
	 * 
	 * @return
	 */
	private String getConnectionStirng() {
		String env = TestBase.prop.getProperty("test_environment");

		if (env.equals("dev")) {
			connectionStirng = "jdbc:mysql://dev-rds-b-rdscluster-4855031mxc06.cluster-c9k5is3q24bg.us-west-2.rds.amazonaws.com?zeroDateTimeBehavior=convertToNull";
		} else if(env.equals("stage")){
			connectionStirng = "jdbc:mysql://stage-rds-c-rdscluster-7jmmfw0v4b83.cluster-c9k5is3q24bg.us-west-2.rds.amazonaws.com?zeroDateTimeBehavior=convertToNull";
		} else {
			throw new NullPointerException("Invalid environment: " + env);
		}
		return connectionStirng;
	}

	/**
	 * Statement
	 * 
	 * @param sqlConnection
	 * @return
	 */
	private Statement getSqlStatement(Connection sqlConnection) {
		try {
			statement = sqlConnection.createStatement();
		} catch (SQLException | NullPointerException e) {
			System.out.println("Unable to create sql statement: " + e.getMessage());
		}
		return statement;
	}

	/**
	 * Delete query method: this method will delete a user's client_card table row,
	 * workflow table row, savingsaccount table row.
	 * 
	 * @param sql
	 * @param rs
	 * @param query
	 */
	public void deleteClient_card_savings_workflow(SqlConnection sql, ResultSet rs, String query) {
		rs = sql.getResultSet(query);
	}

	/**
	 * This method checks if the user has a username field value in the
	 * comcast.client_registration table. false = the user is not setup with a phone
	 * number. true = the user is setup with a phone number.
	 * 
	 * @param rs
	 * @return
	 */
	public boolean isUserActive(ResultSet rs) {
		String nNull;
		boolean isUserActive = true;
		try {
			while (rs.next()) {
				nNull = rs.getObject("username") != null ? rs.getString("username") : "null";
				if (nNull == "null") {
					isUserActive = false;
				}
			}
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}

		return isUserActive;

	}

}

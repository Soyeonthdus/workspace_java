package com.util;

	import java.io.*;
	import java.sql.*;
	import java.util.Properties;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class JDBCTemplate {
		
		public JDBCTemplate() {
		}
		
		public static Connection getConnection() {
			private static OracleDBConnector orclDbc = new OracleDBConnector();	
			private static OracleDBConnector orclDbc;
			
			try {
				JDBCTemplate.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@ ...;
				Connection conn = DriverManager.getConnection("student", "student");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return con;
		}

		public static void close(Connection con) {
			try {
				if (con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public static void close(Statement stmt) {
			try {
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public static void close(ResultSet rset) {
			try {
				if (rset != null && !rset.isClosed()) {
					rset.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public static void commit(Connection con) {
		 try {
		 if (con != null && !con.isClosed()) { con.commit(); } 
		} catch (SQLException e) { e.printStackTrace(); }
		 }

		public static void rollback(Connection con) {
			try {
				if (con != null && !con.isClosed()) {
					con.rollback();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public static void main(String args[]) {
			Connection con = getConnection();
			System.out.println(con);
		}
	}


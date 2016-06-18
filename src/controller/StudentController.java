package controller;

import java.sql.Connection;
import java.util.Vector;

import javax.naming.spi.DirStateFactory.Result;

import connection.DBConnection;
import model.Student;

public class StudentController {
	
	private DBConnection DBConn;
	private Connection conn; 
	
	
	public StudentController() throws Exception{
		DBConn = new DBConnection();
	}
	

}

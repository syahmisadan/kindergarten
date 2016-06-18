package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import connection.DBConnection;
import model.Result;
import model.Student;

public class ResultController {
	private int totalMark = 0;
	private double percentage = 0.0;
	private String comment;
	private DBConnection DBConn;
	private Connection conn; 
	
	public ResultController() throws Exception{
		DBConn = new DBConnection();
	}
	
	
	
	public Vector<Student> getStudentClassA() throws Exception{		
		Vector<Student> Students = new Vector<Student>();
		
		String sql = "SELECT * FROM student, result WHERE classroomID ='C1'";
		conn = DBConn.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs;
		
		try{
			rs = ps.executeQuery();
			while(rs.next()){
				Student theStudent = new Student();
				theStudent.setStudentID(rs.getString("studentID"));
				theStudent.setClassroomID(rs.getString("classroomID"));
				theStudent.setStudentName("studentName");
				Students.add(theStudent);
			}
		}catch(Exception e1){
			e1.printStackTrace();
		}
		return Students;
	}
	
	public Result getResultStudentBM(Student student){
		Result resultBM = new Result();
		
		String sql = "SELECT * FROM result  WHERE studentID = ? AND subjectID = 'BM'";	
		ResultSet rs;
		
		try{
			conn = DBConn.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, student.getStudentID());
			rs = ps.executeQuery();
			while(rs.next()){
				resultBM.setMarkBm(rs.getInt("subjectMark"));
			}
		}catch(Exception e1){
			e1.printStackTrace();
		}
		return resultBM;
	}
	
	
	
	public int calculateTotalMark(int markBi, int markBm, int markArt, int markMath){
		totalMark = markBm + markBi + markArt + markMath;
		return totalMark;
		
	}
	
	public double calculatePercentage(){
		percentage = (totalMark / 400) * 100;
		return percentage;
		
	}
	
	public String displayComment(){
		return comment;
		
	}

}

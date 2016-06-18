package model;

import java.util.Vector;

public class Student {
	
	private String studentName;
	private String classroomID;
	private String studentID;
	private Vector<Result> Result;

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public String getStudentID(){
		return studentID;
	}
	public String getClassroomID(){
		return classroomID;
	}
	
	public void setStudentID(String studentID){
		this.studentID = studentID;
	}
	public void setClassroomID(String classroomID){
		this.classroomID = classroomID;
	}
	public Vector<Result> getResult(){
		return Result;
	}
	
	public void setResult(Vector<Result> Result){
		this.Result = Result;
	}
	
	

}

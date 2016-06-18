package model;

public class Result {
	
	private int markBm = 0;
	private int markBi = 0;
	private int markArt = 0;
	private int markMath = 0;
	private char grade;
	

	public int getMarkBm() {
		return markBm;
	}

	public void setMarkBm(int markBm) {
		this.markBm = markBm;
	}

	public int getMarkBi() {
		return markBi;
	}

	public void setMarkBi(int markBi) {
		this.markBi = markBi;
	}

	public int getMarkArt() {
		return markArt;
	}

	public void setMarkArt(int markArt) {
		this.markArt = markArt;
	}

	/**
	 * @return the markMath
	 */
	public int getMarkMath() {
		return markMath;
	}

	/**
	 * @param markMath the markMath to set
	 */
	public void setMarkMath(int markMath) {
		this.markMath = markMath;
	}

	/**
	 * @return the grade
	 */
	public char getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(char grade) {
		this.grade = grade;
	}

	

}

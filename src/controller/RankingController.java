package controller;

import java.sql.Connection;

import connection.DBConnection;

public class RankingController {
	
	private int ranking = 0;
	private DBConnection DBConn;
	private Connection conn; 
	
	public int calculateRanking(){
		return ranking;
	}

}

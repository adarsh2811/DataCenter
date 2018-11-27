package com.ucc.dc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ucc.dc.models.Server;

public class ServerDao {
	
	DBManager dbManager = new DBManager();
	Connection connection = dbManager.getConnection();
	
	public List<Server> getServers(){
		
		ArrayList<Server> serverList = new ArrayList<>();
		
		String query = "select id, utilization, capacity, taskscompleted, stack_id from server";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				int util = resultSet.getInt(2);
				int capacity = resultSet.getInt(3);
				int completed = resultSet.getInt(4);
				int stack_id = resultSet.getInt(5);
				
				Server server = new Server(util, capacity, id, completed, stack_id);
				
				serverList.add(server);
				
			}
			for(int i = 0; i<serverList.size() ; i++) {
				
				System.out.println("this is the server "+i+" list: "+serverList.get(i).toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;
	}

}
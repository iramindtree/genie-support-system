package com.mindtree.ira.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.mindtree.ira.model.ServiceRequest;

@ManagedBean(name = "iraDao")
@ApplicationScoped
public class IRADAO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Statement getConnection() throws SQLException {
		Connection conn = DBUtil.getDBConnection();
		Statement stmt = conn.createStatement();
		return stmt;
	}
	
	private List<ServiceRequest> getServiceRequests(String departmentId) {
		List<ServiceRequest> serviceRequests = new ArrayList<ServiceRequest>();
		String query = "SELECT SERVICE_REQUEST_ID, ROOM_NO, REQUEST_DESC, REQUEST_STATUS FROM SERVICE_REQUEST WHERE DEPARTMENT_ID = "+ departmentId +" ORDER BY EXECUTION_TIME DESC";
		Statement stmt = null;
		try {
			stmt = getConnection();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String requestId = rs.getString("SERVICE_REQUEST_ID");
				String roomNo = rs.getString("ROOM_NO");
				String requestDesc = rs.getString("REQUEST_DESC");
				String status = rs.getString("REQUEST_STATUS");

				serviceRequests.add(new ServiceRequest(requestId,roomNo,requestDesc,status));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return serviceRequests;
	}
	
	public List<ServiceRequest> createRetailServiceRequests() {
		return getServiceRequests("POS");
	}
	
	public List<ServiceRequest> createKitchenServiceRequests() {
		return getServiceRequests("KOT");
	}
}

package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.CustomerVo;

public class CustomerDAO {
	
	private Connection conn;

	public CustomerDAO(String driverClass, String url, String username, String userpw) {
		try {
			Class.forName(driverClass);
			System.out.println("driver 연결 성공");
			
			conn = DriverManager.getConnection(url, username, userpw);
			System.out.println(username+" 연결 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println(driverClass+"에 맞는 클래스가 없습니다.");
		} catch (SQLException e) {
			System.out.println(url+"에 접속 실패, url과 id, pw 점검하세요.");
		}
	}
	
	public void connectionClosed() {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<CustomerVo> getAllCustomerList() {
		List<CustomerVo> customerList = new ArrayList<CustomerVo>();
		
		String sql = "SELECT * FROM CUSTOMER ORDER BY ID";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String email = rs.getString("email");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				Date entryDate = rs.getDate("entry_date");
				
				CustomerVo customer = new CustomerVo(id, email, name, age, entryDate);
				customerList.add(customer);
			}
			
		} catch (SQLException e) {
			System.out.println("조회에 오류가 발생했습니다");
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
		return customerList;
	}
	
}

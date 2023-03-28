package sec01.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class MemberDAO {

	private PreparedStatement pstmt;
	private Connection con;
	
	public List<MemberVO> listMembers(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
		 connDB();
		 String query = "select * from t_member ";
		 System.out.println("preparedStatement: " + query);
		 pstmt = con.prepareStatement(query);
		 ResultSet rs = pstmt.executeQuery();
		 
		 while (rs.next()){
			String id = rs.getString("id");
			String pwd = rs.getString("pwd");
			String name = rs.getString("name");
			String email = rs.getString("email");
			Date joinDate = rs.getDate("joinDate");
			
			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setName(Name);
			vo.setJoinDate(joinDate);
			list.add(vo);
		 }
		 rs.close();
		 pstmt.close();
		 con.close();
		} catch (Exception e) {
		  e.printStackTrace();
		}
		return list;
	}

	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 생성 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

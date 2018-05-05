package junit.test;

import java.sql.SQLException;

import com.ctgu.qmx.bean.User;
import com.ctgu.qmx.daoimpl.UserDaoImpl;
import com.ctgu.qmx.utils.DBUtils;
import com.ctgu.qmx.utils.ImgSave;
public class Test {
	@org.junit.Test
	public void DBUtils() throws SQLException{
		System.out.println(DBUtils.getCon());
	}
	
	@org.junit.Test
	public void insertUser(){
		
	}
	@org.junit.Test
	public void getPath(){
		System.out.println(ImgSave.getRandomString());
		System.out.println(this.getClass().getResource("/").getPath());
	}
	@org.junit.Test
	public void addUser(){
		User user = new User();
		user.setUsername("201611223221");
		user.setPassword("2016112231");
		user.setName("fantasy");
//		user.setPhone("15871577021");
		user.setAge(12);
		user.setAddress("ctgu");
		user.setSex("男");
		new UserDaoImpl().doInsert(user);
	}
}

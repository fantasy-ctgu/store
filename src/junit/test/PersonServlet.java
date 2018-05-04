package junit.test;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ctgu.qmx.bean.User;

@WebServlet("/persons.do")
public class PersonServlet extends HttpServlet {

    private static final long serialVersionUID = -800352785988546254L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// 判断上传表单是否为multipart/form-data类型
	Touxiang tx=null;
	
	HttpSession session = request.getSession();
	User user = (User) session.getAttribute("user"); // 在登录时将 User 对象放入了 会话
	if(user!=null){
	    int myid=user.getId();
	    String SQL="SELECT id,image_path,old_name FROM t_touxiang WHERE user_id=?";
	    ResultSet rs=JdbcHelper.query(SQL,myid);
	    String uSQL="SELECT username,password FROM t_user WHERE id=?";
	    ResultSet urs=JdbcHelper.query(uSQL,myid);
	    System.out.println( "我的个人id是: " + myid);
	    final List<Touxiang> touxiang=new ArrayList<>();
	    try {
		if(rs.next())
		{
		    tx=new Touxiang();
		    tx.setId(rs.getInt(1));
		    tx.setImage_path(rs.getString(2));
		    tx.setOld_name(rs.getString(3));
		    touxiang.add(tx);
		}
		if(urs.next()){
		    user.setUsername(urs.getString(1));
		    user.setPassword(urs.getString(2));
		    user.setTouxiang(touxiang);
		}
		
	    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	   
		session.setAttribute("user", user);
		System.out.println( "我的id: " + myid);
		response.sendRedirect( request.getContextPath() + "/person.html");
	}
    }
}

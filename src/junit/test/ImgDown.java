package junit.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImgDown extends HttpServlet {

	private static final long serialVersionUID = -800352785988546254L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "storeImg/1525140035082.jpg";
		request.setAttribute("path", path);
		request.getRequestDispatcher("imgshow.jsp").forward(request, response);;
	}
}
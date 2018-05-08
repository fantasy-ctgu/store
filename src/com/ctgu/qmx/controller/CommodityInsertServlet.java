package com.ctgu.qmx.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import com.ctgu.qmx.bean.Commodity;
import com.ctgu.qmx.bean.User;
import com.ctgu.qmx.service.CommodityService;
import com.ctgu.qmx.utils.ImgSave;

public class CommodityInsertServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getServletContext().getRealPath("/") ;
		if(ServletFileUpload.isMultipartContent(req)){
			CommodityService commodityService = new CommodityService();
			Commodity commodity = new Commodity();
			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("user");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
			try {
				List<FileItem> fileItemList = servletFileUpload.parseRequest(new ServletRequestContext(req));
				Iterator<FileItem> fileItems = fileItemList.iterator();
				while(fileItems.hasNext()){
					FileItem fileItem = fileItems.next();
					if(fileItem.isFormField()){
						String name = fileItem.getFieldName();
						String value = fileItem.getString("utf-8");
						if(name.equals("commodity_name")){
							commodity.setCommodity_name(value);
						}else if (name.equals("commodity_type")) {
							commodity.setCommodity_type(Integer.parseInt(value));
						}else if (name.equals("commodity_content")) {
							commodity.setCommodity_content(value);
						}else if (name.equals("commodity_money")) {
							commodity.setCommodity_money(value);
						}else if (name.equals("commodity_school")) {
							commodity.setCommodity_school(Integer.parseInt(value));
						}
					}
					else {
						String path = ImgSave.SaveImg(fileItem,uri.substring(0, uri.indexOf(".")));
						commodity.setImg(path);
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			commodity.setUsername(user.getUsername());
			commodityService.commodityInsert(commodity);
			resp.sendRedirect("index.jsp");
		}
	}

}

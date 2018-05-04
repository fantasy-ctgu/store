package com.ctgu.qmx.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import com.ctgu.qmx.bean.Commodity;
import com.ctgu.qmx.utils.ImgSave;

public class CommodityInsertServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(req)){
			Commodity commodity = new Commodity();
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
						}else if (name.equals("username")) {
							commodity.setUsername(value);
						}else if (name.equals("commodity_type")) {
							commodity.setCommodity_type(Integer.parseInt(value));
						}else if (name.equals("commodity_content")) {
							commodity.setCommodity_content(value);
						}else if (name.equals("commodity_money")) {
							commodity.setCommodity_money(value);
						}
					}
					else {
						String path = ImgSave.SaveImg(fileItem);
						commodity.setImg(path);
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			resp.sendRedirect("");
		}
	}

}
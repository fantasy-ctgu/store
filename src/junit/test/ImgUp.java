package junit.test;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import com.ctgu.qmx.bean.User;

public class ImgUp extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		System.out.println(System.getProperty("catalina.home"));
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				// 1. 创建DiskFileItemFactory对象，设置缓冲区大小和临时文件目录
				DiskFileItemFactory factory = new DiskFileItemFactory();
				// System.out.println(System.getProperty("java.io.tmpdir"));//默认临时文件夹

				// 2. 创建ServletFileUpload对象，并设置上传文件的大小限制。
				ServletFileUpload sfu = new ServletFileUpload(factory);
				sfu.setSizeMax(1024 * 1024);// 以byte为单位 不能超过10M 1024byte =
				// 1kb 1024kb=1M 1024M = 1G
				sfu.setHeaderEncoding("utf-8");

				// 3.
				// 调用ServletFileUpload.parseRequest方法解析request对象，得到一个保存了所有上传内容的List对象。
				@SuppressWarnings("unchecked")
				List<FileItem> fileItemList = sfu.parseRequest(new ServletRequestContext(request));
				Iterator<FileItem> fileItems = fileItemList.iterator();

				// 4. 遍历list，每迭代一个FileItem对象，调用其isFormField方法判断是否是上传文件
				while (fileItems.hasNext()) {
					FileItem fileItem = fileItems.next();
					// 普通表单元素
					if (fileItem.isFormField()) {
						String name = fileItem.getFieldName();// name属性值
						String value = fileItem.getString("utf-8");// name对应的value值
						if(name.equals("username")){
							user.setUsername(value);
						}
						else if (name.equals("password")) {
							user.setPassword(value);
						}
						System.out.println(name + " = " + value);
					}
					// <input type="file">的上传文件的元素
					else {
						String path = saveImg(fileItem);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
			}
		}

	}

	public String saveImg(FileItem fileItem) throws Exception {
		String fileName = fileItem.getName();// 文件名称
		System.out.println("原文件名：" + fileName);// Koala.jpg

		String suffix = fileName.substring(fileName.lastIndexOf('.'));
		System.out.println("扩展名：" + suffix);// .jpg

		// 新文件名（唯一）
		String newFileName = new Date().getTime() + suffix;
		System.out.println("新文件名：" + newFileName);// image\1478509873038.jpg

		// 5. 调用FileItem的write()方法，写入文件
		File file = new File(System.getProperty("catalina.home") + "/webapps/storeImg/" + newFileName);
		System.out.println(file.getAbsolutePath());
		fileItem.write(file);

		// 6. 调用FileItem的delete()方法，删除临时文件
		fileItem.delete();
		return null;

	}

}

package cn.wss.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/uploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public UploadServlet() {
		super();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//1.����һ��ʹ����
		//		InputStream in = request.getInputStream();
		//		Reader reader = new InputStreamReader(in);
		//		BufferedReader bf = new BufferedReader(reader);
		//		String str = null;
		//		while((str=bf.readLine())!=null){
		//			System.out.println(str);
		//		}
		//-----------------------------------------------------

		//2.��������ʹ��common-upload���
		// 2.1. �õ� FileItem �ļ��� items
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

//		FileCleaningTracker fileCleaningTracker = 
//				FileCleanerCleanup.getFileCleaningTracker(getServletContext());
//		factory.setFileCleaningTracker(fileCleaningTracker);

		// Set factory constraints
		factory.setSizeThreshold(1024 * 500);
		File tempDirectory = new File("d:\\temp");
		factory.setRepository(tempDirectory);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Set overall request size constraint
		upload.setSizeMax(1024 * 1024 * 5);//5M

		// Parse the request
		try {
			List<FileItem> /* FileItem */items = upload.parseRequest(request);

			// 2.2. ���� items:
			for (FileItem item : items) {
				// ����һ��һ��ı���, ��ӡ��Ϣ
				if (item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString();

					System.out.println(name + ": " + value);


				}
				// �����ļ�������ļ����浽 d:\\files Ŀ¼��.
				else {
					String fieldName = item.getFieldName();//����
					String fileName = item.getName();//�ļ���
					String contentType = item.getContentType();
					long sizeInBytes = item.getSize();
					
					int index=fileName.lastIndexOf("\\");
					if(index!=-1) {
						fileName=fileName.substring(index+1);
					}

					System.out.println(fieldName);
					System.out.println(fileName);
					System.out.println(contentType);
					System.out.println(sizeInBytes);

					InputStream in = item.getInputStream();
					byte[] buffer = new byte[1024];
					int len = 0;

					fileName = "d:\\files\\" + fileName;
					System.out.println(fileName);

					OutputStream out = new FileOutputStream(fileName);

					while ((len = in.read(buffer)) != -1) {
						out.write(buffer, 0, len);
					}

					out.close();
					in.close();
				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}

	}

}

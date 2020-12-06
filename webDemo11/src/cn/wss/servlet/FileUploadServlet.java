package cn.wss.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import cn.wss.bean.FileUploadBean;
import cn.wss.db.UploadFileDao;
import cn.wss.exception.InvalidExtNameException;
import cn.wss.util.FileUploadAppProperties;
import cn.wss.util.FileUtils;

@WebServlet("/fileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
private static final String FILE_PATH = "d:\\files";
	
	private static final String TEMP_DIR = "d:\\temp";
	
	private UploadFileDao dao = new UploadFileDao();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String path = null;
		
		//��ȡ ServletFileUpload ����. 
		ServletFileUpload upload = getServletFileUpload();
		
		try {
			
			//����Ҫ�ϴ��� FileItem �����뵽�� Map ��
			//��: �ļ��Ĵ���ŵ�·��, ֵ: ��Ӧ�� FileItem ����
			Map<String, FileItem> uploadFiles = new HashMap<String, FileItem>();
			
			//��������, �õ� FileItem �ļ���.
			List<FileItem> items = upload.parseRequest(request);
			
			//1. ���� FileUploadBean �ļ���, ͬʱ��� uploadFiles
			List<FileUploadBean> beans = buildFileUploadBeans(items, uploadFiles);
			
			//2. У����չ��:
			vaidateExtName(beans);

			//3. У���ļ��Ĵ�С: �ڽ���ʱ, �Ѿ�У����, ����ֻ��Ҫͨ���쳣�õ����. 
			
			//4. �����ļ����ϴ�����.
			upload(uploadFiles);
			
			//5. ���ϴ�����Ϣ���浽���ݿ���
			saveBeans(beans);
			
			//6. ɾ����ʱ�ļ��е���ʱ�ļ�
			FileUtils.delAllFile(TEMP_DIR);
			
			path = "/app/success.jsp";
			
		} catch (Exception e) {
			e.printStackTrace();
			path = "/app/upload.jsp";
			request.setAttribute("message", e.getMessage());
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	private void saveBeans(List<FileUploadBean> beans) {
		dao.save(beans); 
	}

	/**
	 * �ļ��ϴ�ǰ��׼������. �õ� filePath �� InputStream
	 * @param uploadFiles
	 * @throws IOException
	 */
	private void upload(Map<String, FileItem> uploadFiles) throws IOException {
		for(Map.Entry<String, FileItem> uploadFile: uploadFiles.entrySet()){
			String filePath = uploadFile.getKey();
			FileItem item = uploadFile.getValue();
			
			upload(filePath, item.getInputStream());
		}
	}

	/**
	 * �ļ��ϴ��� IO ����.
	 * 
	 * @param filePath
	 * @param inputStream
	 * @throws IOException
	 */
	private void upload(String filePath, InputStream inputStream) throws IOException {
		OutputStream out = new FileOutputStream(filePath);
		
		byte [] buffer = new byte[1024];
		int len = 0;
		
		while((len = inputStream.read(buffer)) != -1){
			out.write(buffer, 0, len);
		}
		
		inputStream.close();
		out.close();
		
		System.out.println(filePath); 
	}

	/**
	 * У����չ���Ƿ�Ϸ�
	 * @param beans: 
	 */
	private void vaidateExtName(List<FileUploadBean> beans) {
		String exts = FileUploadAppProperties.getInstance().getProperty("exts");
		List<String> extList = Arrays.asList(exts.split(","));
		System.out.println(extList);
		
		for(FileUploadBean bean: beans){
			String fileName = bean.getFileName();
			System.out.println(fileName.indexOf(".")); 
			
			String extName = fileName.substring(fileName.lastIndexOf(".") + 1);
			System.out.println(extName); 
			
			if(!extList.contains(extName)){
				throw new InvalidExtNameException(fileName + "�ļ�����չ�����Ϸ�");
			}
		}
	}

	/**
	 * ���ô���� FileItem �ļ���, ���� FileUploadBean �ļ���, ͬʱ��� uploadFiles
	 * 
	 * FileUploadBean �����װ��: id, fileName, filePath, fileDesc
	 * uploadFiles: Map<String, FileItem> ����, ����ļ������͵�  FileItem. ��: ��������ļ������� ,ֵ: FileItem ����
	 * 
	 * ��������:
	 * 1. �Դ��� FileItem �ļ��Ͻ��б���. �õ� desc ���Ǹ� Map. ��: desc �� fieldName(desc1, desc2 ...). 
	 * ֵ: desc ���Ǹ�������ı�ֵ
	 * 
	 * 2. �Դ��� FileItem �ļ��Ͻ��б���. �õ��ļ������Щ FileItem ����, ������Ӧ�� key (desc1 ....) ����ȡ�� desc.
	 * ������ FileUploadBean ����, ����� beans �� uploadFiles
	 * 
	 * @param items
	 * @param uploadFiles
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	private List<FileUploadBean> buildFileUploadBeans(List<FileItem> items, Map<String, FileItem> uploadFiles) throws UnsupportedEncodingException {
		List<FileUploadBean> beans = new ArrayList<>();
		
		Map<String, String> descs = new HashMap<>();
		
		for(int i = 0; i < items.size(); i++){
			FileItem item = items.get(i);
			
			if(item.isFormField()){
				//desc1 �� desc2 ...
				String fieldName = item.getFieldName();
				String desc = item.getString("UTF-8");
				
				descs.put(fieldName, desc);
			}
		}
		
		for(int i = 0; i < items.size(); i++){
			FileItem item = items.get(i);
			FileUploadBean bean = null;
			if(!item.isFormField()){
				String fieldName = item.getFieldName();
				String descName = "desc" + fieldName.substring(fieldName.length() - 1);
				String desc = descs.get(descName); 
				
				//��Ӧ�ļ���
				String fileName = item.getName();
//				int index=fileName.lastIndexOf("\\");
//				if(index!=-1) {
//					fileName=fileName.substring(index+1);
//				}
				
				String filePath = getFilePath(fileName);
				
				bean = new FileUploadBean(fileName, filePath, desc);
				beans.add(bean);
				uploadFiles.put(bean.getFilePath(), item);
			}			
		}
		
		return beans;
	}

	/**
	 * ���ݸ������ļ�������һ��������ļ���
	 * 1. �������ļ����ļ�������չ���͸������ļ�����չ��һ��
	 * 2. ���� ServletContext �� getRealPath ������ȡ�ľ���·��
	 * 3. ������ Random �� ��ǰ��ϵͳʱ�乹��������ļ�������
	 * 
	 * @param fileName
	 * @return
	 */
	private String getFilePath(String fileName) {
		String extName = fileName.substring(fileName.lastIndexOf("."));
		Random random = new Random();//����ļ���
		
		String filePath = getServletContext().getRealPath(FILE_PATH) + "\\" + System.currentTimeMillis() + random.nextInt(100000) + extName;
		return filePath;//�ϴ���ľ���·������ /WEB-INF/files/�ϴ��ļ���.ppt
	}

	/**
	 * ���� ServletFileUpload ����
	 * �������ļ��ж�ȡ�˲�������, �û�����Լ��. 
	 * �÷���������Դ���ĵ�. 
	 * @return
	 */
	private ServletFileUpload getServletFileUpload() {
		String fileMaxSize = FileUploadAppProperties.getInstance().getProperty("file.max.size");
		String totalFileMaxSize = FileUploadAppProperties.getInstance().getProperty("total.file.max.size");
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		factory.setSizeThreshold(1024 * 500);
		File tempDirectory = new File(TEMP_DIR);
		factory.setRepository(tempDirectory);

		ServletFileUpload upload = new ServletFileUpload(factory);

		upload.setSizeMax(Integer.parseInt(totalFileMaxSize));
		upload.setFileSizeMax(Integer.parseInt(fileMaxSize));
		
		return upload;
	}

}

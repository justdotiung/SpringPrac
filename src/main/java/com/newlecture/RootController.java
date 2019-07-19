package com.newlecture;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.newlecture.web.dao.FileDao;
import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.File;

@Controller
@RequestMapping("/")
public class RootController {
	@Autowired
	private NoticeDao noticeDao;
	@Autowired
	private FileDao fileDao;
	
	
	/*
	//�Լ����·� ��Ʈ�ѷ��� ������ �ٲ㼭 
	@RequestMapping("index")
	//return�Ǵ°��� �׳� ����ش޶�� ��
	@ResponseBody
	public String index() {
		//������ ���
		System.out.println("index ��û�� �־����ϴ�.");
		return "welcomeHome";
	}
	
	
	@RequestMapping("index")
	@ResponseBody
	public void index(HttpServletResponse response) throws IOException {
		//������ ���
		PrintWriter out = response.getWriter();
		out.print("welcomeHome");
	}
	 */
	//@ResponseBody responce�� �������� �ν��ؼ� url �ƴ� ������ ������ �����ش�.
	@RequestMapping("index")
	public String index(Model model) {
	
		model.addAttribute("x", "����¯");
		return "index";
	}
	
	@RequestMapping("hello")
	@ResponseBody // ���ڵ�Ÿ�� �����ؼ�  json ���¸� ��ȯ�Ҷ� ���� ���� �ȴ�
	public String adf() {
		return "ȯ���մϴ�";
	}
	
	
	@GetMapping("file-list")
	@ResponseBody
	public String fileList() {
		
		String urlPath="/upload";
		String realPath ="";
		
		List<File> list = fileDao.getList(realPath);
		
		return "";
	}
	
	@PostMapping("upload")
	@ResponseBody
	public String upload(MultipartFile file, HttpServletRequest request) throws IOException {
		  String urlPath = "/upload";
	      String path = request
	                     .getServletContext()
	                     .getRealPath(urlPath);
	      
	      System.out.println(path);
	      
	      // 2. ���ε�� ���ϸ� ���
	      String fileName =file.getOriginalFilename();//filePart.getSubmittedFileName();
	            
	      // 3. ��� ������ �ֱ� 
	      String filePath = path + File.separator + fileName; // d:\aa + "bb.jpg" -> d:\aabb.jpg
	      
	      System.out.println(filePath);
	      
	      // 4. ��ΰ� ���ٴ� ���� ����
	      File pathFile = new File(path);
	      if(!pathFile.exists()) // �������� ������
	         pathFile.mkdirs();// �������ּ���.  
	      
	       // 5. ���������� �������� �迭�� �޴´�
	       //������ js�� �̿��ϱ⶧���� �񵿱����κ����� ���Ͼ��ε带 ���� ����°��� Ʈ�����̴�
	       File sameFile = new File(filePath);
	        System.out.println(sameFile);
	        if(sameFile.exists()) {
	           
	           int n = fileName.lastIndexOf(".");           // fileName=hello.jpg      n =?,    name=    , suffix,    
	           String name = fileName.substring(0, n);  // 
	           String suffix = fileName.substring(n);         
	           
	               fileName = name +"("+ 1 +")"+ suffix;
	       }
	      
	      InputStream fis = file.getInputStream();//filePart.getInputStream();
	      OutputStream fos = new FileOutputStream(filePath);
	      
	      byte[] buf = new byte[1024];
	      int size = 0;
	      while((size = fis.read(buf)) != -1)
	         fos.write(buf, 0, size);
	      
	      fis.close();
	      fos.close();
		return "okay";
	}
}

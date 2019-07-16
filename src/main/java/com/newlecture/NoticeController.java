package com.newlecture;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.oracle.Notice;

@Controller("adminNoticeController")
@RequestMapping("/admin/notice/")
public class NoticeController {
	@Autowired
	private NoticeDao noticeDao;

//	@RequestMapping("list")
//	public String adff(Model model ) throws ClassNotFoundException, SQLException {
//		
//		model.addAttribute("list" ,noticeDao.getList());
//	System.out.println("shektm ��û�� �־����ϴ�.");
//	return "/admin/notice/list";
//	}

	/*
	 * @RequestMapping("list") public String adff(Model model,HttpServletRequest
	 * request) throws ClassNotFoundException, SQLException { int page = 1; String p
	 * = request.getParameter("p");
	 * 
	 * if(p != null && !p.equals("")) page = Integer.parseInt(p);
	 * 
	 * model.addAttribute("list" ,noticeDao.getList(page));
	 * System.out.println("shektm ��û�� �־����ϴ�."); return "/admin/notice/list"; }
	 */

	@RequestMapping("list") // list?p=1
	public String adff(Model model, @RequestParam(name = "p", defaultValue = "1") Integer page)
			throws ClassNotFoundException, SQLException {
		// �⺻�ڷ����� null�� ������ ���ϱ� ������ �������� �Ķ���͸� ������ ž�� wrapper ������ ��������� ����� �Ѵ� (null ��
		// ���Ǵ°�)
		model.addAttribute("list", noticeDao.getList(page));
		System.out.println("shektm ��û�� �־����ϴ�.");
		return "/admin/notice/list";
	}

	/*
	 * ���Ź��
	 * 3.x�������
	 *  //get��û
	 * 
	 * @RequestMapping(value="reg" ,method=RequestMethod.GET) //list?p=1 public
	 * String adsdsdf() throws ClassNotFoundException, SQLException {
	 * 
	 * return "/admin/notice/reg";
	 *  } 
	 * //post��û
	 * 
	 * @RequestMapping(value="reg", method=RequestMethod.POST) //list?p=1 public
	 * String adsdsdf(String title) throws ClassNotFoundException, SQLException {
	 * //���𷺼� : list �������� return "redirect:list"; 
	 * }
	 */

	//4.x���
	// get��û
	@GetMapping("reg")
	public String adsdsdf() throws ClassNotFoundException, SQLException {
		System.out.println("get");
		return "/admin/notice/reg";
	}

	// post��û
	@PostMapping("reg")
	//public String adsdsdf(Notice notice) throws ClassNotFoundException, SQLException {
	//public String adsdsdf(String category,String title,String file, String content) throws ClassNotFoundException, SQLException {
	public String adsdsdf(Notice notice,
			String category,
			MultipartFile file,
			HttpServletRequest request
			) throws ClassNotFoundException, SQLException, IOException {

		System.out.println(category);
		System.out.println(notice.getTitle());
		System.out.println(notice.getContent());
		System.out.println(file);
		
		// 1. ���ε� ��θ� ���
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
		
		return "redirect:list";
	}
}

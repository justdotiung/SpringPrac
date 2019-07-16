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
//	System.out.println("shektm 요청이 있었습니다.");
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
	 * System.out.println("shektm 요청이 있었습니다."); return "/admin/notice/list"; }
	 */

	@RequestMapping("list") // list?p=1
	public String adff(Model model, @RequestParam(name = "p", defaultValue = "1") Integer page)
			throws ClassNotFoundException, SQLException {
		// 기본자료형은 null을 가지지 못하기 때문에 앞으로의 파라매터를 받을때 탑을 wrapper 형으로 명시적으로 해줘야 한다 (null 이
		// 통용되는것)
		model.addAttribute("list", noticeDao.getList(page));
		System.out.println("shektm 요청이 있었습니다.");
		return "/admin/notice/list";
	}

	/*
	 * 과거방식
	 * 3.x번정방식
	 *  //get요청
	 * 
	 * @RequestMapping(value="reg" ,method=RequestMethod.GET) //list?p=1 public
	 * String adsdsdf() throws ClassNotFoundException, SQLException {
	 * 
	 * return "/admin/notice/reg";
	 *  } 
	 * //post요청
	 * 
	 * @RequestMapping(value="reg", method=RequestMethod.POST) //list?p=1 public
	 * String adsdsdf(String title) throws ClassNotFoundException, SQLException {
	 * //리디렉션 : list 페이지로 return "redirect:list"; 
	 * }
	 */

	//4.x방식
	// get요청
	@GetMapping("reg")
	public String adsdsdf() throws ClassNotFoundException, SQLException {
		System.out.println("get");
		return "/admin/notice/reg";
	}

	// post요청
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
		
		// 1. 업로드 경로를 얻기
	      String urlPath = "/upload";
	      String path = request
	                     .getServletContext()
	                     .getRealPath(urlPath);
	      
	      System.out.println(path);
	      
	      // 2. 업로드된 파일명 얻기
	      String fileName =file.getOriginalFilename();//filePart.getSubmittedFileName();
	            
	      // 3. 경로 구분자 넣기 
	      String filePath = path + File.separator + fileName; // d:\aa + "bb.jpg" -> d:\aabb.jpg
	      
	      System.out.println(filePath);
	      
	      // 4. 경로가 없다는 오류 문제
	      File pathFile = new File(path);
	      if(!pathFile.exists()) // 존재하지 않으면
	         pathFile.mkdirs();// 생성해주세요.  
	      
	       // 5. 여러파일을 받으려면 배열로 받는다
	       //요즘은 js를 이용하기때문에 비동기적부분으로 파일업로드를 따로 만드는것이 트렌드이다
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

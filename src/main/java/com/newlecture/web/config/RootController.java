package com.newlecture.web.config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.newlecture.web.dao.FileDao;
import com.newlecture.web.dao.NoticeDao;


@Controller
@RequestMapping("/")
public class RootController {
	@Autowired
	private NoticeDao noticeDao;
	@Autowired
	private FileDao fileDao;
	
	
	/*
	//함수형태로 컨트롤러의 역할을 바꿔서 
	@RequestMapping("index")
	//return되는것을 그냥 출력해달라는 것
	@ResponseBody
	public String index() {
		//지금의 방식
		System.out.println("index 요청이 있었습니다.");
		return "welcomeHome";
	}
	
	
	@RequestMapping("index")
	@ResponseBody
	public void index(HttpServletResponse response) throws IOException {
		//과거의 방식
		PrintWriter out = response.getWriter();
		out.print("welcomeHome");
	}
	 */
	//@ResponseBody responce로 스프링이 인식해서 url 아닌 데이터 값으로 보여준다.
	@RequestMapping("index")
	public String index(Model model) {
	
		model.addAttribute("x", "웅이짱");
		return "root.index";
	}
	
	@RequestMapping("hello")
	@ResponseBody // 인코딩타입 설정해서  json 형태를 반환할때 많이 쓰게 된다
	public String adf() {
		return "환영합니다";
	}
	
	
	@GetMapping("file-list")
	@ResponseBody
	public List<com.newlecture.web.entity.File> fileList(HttpServletRequest request) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException {
		//	방법1,2의 메소드 타입 
		//		public String fileList(HttpServletRequest request)	{
		ServletContext application = request.getServletContext();
		String urlPath="/upload";
		String realPath =application.getRealPath(urlPath);
		
		List<com.newlecture.web.entity.File> list = fileDao.getList(realPath);
		//방법 1 우리가 만든 json
//		String JSON = fileDao.getJSONList(realPath);
//		return JSON;
		
		//방법2 Gson을 이용한 json문자열
		//Gson gson = new Gson();
//		return gson.toJson(list);
		
		//방법3  메소드 타입을 바꾼후 리스트로 보내준다.
		return list;
		
	}
	
	@PostMapping("upload")
	@ResponseBody
	public String upload(MultipartFile file, HttpServletRequest request) throws IOException {
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
		return "okay";
	}
}

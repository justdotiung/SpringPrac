package com.newlecture.web.cotroller.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.mybatis.MyBatisNoticeDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

@Controller("adminNoticeController")
@RequestMapping("/admin/notice/")
public class NoticeController {
	
	@Autowired
	//@Qualifier("mybatisNoticeDao")
	private NoticeDao noticedao;



	@RequestMapping("list") // list?p=1
	public String list(Model model ,Principal principal) throws ClassNotFoundException, SQLException {
		principal.getName();
//		List<NoticeView> list = sqlSession.getMapper(NoticeDao.class).getList();
//		NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class);
		NoticeDao noticeDao = noticedao;
		List<NoticeView> list = noticeDao.getList();
		model.addAttribute("list", list);
		
//		return "/admin/notice/list"; jsp페이지를 찾기위한 url 정보
		return "admin.notice.list"; //tiles에게 페이지 조립을 ㅇ부탁하기 위한 매핑이름
	}


	@GetMapping("reg")
	public String adsdsdf() throws ClassNotFoundException, SQLException {
		System.out.println("get");
		return "admin.notice.reg";
	}

	@PostMapping("reg")
	public String adsdsdf(Notice notice,
			String category,
			Principal principal,
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
	      //notice.setWritherId("newlec");
		//현재 로그인 한 사용자 계정을 얻는 방법
	      principal.getName();
	      notice.setWritherId(principal.getName());
	      noticedao.insert(notice);
		return "redirect:list";
	}
	@RequestMapping("detail")
	public String detail(Integer id,Model model) throws ClassNotFoundException, SQLException {
		Notice notice = noticedao.get(id);
		
		model.addAttribute("notice",notice);
		return "admin.notice.detail";
	}
	@GetMapping("edit")
	public String edit(Integer id,Model model) throws ClassNotFoundException, SQLException {
		model.addAttribute("notice",noticedao.get(id));
		return "admin.notice.edit";
	}
	@PostMapping("edit")
	public String edit(Notice notice) throws ClassNotFoundException, SQLException {
		Notice n = noticedao.get(notice.getId());
		n.setContent(notice.getContent());
		n.setTitle(notice.getTitle());
		noticedao.update(n);
		return"redirect:detail?id="+notice.getId();
	}
}

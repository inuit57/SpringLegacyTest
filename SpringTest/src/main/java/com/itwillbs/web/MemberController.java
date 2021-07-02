package com.itwillbs.web;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	private static final Logger logger
	= LoggerFactory.getLogger(MemberController.class); 
	
	@Inject
	private MemberService mService; 
	
	// 입력 : Get / 데이터 처리 : Post
	
	// 회원 가입 동작 
	// 1) 회원 정보 입력폼 ( get )
	//@RequestMapping("/insert")
	
	// 2) 전달된 정보를 받아서 처리 (post) 
	
	// 이 메서드는 GET방식만 지원하겠다. -> POST로 들어오면 405 에러가 뜬다.
	@RequestMapping(value="/insert", method = RequestMethod.GET)
	public void insertMemberGET() throws Exception{
		logger.info("insertMemberGET() 호출");
		
		logger.info("주소에 해당하는 view 페이지 연결"); 
		logger.info("/views/member/insert.jsp 이동 ");
	}
	
	@RequestMapping(value="/insert", method = RequestMethod.POST)
	public String insertMemberPOST(MemberVO vo) throws Exception{
		logger.info("insertMemberPOST() 호출"); 
		// 전달된 정보를 저장 
		
		// 컬럼명-변수명-파라미터명을 모두 맞춰주면 정보를 알아서 받아온다.
		logger.info("vo : " + vo);
		// 만약 다르다면 @ModelAttribute를 사용하면 된다. 
		
		mService.insertMember(vo); 
		logger.info("회원 가입 성공!");
		
		// 페이지 이동 (login 페이지로 리다이렉트) 
		return "redirect:/member/login"; 
	}

	// 이렇게 하면 둘 다 받아서 처리도 가능
	//@RequestMapping(value="/insert", method = {RequestMethod.GET , RequestMethod.POST})
	
	
	//로그인 페이지
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginGET() throws Exception{
		logger.info("C: loginGET() 호출"); 
		logger.info("C: 로그인 페이지 호출"); 
		
		return "/member/loginForm" ; 
	}
	
	// 로그인 처리 동작 (post) 
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String loginPOST(MemberVO vo , HttpSession session) throws Exception{
		logger.info("C: loginPOST() 호출");
		
		// DB에 회원 정보가 있는지 체크
		// O -> 메인 페이지 , 로그인 세션 생성 
		// X -> 다시 로그인 페이지로 이동
		
		// 서비스 동작 호출 -> DAO -> (MyBatis)mapper -> DB
		logger.info("C : 서비스 - loginMember() 호출 시도! " );
		logger.info(vo.getUserid() + "@@@@@" + vo.getUserpw()); 
		MemberVO loginVO = mService.loginMember(vo); 
		
		if(loginVO == null) {
			// 비회원 / 비밀번호 오류
			return "redirect:/member/login"; 
		}
		
		// 회원 
		// 로그인 세션 처리 (JSP 뷰 페이지에서 세션객체 전달 받아서 처리) 
		// 인자로 HttpSession 객체를 넣어주면 알아서 받아온다.
		session.setAttribute("id", loginVO.getUserid()); 
		
		return "redirect:/member/main" ; 
	}
	
	//메인 페이지 (정보 조회)
	@RequestMapping(value="/main", method = RequestMethod.GET)
	public String mainGET() throws Exception{
		logger.info("C: mainGET() 호출"); 
		logger.info("C: 메인 페이지 호출"); 
		
		return "/member/main" ; 
	}
	
	//로그아웃
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutGET(HttpSession session) throws Exception{
		logger.info("C: logoutGET() 호출"); 
		logger.info("C: 로그아웃 페이지 호출"); 
		
		session.invalidate(); 
		
		return "redirect:/member/main" ; 
	}
	
	//회원 정보 조회(info)
	@RequestMapping(value="/info" , method = RequestMethod.GET)
	public void infoGET(HttpSession session , Model model) throws Exception{
		logger.info("C : infoGET() 호출"); 
		logger.info("C : 회원 정보 페이지 호출!"); 
		
		// DB에 회원 정보를 가져오는 동작 
		
		// DB 회원 정보를 view 페이지로 이동 
		
		String id = (String)session.getAttribute("id") ; 
		//request.setAttribute("mdto",  mService.infoMember(id) );
		
		// model : 저장한 값을 view로 넘겨준다.
		model.addAttribute("mdto", mService.infoMember(id)); 
		
		logger.info("페이지 이동  /views/member/info.jsp ");
	}
	
	
	//업데이트 ( 기존 정보를 보여주기 ) 
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public String updateGET(Model model, HttpSession session) throws Exception{
		logger.info("C: updateGET() 호출"); 
		logger.info("C: 업데이트 페이지 호출"); 
		
		String id = (String)session.getAttribute("id") ;
		
		// model : 저장한 값을 view로 넘겨준다.
		model.addAttribute("mdto", mService.infoMember(id)); 
			
		logger.info("페이지 이동  /views/member/update.jsp ");
		
		return "/member/updateForm"; 
	}
	
	//업데이트 ( 기존 정보를 보여주기 ) 
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String updatePOST(MemberVO vo) throws Exception{
		logger.info("C: updatePOST() 호출"); 
		logger.info("C: 업데이트 페이지 호출"); 

		mService.updateMember(vo); 
		logger.info("페이지 이동  /views/member/main.jsp ");
		
		return "redirect:./main";
	}
	
	
	// 회원 탈퇴 구현
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public String deleteGET(HttpSession session) throws Exception{
		logger.info("C: deleteGET() 호출"); 
		logger.info("C: 회원 탈퇴 페이지 호출"); 
		
		String id = (String)session.getAttribute("id") ;
		
		return "/member/deleteForm"; 
	}
	
	// 회원 탈퇴 구현
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public String deletePOST(MemberVO vo , HttpSession session) throws Exception{
		logger.info("C: deletePOST() 호출"); 
		logger.info("C: 회원 탈퇴 페이지 호출"); 
		
		mService.deleteMember(vo); 
		session.invalidate(); 
		
		return "redirect:./main"; 
	}
	
	// 관리자 기능 - 회원 목록 확인
	@RequestMapping(value="/list" , method = RequestMethod.GET)
	public void listGET(Model model) throws Exception{
		logger.info("C: listGET() 호출"); 
		
		List<MemberVO> memberList =  mService.listMember();
		
		model.addAttribute("memberList", memberList); 
		
	}

}

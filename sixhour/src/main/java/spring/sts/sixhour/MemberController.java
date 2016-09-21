package spring.sts.sixhour;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.model.member.MemberDAO;
import spring.model.member.MemberDTO;
import spring.utility.sixhour.Utility;

@Controller
public class MemberController {
	@Autowired
	private MemberDAO dao;
	
	@RequestMapping("member/total")
	public ResponseEntity<String> getTotalList() {


		Map map = new HashMap();

	   List<MemberDTO> list = dao.list(map);
		
	   HttpHeaders header = new HttpHeaders();
	   header.add("Content-Type", "text/csv; charset=MS949");
	   header.add("Content-Disposition", "attachment; filename=\"" + "total.csv" + "\"");

	   return new ResponseEntity<String>(setContent(list), header, HttpStatus.CREATED);
	} 
	
	
	
	private String setContent(List<MemberDTO> list) {
		
		
		StringBuffer writer = new StringBuffer();
		 
		for(int i = 0; i<list.size(); i++){
			MemberDTO dto = list.get(i);
			
			writer.append(dto.getMnum());
			writer.append(',');
			writer.append(dto.getMgrade());
			writer.append(',');
			writer.append(dto.getMname());
			writer.append(',');
			writer.append(dto.getMphone());
			writer.append(',');
			writer.append(dto.getMemail());

			writer.append('\n');	
		}
		
		
	 
		return writer.toString();
	}



	@RequestMapping(value = "member/list")
	public String list(HttpServletRequest request, Model model) {

		
		
	
		String col = Utility.nullCheck(request.getParameter("col"));
		String word = Utility.nullCheck(request.getParameter("word"));

		if (col.equals("total"))
			word = "";

		
		Map map = new HashMap();
		map.put("col", col);
		map.put("word", word);

		int total = dao.total(col, word);

		List<MemberDTO> list = dao.list(map);
		
		model.addAttribute("col", col);
		model.addAttribute("word", word);
		model.addAttribute("list", list);
		return "/member/list";
	}

	
	@RequestMapping(value="member/update", method=RequestMethod.POST)
	public String update(MemberDTO dto){
		
		if(dao.update(dto)>0){
			return "redirect:/member/list";
		}
		
		return "/member/update";
	}
	
	@RequestMapping(value="member/update", method=RequestMethod.GET)
	public String update(int mnum,  Model model){
		
		MemberDTO dto = dao.read(mnum);
		
		model.addAttribute("dto", dto);
		
		return "/member/updateForm";
	}
	
	@RequestMapping(value="member/delete", method=RequestMethod.POST)
	public String delete(int mnum, HttpServletRequest request){
		
		if(dao.delete(mnum)>0){
					
			return "redirect:/member/list";
		}else{
			return "error/error";
		}
				
	}
	
	
	@RequestMapping(value="member/delete", method=RequestMethod.GET)
	public String delete(int mnum, Model model){
	
		model.addAttribute("mnum",mnum);
		
		return "/member/deleteForm";
	}

	
	@RequestMapping(value="/member/create",method=RequestMethod.POST)
	public String create(MemberDTO dto, HttpServletRequest request, Model model){

		
	  	if(dao.create(dto)>0){
	  		return "redirect:/member/list";
	  	}else{
	  		return "/error/error";
	  	}
		
	}
	
	@RequestMapping("member/create")
	public String create(){
		
		return "/member/createForm";
	}
	
	
	
}

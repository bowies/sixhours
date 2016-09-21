package spring.model.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public List<MemberDTO> list(Map map) {

		return mybatis.selectList("member.list", map);
	}


	public int create(MemberDTO dto) {
		return mybatis.insert("member.create", dto);
		
	}


	public int delete(int mnum) {
		return mybatis.delete("member.delete", mnum);
	}


	public int update(MemberDTO dto) {
		return mybatis.update("member.update", dto);
	}


	public MemberDTO read(int mnum) {
		return mybatis.selectOne("member.read", mnum);
	}


	public int total(String col, String word) {
		Map map = new HashMap();
		map.put("col", col);
		map.put("word", word);

		return mybatis.selectOne("member.total", map);
	}
	
	
}

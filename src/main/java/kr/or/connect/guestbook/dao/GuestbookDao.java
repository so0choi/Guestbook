package kr.or.connect.guestbook.dao;

import static kr.or.connect.guestbook.dao.GuestbookSqls.DELETE_BY_ID;
import static kr.or.connect.guestbook.dao.GuestbookSqls.SELECT_COUNT;
import static kr.or.connect.guestbook.dao.GuestbookSqls.SELECT_PAGING;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.guestbook.dto.Guestbook;
@Repository
public class GuestbookDao {
	//insertAction- simple jdbc insert
	//jdbc : named parameterjdbctemplate
	//rowMapper : rowmapper<Geustbook>=beanproperty ...
	
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Guestbook> rowMapper = BeanPropertyRowMapper.newInstance(Guestbook.class);
	private SimpleJdbcInsert insertAction;
	
	public GuestbookDao(DataSource dataSource) {
		this.jdbc=new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("guestbook")
				.usingGeneratedKeyColumns("id");
	}
	
	public int deleteById(Long id) {
		Map<String,?> params=Collections.singletonMap("id", id);
		return jdbc.update(DELETE_BY_ID, params);
	}
	
	public Long insert(Guestbook guestBook) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(guestBook);
		return insertAction.executeAndReturnKey(params).longValue();
	}
	
	public List<Guestbook> selectAll(Integer start, Integer limit){
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit",limit);
		return jdbc.query(SELECT_PAGING, params, rowMapper);
	}
	
	public int selectCount() {
		return jdbc.queryForObject(SELECT_COUNT,Collections.emptyMap(),Integer.class);
	}
}

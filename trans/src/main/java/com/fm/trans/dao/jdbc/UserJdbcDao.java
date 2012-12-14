package com.fm.trans.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UserJdbcDao extends JdbcDaoSupport {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public List<String> getAllUsernames(){
		String query = "SELECT username FROM user";

		List<String> result;
		
		result = getJdbcTemplate().query(query, new RowMapper<String>(){
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				logger.debug("adding username '{}' to the list", rs.getString(1));
				return rs.getString(1);
			}
		});
		
		return result;
	}

}

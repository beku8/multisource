package com.fm.multisource.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.fm.multisource.domain.Item;

public class Catalog extends JdbcDaoSupport {
	
	public List<Item> getItems(){
		String query = "select name, price from item";
		return getJdbcTemplate().query(query, new ParameterizedRowMapper<Item>() {
			public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
				String name = rs.getString(1);
				Double price = rs.getDouble(2);
				return new Item(name, price);
			}
		});
	}

}

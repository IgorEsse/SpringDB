package ru.esseigor.SpringDB.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import ru.esseigor.SpringDB.mapper.UserMapper;
import ru.esseigor.SpringDB.model.UserInfo;

public class UserDAO extends JdbcDaoSupport{

	@Autowired
	public UserDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	public List<UserInfo> getUserInfo(){
		String sql = UserMapper.BASE_SQL;
		Object[] params = new Object[] {};
		UserMapper mapper = new UserMapper();
		List<UserInfo> list = this.getJdbcTemplate().query(sql, params, mapper);
		
		return list;
	}
}

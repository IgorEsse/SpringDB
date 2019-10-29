package ru.esseigor.SpringDB.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import ru.esseigor.SpringDB.mapper.UserMapper;
import ru.esseigor.SpringDB.model.UserInfo;

@Repository
public class UserDAO extends JdbcDaoSupport{

	@Autowired
	public UserDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	public List<UserInfo> getUsers(){
		String sql = UserMapper.BASE_SQL;
		Object[] params = new Object[] {};
		UserMapper mapper = new UserMapper();
		List<UserInfo> list = this.getJdbcTemplate().query(sql, params, mapper);
		return list;
	}
	
	public List<UserInfo> findUser(String login) {
		String sql = UserMapper.BASE_SQL + " WHERE u.login = ?";
		Object[] params = new Object[] {login};
		UserMapper mapper = new UserMapper();
		List<UserInfo> list = this.getJdbcTemplate().query(sql, params, mapper);
		return list;
	}
}

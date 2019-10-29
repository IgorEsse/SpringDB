package ru.esseigor.SpringDB.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import ru.esseigor.SpringDB.model.UserInfo;

public class UserMapper implements RowMapper<UserInfo>{

	public static final String BASE_SQL = "SELECT u.id id, u.login login, u.fio fio FROM db_app.users u ";
	public static final String INSERT_BASE_SQL = "INSERT INTO db_app.users(login, fio) VALUES(?, ?)";
	
	@Override
	public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Long id = rs.getLong("id");
		String login = rs.getString("login");
		String fio = rs.getString("fio");
		
		return new UserInfo(id, login, fio);
	}

}

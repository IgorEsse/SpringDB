package ru.esseigor.SpringDB.model;

public class UserInfo {

	private Long id;
	private String login;
	private String fio;
	
	public UserInfo(Long id, String login, String fio) {
		super();
		this.id = id;
		this.login = login;
		this.fio = fio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFio() {
		return fio;
	}

	public void setFio(String fio) {
		this.fio = fio;
	}
	
}

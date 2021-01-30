package eu.it.academy.dao;

import java.util.ArrayList;
import java.util.List;

import eu.it.academy.entity.User;

public class UserDao {
    private List<User> users = new ArrayList<>();

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
  
}

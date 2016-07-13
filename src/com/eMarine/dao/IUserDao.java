package com.eMarine.dao;

import java.util.List;

import com.eMarine.entity.User;

public interface IUserDao {
	public void AddUser(User user);
	public void modifyUser(User user);
	public void deleteUser(User user);
	public List<User> listUser();
}

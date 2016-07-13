package com.eMarine.service;

import java.util.List;

import com.eMarine.entity.User;

public interface IUserManage {
	public void addUser(User user);
	public void modifyUser(User user);
	public void deleteUser(User user);
	public List<User> listUser();
}

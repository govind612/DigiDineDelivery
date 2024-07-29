package com.food.DAO;

import java.util.List;

import com.food.model.User;

public interface UserDAO {
int addUser(User user);
User getUser(String email, String password);
void updateUser(User user);
void deleteUser(int userId);
List<User> getAllUser();

}

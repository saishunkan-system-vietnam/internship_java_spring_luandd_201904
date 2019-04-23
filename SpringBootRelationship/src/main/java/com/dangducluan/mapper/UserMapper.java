package com.dangducluan.mapper;
import com.dangducluan.entities.*;
import java.util.*;
public interface UserMapper {
	public abstract List<User> getAllUsers();
	public abstract User getUserById(int userId);
}

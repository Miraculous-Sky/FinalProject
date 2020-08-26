package root.services;

import java.util.List;
import java.util.Optional;

import root.entity.User;

public interface UserService {
	void save(User user);

	void deleteUserById(int id);

	boolean findByEmail(String email);

	Optional<User> findUserById(int id);

	boolean canLogin(User user);

	boolean canLogin(String email, String password);

	User findEmail(String email);

	List<User> getAllUser();
}

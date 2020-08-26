package root.services;

import root.entity.User;

public interface UserService {
	void save(User user);

	boolean findByEmail(String email);

	boolean canLogin(User user);

	boolean canLogin(String email, String password);
}

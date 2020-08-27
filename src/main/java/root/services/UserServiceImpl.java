package root.services;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import root.entity.User;
import root.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public boolean findByEmail(String email) {
		Iterator<User> itr = userRepository.findAll().iterator();
		while (itr.hasNext()) {
			if (itr.next().getEmail().equalsIgnoreCase(email)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean canLogin(User user) {
		Iterator<User> itr = userRepository.findAll().iterator();
		while (itr.hasNext()) {
			User u = itr.next();
			if (u.getEmail().equalsIgnoreCase(user.getEmail()) && u.getPassword().equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean canLogin(String email, String password) {
		Iterator<User> itr = userRepository.findAll().iterator();
		while (itr.hasNext()) {
			User u = itr.next();
			if (u.getEmail().equalsIgnoreCase(email) && u.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public User findEmail(String email) {
		Iterator<User> itr = userRepository.findAll().iterator();
		while (itr.hasNext()) {
			User u = itr.next();
			if (u.getEmail().equalsIgnoreCase(email)) {
				return u;
			}
		}
		return null;


	}

	@Override
	public List<User> getAllUser() {
		List<User> users = (List<User>) userRepository.findAll();
		return users;
	}

	@Override
	public void deleteUserById(int id) {
		userRepository.deleteById(id);

	}

	@Override
	public Optional<User> findUserById(int id) {
		return userRepository.findById(id);

	}
}

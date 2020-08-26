package root.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import root.entity.User;
import root.repository.UserRepository;

@Service
public class UserDetailsImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserServiceImpl userServiceImpl;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// User user = userRepository.findByEmail(email);
		User user = userServiceImpl.findEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException(email);
		}
		//
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
		grantList.add(authority);
		//
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getEmail(), //
				user.getPassword(), grantList);

		return userDetails;
	}

}

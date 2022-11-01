package banque.managment.backend.config.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import banque.managment.backend.config.security.UserDetailsImpl;
import banque.managment.backend.entities.User;
import banque.managment.backend.services.IUserService;
@Service
public class UserDetailsServieImpl implements UserDetailsService{
@Autowired
private IUserService userService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userOptional =userService.findByLogin(username);
		if (userOptional.isPresent()){
			return new UserDetailsImpl(userOptional.get());
		}
		return null;
	}

}

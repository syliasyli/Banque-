package banque.managment.backend.services;

import java.util.List;
import java.util.Optional;
import banque.managment.backend.entities.User;

public interface IUserService {
	User save(User user);
	Optional<User> findById(Long id);
	Optional<User> findByLogin(String login);
	List<User> findAll();
	List<User> findByRoleCode(String code);
}
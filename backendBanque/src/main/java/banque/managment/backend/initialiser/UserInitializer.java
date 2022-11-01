package banque.managment.backend.initialiser;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import banque.managment.backend.entities.Role;
import banque.managment.backend.entities.User;
import banque.managment.backend.services.IUserService;
import banque.managment.backend.services.IRoleService;

@Component
@Order(2)
public class UserInitializer implements CommandLineRunner{
	@Autowired
    private IRoleService roleService;
	@Autowired
	private IUserService userService;
	@Override
	public void run(String... args) throws Exception {
		
		Optional<User> adminOptional = userService.findByLogin("admin");
		
		if(!adminOptional.isPresent()) {
			
		Optional<Role> roleAdminOptional = roleService.findByCode("ADMIN");
	        
		if(roleAdminOptional.isPresent()){
			
			User admin = new User();
			admin.setRole(roleAdminOptional.get());
			admin.setEmail("admin@test.com");
			admin.setFirstName("Syl");
			admin.setLastName("Samah");
			admin.setLogin("admin");
			
			userService.save(admin);
			}
		}
		
		
		}


}

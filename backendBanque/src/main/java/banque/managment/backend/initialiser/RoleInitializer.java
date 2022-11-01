package banque.managment.backend.initialiser;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import banque.managment.backend.entities.Role;
import banque.managment.backend.services.IRoleService;

@Component
@Order(1)
public class RoleInitializer implements CommandLineRunner{
	@Autowired
private IRoleService roleService;
	@Override
	public void run(String... args) throws Exception {
		
		if(!roleService.findByCode("ADMIN").isPresent()){
			
		Role role1 = new Role();
		role1.setCode("ADMIN");
		role1.setLabel("Admin Banque");
		roleService.save(role1);
		}
		
		}

}

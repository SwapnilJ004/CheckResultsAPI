package com.resultsDeclaration.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.resultsDeclaration.Entities.EpollUser;
import com.resultsDeclaration.Repositories.UsersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsersRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		EpollUser user = repo.findByEmail(email);
		
		if(user == null) throw new UsernameNotFoundException("No User Found");
		
		return User.builder().username(email)
				.password(user.getPasswordHash())
				.authorities(user.getRoleId().getRoleName())
				.build();
	}
	

}
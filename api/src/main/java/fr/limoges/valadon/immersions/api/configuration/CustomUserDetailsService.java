package fr.limoges.valadon.immersions.api.configuration;

import java.util.List;
import java.util.Collections;

import fr.limoges.valadon.immersions.api.model.Users;
import fr.limoges.valadon.immersions.api.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = usersRepository.findByEmailUser(email);

        if (user == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé avec l'email : " + email);
        }

        return new User(user.getEmailUser(), user.getPassword(), getGrantedAuthorities(user.getRole()));
    }

    private List<GrantedAuthority> getGrantedAuthorities(String role) {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role));
    }
}

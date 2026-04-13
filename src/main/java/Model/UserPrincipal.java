package Model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {
    @Autowired    
    private User user;
    
        public UserPrincipal(User user) {
            this.user = user;
        }
    
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return Collections.singleton(new SimpleGrantedAuthority("USER"));
        }
    
        @Override
        public String getPassword() {
            return user.getPassword();
        }
    
        @Override
        public String getUsername() {
            return user.getUsername();
        }
    
        @Override
        public boolean isAccountNonExpired() {
            return true; // Implement account expiration logic if needed
        }
    
        @Override
        public boolean isAccountNonLocked() {
            return true; // Implement account locking logic if needed
        }
    
        @Override
        public boolean isCredentialsNonExpired() {
            return true; // Implement credential expiration logic if needed
        }
    
        @Override
        public boolean isEnabled() {
            return true; // Implement account enabling logic if needed
        }
    
}

//package it.plansoft.auth.model;
//
//import it.plansoft.auth.security.ApplicationUserRole;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import javax.persistence.Entity;
//import java.util.Collection;
//import java.util.List;
//
///**
// * classe di esempio che mappa utente e password con lista ruoli
// *
// * @author Giuseppe Grosso
// */
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class UserAccount extends BaseModel<Long> implements UserDetails {
//
//    private static final long serialVersionUID = 3617721411274218217L;
//
//    private User user;
//    private List<Roles> roles;
//    private Account account;
//
//    private Boolean locked = false;
//
//    private Boolean enabled = true;
//
//    private Boolean expired = false;
//
//    public Boolean getExpired() {
//        return expired;
//    }
//
//    public void setExpired(Boolean expired) {
//        this.expired = expired;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//
//        if (roles != null) {
//            return ApplicationUserRole.USER.getGrantedAuthorities(roles);
//        }
//
//        return ApplicationUserRole.USER.getGrantedAutorities();
//
//    }
//
//    @Override
//    public String getPassword() {
//        return account.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return account.getSso();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return !expired;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return !locked;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return !expired;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return enabled;
//    }
//
//}

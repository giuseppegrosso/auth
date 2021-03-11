package it.plansoft.auth.security;

import it.plansoft.auth.model.Roles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * ruoli utente e permessi
 */
public enum ApplicationUserRole {

    USER(ApplicationUserPermission.getUserPermission()),
    ADMIN(ApplicationUserPermission.getAdminPermission());

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<GrantedAuthority> getGrantedAuthorities(List<Roles> roles) {
        Set<GrantedAuthority> permissions = new HashSet<>();
        if (roles != null) {
            roles.forEach(role -> {
                if (role.getRuolo().equalsIgnoreCase(USER.name()) || role.getRuolo().equalsIgnoreCase(ADMIN.name()))
                    permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

                else
                    permissions.add(new SimpleGrantedAuthority(role.getRuolo()));

            });

        }
        return permissions;
    }

    public Set<GrantedAuthority> getGrantedAutorities() {
        Set<GrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toSet());

        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return permissions;
    }

}

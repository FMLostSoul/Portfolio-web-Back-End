package com.yoprogramo.portfolioweb.Security.DTO;

import java.util.Collection;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter @Setter
public class JwtDTO {

    private String token;
    private String bearer = "Bearer";
    private String userName;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtDTO(String token, String nombreUsuario, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.userName = nombreUsuario;
        this.authorities = authorities;
    }

}

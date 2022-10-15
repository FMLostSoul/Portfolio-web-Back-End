package com.yoprogramo.portfolioweb.Security.Jwt;

import com.yoprogramo.portfolioweb.Security.Model.PrivilegedUser;
import io.jsonwebtoken.*;
import java.util.Date;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.util.Map;
import javax.crypto.SecretKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {

    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public String generateToken(Authentication authentication) {
        PrivilegedUser usuarioPrincipal = new PrivilegedUser(authentication.getPrincipal().toString(), authentication.getCredentials().toString(), authentication.getAuthorities());
        return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(key)
                .compact();
    }

    public Map<String, Object> parseClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String getNombreUsuarioFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Bad token");
        } catch (UnsupportedJwtException e) {
            logger.error("Unsupported token");
        } catch (ExpiredJwtException e) {
            logger.error("Expired");
        } catch (IllegalArgumentException e) {
            logger.error("Empty token");
        } catch (SecurityException e) {
            logger.error("Unsafe");
        }
        return false;
    }
}

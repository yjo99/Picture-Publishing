package com.jo.picPublising.security.jwt;

import com.jo.picPublising.persistance.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.log4j.Log4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.util.*;
import java.util.function.Function;

@Service
@Log4j
public class jwtService {

    private static final String sKey = "397A24432646294A404E635166546A576E5A7234753778214125442A472D4B61";

    private Key getsKey(){
        byte[] keyBytes = Decoders.BASE64.decode(sKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getsKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    public <T> T extractClamis(String token, Function<Claims, T> claimsResolver){
        final Claims clamis = extractAllClaims(token);
        return claimsResolver.apply(clamis);
    }
    public String extractUsername(String token){
        return extractClamis(token,Claims::getSubject);
    }

    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }
    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails){
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .claim("role", userDetails.getAuthorities())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 48) ))
                .signWith(SignatureAlgorithm.HS256, getsKey())
                .compact();
    }
    private Date extractExpiration(String token){
        return extractClamis(token, Claims::getExpiration);
    }
    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }
    public boolean isTokenValid(String token , UserDetails userDetails){
        final String userName = extractUsername(token);
        return (userName.equals(userDetails.getUsername() ) && !isTokenExpired(token));
    }




}

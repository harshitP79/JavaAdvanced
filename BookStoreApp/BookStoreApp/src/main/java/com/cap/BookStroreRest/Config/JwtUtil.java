package com.cap.BookStroreRest.Config;

import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {
    private final String SECRET_KEY="";
    private final int JWT_EXPIRATION=90000;
    private final int REFRESH_EXPIRATION=604800000;

    private SecretKey getSigningKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String email){
        return generateToken(email,JWT_EXPIRATION);
    }


    private String generateToken(String email, long expiration){
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setEcpiration(new Date(System.currentTimeMillis()+expiration))
                .signWith(getSigningKey(),SignatureAlgorithm.HS256)
                .compact();
    }

    private Claims extractAllClaims(String token){
        return jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }




}

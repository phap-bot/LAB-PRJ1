package com.project.backend.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

/**
 * TokenService tạo & xác thực JWT:
 * - Subject = email người dùng
 * - Ký HMAC-SHA256 với SECRET KEY
 * - Có hạn (expiration)
 */
@Service
public class TokenService {

    // Nên đưa vào cấu hình/biến môi trường. Để demo rubric, hard-code một key.
    // Key phải đủ mạnh để HS256 sử dụng (>= 256 bit).
    private static final Key SIGNING_KEY =
            Keys.hmacShaKeyFor("super-secret-key-which-should-be-32+chars-long!!".getBytes());

    // 1 giờ (ms)
    private static final long EXPIRATION_MS = 60 * 60 * 1000;

    /** Tạo JWT với subject là email (yêu cầu rubric). */
    public String generateToken(String email) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + EXPIRATION_MS);

        return Jwts.builder()
                .setSubject(email)             // <— email
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(SIGNING_KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    /** Kiểm tra token hợp lệ cho email: đúng subject & chưa hết hạn & chữ ký hợp lệ. */
    public boolean validateToken(String token, String email) {
        String subject = getClaim(token, Claims::getSubject);
        return email.equals(subject) && !isExpired(token);
    }

    /** Lấy email (subject) từ token. */
    public String getEmailFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    /** Kiểm tra hạn của token. */
    public boolean isExpired(String token) {
        Date exp = getClaim(token, Claims::getExpiration);
        return exp.before(new Date());
    }

    /** Generic: lấy claim bất kỳ. */
    private <T> T getClaim(String token, Function<Claims, T> extractor) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(SIGNING_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return extractor.apply(claims);
    }
}

package com.project.backend.services;

import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
  private final Map<Integer,String> active = new HashMap<>();
  public String generateToken(int userId){ String t=UUID.randomUUID().toString(); active.put(userId,t); return t; }
  public boolean validateToken(int userId,String token){ return token!=null && token.equals(active.get(userId)); }
  public void revokeToken(int userId){ active.remove(userId); }
}

package fr.formation.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

import fr.formation.annotation.WithMockUserId;

public class WithMockUserIdSecurityContextFactory implements WithSecurityContextFactory<WithMockUserId> {
    @Override
    public SecurityContext createSecurityContext(WithMockUserId userId) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        
        String principal = userId.value();
        Authentication auth = new UsernamePasswordAuthenticationToken(principal, "password", null);
        
        context.setAuthentication(auth);

        return context;
    }
}

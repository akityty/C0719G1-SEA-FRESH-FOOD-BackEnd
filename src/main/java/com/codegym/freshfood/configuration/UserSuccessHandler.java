package com.codegym.freshfood.configuration;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Component
public class UserSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
  private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
  @Override
  protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
    String targetUrl = determineTargetUrl(authentication);
    if (response.isCommitted()) {
      System.out.println("can't redirect");
      return;
    }
    redirectStrategy.sendRedirect(request, response, targetUrl);
  }

  private String determineTargetUrl(Authentication authentication) {
    String url = "";
    Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
    List<String> roles = new ArrayList<String>();
    for (GrantedAuthority a : authorities) {
      roles.add(a.getAuthority());
    }
    if(isAdmin(roles)) {
      url = "/home";
    } else if(isUser(roles)) {
      url = "/templates/user";
    } else {
      url  = "/403";
    }
    return url;
  }

  private boolean isUser(List<String> roles) {
    if (roles.contains("ROLE_USER"))
      return true;
    return false;
  }

  private boolean isAdmin(List<String> roles) {
    if (roles.contains("ROLE_ADMIN"))
      return true;
    return false;
  }

  @Override
  public RedirectStrategy getRedirectStrategy() {
    return redirectStrategy;
  }

  @Override
  public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
    this.redirectStrategy = redirectStrategy;
  }
}

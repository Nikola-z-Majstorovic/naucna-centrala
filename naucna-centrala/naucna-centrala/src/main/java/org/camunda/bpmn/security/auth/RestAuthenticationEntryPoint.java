package org.camunda.bpmn.security.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
	
	//Metoda koja se izvrsava ukoliko neautorizovani korisnik pokusa da pristupi zasticenom REST servisu
	//Metoda vraca 401 Unauthorized response, ukoliko postoji Login Page u aplikaciji, pozeljno je da se korisnik redirektuje na tu stranicu
	public void commence(HttpServletRequest arg0, HttpServletResponse response, AuthenticationException authException)
			throws IOException, ServletException {
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
	}
	
}
package com.astroganit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.astroganit.security.CustomUserDetailService;
import com.astroganit.security.JwtAuthenticationEntryPoint;
import com.astroganit.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableWebMvc
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	public  static final String[] PUBLIC_URLS= {
			"/api/ganit/v1/auth/token",
			"/",
			"/v3/api-docs",
			"/v2/api-docs",
			"/swagger-resources/**",
			"/swagger-ui/**",
			"/webjars/**",
			"/**"
			};
	public  static final String[] AUTH_URLS= {
			"/api/user/update/profile/**"
			};
	
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	// this method is used in upper version of spring instead of overridden comment method configure(HttpSecurity http)
		@Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			http
			.csrf()
			.disable()
			.authorizeHttpRequests()
			.antMatchers(AUTH_URLS).authenticated()
			.antMatchers(PUBLIC_URLS).permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.exceptionHandling().authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			
			http.addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
			http.authenticationProvider(daoAuthenticationProvider());
	        return http.build();
	    }
		
		//this method is used for upper version before it is used override method configure(AuthenticationManagerBuilder auth)
		@Bean
		public DaoAuthenticationProvider daoAuthenticationProvider() {
			DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
			provider.setUserDetailsService(this.customUserDetailService);
			provider.setPasswordEncoder(passworEncoder());
			return provider;
		}
		
		@Bean
		public PasswordEncoder passworEncoder() {
			return new BCryptPasswordEncoder();
		}
		
		@Bean
	    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception {
			return configuration.getAuthenticationManager();
	    }
		

}

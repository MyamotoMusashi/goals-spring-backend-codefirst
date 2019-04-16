//package goals.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import goals.config.WebConfig;
//
//@Configuration
//@EnableWebSecurity
//@EnableWebMvc
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	
//	private PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	
//	@Autowired
//	private WebConfig webConfig;
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		
//		auth.inMemoryAuthentication()
//			.withUser("buzz")
//				.password(encoder.encode("1234"))
//				.authorities("ROLE_USER");
//			
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		
//		http.cors()
//			.and()
//				.authorizeRequests()
//					.antMatchers("/", "/**")
//						.permitAll();				
//	}
//}

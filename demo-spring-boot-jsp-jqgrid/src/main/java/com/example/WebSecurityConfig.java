package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity 
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
	        .authorizeRequests()
	        .antMatchers("/login").permitAll()	// 접근 허용 폴더 지정
			.antMatchers("/*.jsp", "/*/*.jsp").denyAll()	// 접근 금지
	        .anyRequest().authenticated()
	        .and()
	    .formLogin()
	    	.usernameParameter("username") // default is username
	    	.passwordParameter("password") // default is password
	        .loginPage("/login")			// 로그인을 위한 페이지
			.defaultSuccessUrl("/")			// 로그인 성공시
	        .loginProcessingUrl("/login")	// 로그인 값을 보내는 url
	        .permitAll()
	        .and()
	    .logout().logoutSuccessUrl("/login")
	        .permitAll();
//        .and().csrf().disable();
//                .ignoringAntMatchers("/db/h2-console/*");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("user").roles("USER");
    }
}

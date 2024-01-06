package com.example.librarysec.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
//        auth.inMemoryAuthentication().withUser("librarian").password("librarian").roles("LIBRARIAN");
//        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");

        auth.inMemoryAuthentication().withUser("basic").password("basic").roles("BASIC");
        auth.inMemoryAuthentication().withUser("advanced").password("advanced").roles("ADVANCED");
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");

    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder(){
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.csrf().disable();

//        http.authorizeHttpRequests()
//                .mvcMatchers(HttpMethod.GET, "/books/**")
//                .hasAnyRole("USER", "LIBRARIAN", "ADMIN")
//                .mvcMatchers(HttpMethod.POST, "/**")
//                .hasAnyRole("LIBRARIAN", "ADMIN")
//                .mvcMatchers(HttpMethod.DELETE, "/**")
//                .hasAnyRole("ADMIN", "ADMIN")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();

        http.authorizeHttpRequests()
                .mvcMatchers(HttpMethod.GET, "/books/**")
                .hasAnyRole("BASIC", "ADVANCED", "ADMIN")
                .mvcMatchers(HttpMethod.POST, "/**")
                .hasAnyRole("ADVANCED", "ADMIN")
                .mvcMatchers(HttpMethod.DELETE, "/**")
                .hasAnyRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

    }

}

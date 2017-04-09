package com.heroku.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
////                .antMatchers("/", "/rest", "/mvc").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/mvc/login")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();

        http
                .formLogin()
                .defaultSuccessUrl("/mvc")
                .loginPage("/mvc/login")
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/denied")
                .and()
                .authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/mvc/**").hasRole("EMPLOYEE")
                .antMatchers("/rest/**").hasRole("EMPLOYEE")
                .antMatchers("/mvc/**").hasRole("EMPLOYEE")
                .antMatchers("/mvc").hasRole("EMPLOYEE")
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/mvc/login");

//        http
//                .formLogin()
////                .defaultSuccessUrl("/mvc")
//
////                .loginPage("/mvc/login")
//                .permitAll()
//                .and()
//                .exceptionHandling()
//                .accessDeniedPage("/denied")
//                .and()
//                .authorizeRequests()
//                .antMatchers("/resources/**").permitAll()
//                .antMatchers("/**").hasRole("EMPLOYEE")
////                .antMatchers("/rest/**").hasRole("EMPLOYEE")
////                .antMatchers("/mvc/**").hasRole("EMPLOYEE")
////                .antMatchers("/mvc").hasRole("EMPLOYEE")
//                .and()
//                .logout()
//                .permitAll()
//                .logoutSuccessUrl("/login");

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        StandardPasswordEncoder encoder = new StandardPasswordEncoder();
        auth
                .inMemoryAuthentication()
                .passwordEncoder(encoder)
                .withUser("Augusta").password("da7e82ae61672bb149e19657b51651f56fa8787d11abc0854e6ba87f2c9a82972c239710d7f855ef").roles("EMPLOYEE").and()
                .withUser("Simon").password("09b446ea9aaa9e4de38b0c29e496c9114de40b255f7d22e77d15329f8f800c4b366d6ad5eedd0a5a").roles("EMPLOYEE");
    }
}
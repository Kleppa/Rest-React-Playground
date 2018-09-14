package com.klejar.backend.pokedexbackend.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {

        http.authorizeRequests()
                /*
                    these rules are matched one at a time, in their order.
                    this is important to keep in mind if different URL templates
                    can match the same URLs
                 */
                .antMatchers("/create/user","/login").permitAll()
                .antMatchers("/").hasRole("USER")
                .antMatchers("/forAdmins").hasRole("ADMIN")
                /*
                    whitelisting: deny everything by default,
                    unless it was explicitly allowed in the rules
                    above.
                 */
                .anyRequest().denyAll()
                .and()

                /*
                    there are many different ways to define
                    how login is done.
                    So here we need to configure it.
                    We start from looking at "Basic" HTTP,
                    which is the simplest form of authentication
                  */
                .httpBasic()
    }


    /*
        Here we configure how users are authenticated.
        For simplicity here we just create some pre-defined users.
     */
    override fun configure(auth: AuthenticationManagerBuilder) {

//        auth.inMemoryAuthentication()
//                .withUser("foo").password("{noop}123456").roles("USER").and()
//                .withUser("admin").password("{noop}bar").roles("ADMIN", "USER")
    }
}
package com.codegym.cms;

//import com.codegym.cms.component.MyAccessDeniedHandler;
import com.codegym.cms.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class AppSecConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public AppUserService appUserService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.inMemoryAuthentication()
                .withUser("user").password("12345").roles("USER")
                .and()
                .withUser("admin").password("12345").roles("ADMIN");*/

        auth.userDetailsService((UserDetailsService) appUserService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/user/**").access("hasRole('USER')")
                .antMatchers("/orders/**").access("hasRole('USER')")
                .antMatchers("/admin/**").access("hasRole('ADMIN')")
//                .antMatchers("/dba/**").access("hasRole('ADMIN') and hasRole('DBA')")
//                .and()
//                .formLogin().successHandler(customSuccessHandler)
//                .usernameParameter("ssoId").passwordParameter("password")
//                .and().csrf()
//                .and().exceptionHandling().accessDeniedPage("/Access_Denied")
//                .authorizeRequests().antMatchers("/**").hasRole("USER")


                .and()
                .formLogin()
                .loginPage("/loginForm").usernameParameter("email").passwordParameter("password")
                .failureUrl("/login-error")
                .loginProcessingUrl("/do_login")
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .and().exceptionHandling()
                .accessDeniedPage("/accessDenied")
                .and().csrf().disable()

        ;
    }
}

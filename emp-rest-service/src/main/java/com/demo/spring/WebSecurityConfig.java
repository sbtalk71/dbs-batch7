/*
 * package com.demo.spring;
 * 
 * import javax.sql.DataSource;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class WebSecurityConfig extends
 * WebSecurityConfigurerAdapter{
 * 
 * @Autowired DataSource ds;
 * 
 * public WebSecurityConfig() { System.out.println("Security Config loaded...");
 * }
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * http.authorizeRequests()
 * .antMatchers("/emp/**").hasRole("USER").and().httpBasic().and().csrf().
 * disable(); }
 * 
 * 
 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
 * throws Throwable{
 * 
 * auth.inMemoryAuthentication().withUser("shantanu").password(encoder().encode(
 * "welcome1")).roles("USER");
 * auth.inMemoryAuthentication().withUser("pavan").password(encoder().encode(
 * "welcome1")).roles("MANAGER");
 * auth.inMemoryAuthentication().withUser("pretham").password(encoder().encode(
 * "welcome1")).roles("USER").disabled(true); }
 * 
 * 
 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
 * throws Throwable{ auth.jdbcAuthentication().dataSource(ds)
 * .usersByUsernameQuery("select username,password,enabled from users where username=?"
 * )
 * .authoritiesByUsernameQuery("select username,authority from authorities where username=?"
 * );
 * 
 * }
 * 
 * @Bean public BCryptPasswordEncoder encoder() {
 * System.out.println("Password Encoder Created..."); return new
 * BCryptPasswordEncoder(); } }
 */
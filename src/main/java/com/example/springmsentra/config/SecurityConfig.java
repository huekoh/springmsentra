package com.example.springmsentra.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration(proxyBeanMethods = false)
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final ClientRegistrationRepository clientRegistrationRepository;
    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    public SecurityConfig(ClientRegistrationRepository clientRegistrationRepository, CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler) {
        this.clientRegistrationRepository = clientRegistrationRepository;
        this.customAuthenticationSuccessHandler = customAuthenticationSuccessHandler;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .oauth2Login(oauth2 -> oauth2
                        .authorizationEndpoint(authorization -> authorization
                                .baseUri("/login/oauth2/authorize")
                        )
                        .redirectionEndpoint(redirection -> redirection
                                .baseUri("/login/oauth2/code/")
                        )
                        .clientRegistrationRepository(clientRegistrationRepository)
                        .userInfoEndpoint(userInfo -> userInfo
                                .oidcUserService(oidcUserService()) // Use custom OidcUserService
                        )
                        //.successHandler(customAuthenticationSuccessHandler) // Set custom success handler
                )
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/login/**").permitAll()
                        .requestMatchers("/admin/**").hasRole("Admin")
                        .requestMatchers("/user/**").hasAnyRole("User", "Admin")
                        .anyRequest().authenticated()
                )
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    private OidcUserService oidcUserService() {
        OidcUserService delegate = new OidcUserService();
        return new OidcUserService() {
            @Override
            public OidcUser loadUser(OidcUserRequest userRequest) {
                OidcUser oidcUser = delegate.loadUser(userRequest);
                Set<GrantedAuthority> mappedAuthorities = new HashSet<>();

                List<String> groups = oidcUser.getClaimAsStringList("groups");
                if (groups != null) {
                    groups.forEach(group -> {
                        if (group.equals("sample.admin")) {
                            mappedAuthorities.add(new SimpleGrantedAuthority("ROLE_Admin"));
                        } else if (group.equals("sample.user")) {
                            mappedAuthorities.add(new SimpleGrantedAuthority("ROLE_User"));
                        }
                    });
                }

                // Log groups and mapped authorities
                System.out.println("Groups: " + groups);
                System.out.println("Mapped Authorities: " + mappedAuthorities);

                // Return a new OIDC user with mapped authorities
                return new DefaultOidcUser(mappedAuthorities, oidcUser.getIdToken(), oidcUser.getUserInfo());
            }
        };
    }


}
package br.com.devmedia.curso.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// Sistema ira buscar toda a configuacao com base nesse pacote
@Configuration
@ComponentScan("br.com.devmedia.curso")
@EnableWebMvc
public class RootConfig {

}

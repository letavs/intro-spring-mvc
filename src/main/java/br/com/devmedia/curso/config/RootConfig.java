package br.com.devmedia.curso.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("br.com.devmedia.curso")// Sistema ira buscar toda a configuacao com base nesse pacote
@EnableWebMvc
public class RootConfig {

}

package br.com.devmedia.curso.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// Sistema ira buscar toda a configuacao com base nesse pacote
@Configuration
@ComponentScan(basePackages = {"br.com.devmedia.curso"}, excludeFilters= {@Filter(type =FilterType.ANNOTATION, value = Configuration.class)})
@EnableWebMvc
public class RootConfig {

}

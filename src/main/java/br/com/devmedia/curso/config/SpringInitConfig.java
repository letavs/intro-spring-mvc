package br.com.devmedia.curso.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// Quando o servidor iniciado, essa sera a primeira classe a ser acessada.
		return new Class[] {RootConfig.class};
	}

	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Aqui indicamos qual sera sera a resposavel por ter a confirmacao do Spring MVC
		return new Class[] {SpringInitConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// Toda vez que o cliente acessar a url / a apo sabera que esta lidando com um servelt
		return new String [] {"/"};
	}
}

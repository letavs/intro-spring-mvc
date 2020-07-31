package br.com.devmedia.curso.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	/* Quando o servidor iniciado, getRootConfigClasses sera a primeira classe a ser acessada.
	 * e redirecionara para a nova classe RootConfig.
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class};
	}

	// Aqui indicamos qual sera a classe responsavel por ter a confirmacao do Spring MVC
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {SpringInitConfig.class};
	}

	// Toda vez que o cliente acessar a url / a app sabera que esta lidando com um servelt
	@Override
	protected String[] getServletMappings() {
		return new String [] {"/"};
	}
}

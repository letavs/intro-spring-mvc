package br.com.devmedia.curso.dao;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.devmedia.curso.domain.Usuario;

@Repository  // ou anotacao @Component
public class UsuarioDaoImpl implements UsuarioDao {

	private static List<Usuario> lista;

	public UsuarioDaoImpl() {
		criarListaUsuarios();
	}

	private List<Usuario> criarListaUsuarios() {
		if (lista == null) {
			lista = new LinkedList<>();
			lista.add(new Usuario(System.currentTimeMillis() + 1L, "Leandro", "da Silva", LocalDate.of(1992, 5, 10)));
			lista.add(new Usuario(System.currentTimeMillis() + 2L, "Solange", "Batista", LocalDate.of(1984, 2, 9)));
			lista.add(new Usuario(System.currentTimeMillis() + 3L, "Fernando", "Batista", LocalDate.of(2015, 9, 9)));
			lista.add(new Usuario(System.currentTimeMillis() + 4L, "Vinicius", "Lucca"));
			lista.add(new Usuario(System.currentTimeMillis() + 5L, "Antonio", "da Silva"));
			lista.add(new Usuario(System.currentTimeMillis() + 6L, "Mirtes", "Pereira"));
		}
		return lista;
	}

	@Override
	public void salvar(Usuario usuario) {
		// O id sera setado no momento da executa com CurrentTimeMillis(Java 7) e a
		// Lista adiciona o usuario
		usuario.setId(System.currentTimeMillis());
		lista.add(usuario);
	}

	@Override
	public void editar(Usuario usuario) {
		//  Java8 Lambda
		lista.stream()
			.filter(u -> u.getId().equals(usuario.getId())) // pega o id e compara com usuario
			.forEach(u -> { // o forech ira localizar o usuario retornado do filter 
			u.setNome(usuario.getNome()); // os set ira modificar os nomes e sobrenome
			u.setSobrenome(usuario.getSobrenome());
			u.setDtNascimento(usuario.getDtNascimento());
		});
	}

	@Override
	public void excluir(Long id) {
		// O Lambda ira encontrar o id comparando com o id de referencia. 
		lista.removeIf(u -> u.getId().equals(id));//O metodo removeif se encarregara de remover 

	}

	@Override
	public Usuario getId(Long id) {
	
		return lista.stream()
				.filter(u -> u.getId().equals(id))// filter ira comparar com o id do paramento
				.collect(Collectors.toList())// collect ira coletar o objeto da lista
				.get(0);
	}

	@Override
	public List<Usuario> getLista() {

		return lista;
	}
}

package br.com.devmedia.curso.domain;

public enum TipoSexo {
	FEMININO('F'), MASCULINO('M');

	private char descricao;
	
	TipoSexo(char desc) {
		this.descricao = desc;
	}

	public char getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}

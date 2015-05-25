package br.com.projetoescola.tipo;

public enum TipoPerfil implements Tipo {
	ALUNO,
	DOCENTE,
	SECRETARIA,
	ADMINISTADOR;
	
	public String getDescricao() {
		return TipoUtils.getDescricao(this);
	}

	@Override
	public String toString() {
		return getDescricao();
	}
	

}

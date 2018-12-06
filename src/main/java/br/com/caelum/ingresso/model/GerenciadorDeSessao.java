package br.com.caelum.ingresso.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

public class GerenciadorDeSessao {
	private List<Sessao> sessoesDaSala;

	public GerenciadorDeSessao(List<Sessao> sessoesDaSala) {
		this.sessoesDaSala = sessoesDaSala;
	}

	public boolean cabe(Sessao sessaoNova) {
		Stream<Sessao> stream = sessoesDaSala.stream();
			 return sessoesDaSala.stream().noneMatch(sessaoExistente -> horarioIsConflitante(sessaoExistente, sessaoNova));

	}

	private boolean horarioIsConflitante(Sessao sessaoExistente, Sessao sessaoNova) {
		LocalDate hoje = LocalDate.now();
		LocalDateTime horarioSessaoExistente = sessaoExistente.getHorario().atDate(hoje);
		LocalDateTime horarioSessaoNova = sessaoNova.getHorario().atDate(hoje);
		boolean terminaAntes = sessaoNova.getHorarioTermino().atDate(hoje).isBefore(horarioSessaoExistente);
		boolean comecaDepois = sessaoExistente.getHorarioTermino().atDate(hoje).isBefore(horarioSessaoNova);
		if (terminaAntes || comecaDepois) {
			return false;
		}
		return false;
	}
}

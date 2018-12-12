package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ingresso {
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne
	private Sessao sessao;
	private BigDecimal preco;
	@ManyToOne
	private Lugar lugar;
	@Enumerated(EnumType.STRING)
	private TipoIngresso tipoDeIngresso;

	public Ingresso() {

	}

	public Ingresso(Sessao sessao, TipoIngresso tipoIngresso, Lugar lugar) {
		this.setSessao(sessao);
		this.tipoDeIngresso = tipoIngresso;
		this.preco = this.tipoDeIngresso.aplicaDesconto(sessao.getPreco());
		this.setLugar(lugar);

	}

	public BigDecimal getPreco() {
		return preco.setScale(2, RoundingMode.HALF_UP);
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public TipoIngresso getTipoDeIngresso() {
		return tipoDeIngresso;
	}

	public void setTipoDeIngresso(TipoIngresso tipoIngresso) {
		this.tipoDeIngresso = tipoIngresso;
	}

}

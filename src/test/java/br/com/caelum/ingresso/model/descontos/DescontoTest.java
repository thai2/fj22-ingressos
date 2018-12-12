package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Lugar;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.TipoIngresso;

public class DescontoTest {
	@Test
	public void naoDeveConcederDescontoParaIngressoNormal() {
		Lugar lugar = new Lugar("A",1);
		Sala sala = new Sala("ElDourado - IMax", new BigDecimal("20.5"));
		Filme filme = new Filme("Rogue one", Duration.ofMinutes(120), "SCI_FI", new BigDecimal("12"));
		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
		Ingresso ingresso = new Ingresso(sessao , TipoIngresso.INTEIRO, lugar);
		BigDecimal precoEsperado = new BigDecimal("32.50");
		Assert.assertEquals(precoEsperado,ingresso.getPreco());
	}

	@Test
	public void naoDeveConcederDescontoParaIngressoEstudantel() {
		Lugar lugar = new Lugar("A",1);
		Sala sala = new Sala("ElDourado - IMax", new BigDecimal("20.0"));
		Filme filme = new Filme("Rogue one", Duration.ofMinutes(120), "SCI_FI", new BigDecimal("12"));
		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
		Ingresso ingresso = new Ingresso(sessao , TipoIngresso.ESTUDANTE, lugar);
		BigDecimal precoEsperado = new BigDecimal("16.00");
		System.out.println(ingresso.getPreco());
		Assert.assertEquals(precoEsperado,ingresso.getPreco());
	}
	@Test
	public void naoDeveConcederDescontoParaIngressoBanco() {
		Lugar lugar = new Lugar("A",1);
		Sala sala = new Sala("ElDourado - IMax", new BigDecimal("20.0"));
		Filme filme = new Filme("Rogue one", Duration.ofMinutes(120), "SCI_FI", new BigDecimal("12"));
		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
		Ingresso ingresso = new Ingresso(sessao , TipoIngresso.BANCO, lugar);
		BigDecimal precoEsperado = new BigDecimal("22.40");
		System.out.println(ingresso.getPreco());
		Assert.assertEquals(precoEsperado,ingresso.getPreco());
	}
}

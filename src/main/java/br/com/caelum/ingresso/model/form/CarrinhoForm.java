package br.com.caelum.ingresso.model.form;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.caelum.ingresso.dao.LugarDao;
import br.com.caelum.ingresso.dao.SessaoDao;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Lugar;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.TipoIngresso;

public class CarrinhoForm {
	private List<Ingresso> ingressos = new ArrayList<>();

	public List<Ingresso> toIngressos(SessaoDao sessaoDao, LugarDao lugarDao) {
		return this.ingressos.stream().map(ingresso -> {
			Sessao sessao = sessaoDao.findOne(ingresso.getSessao().getId());
			
			System.out.println(sessao.getPreco());
			
			Lugar lugar = lugarDao.findOne(ingresso.getLugar().getId());
			TipoIngresso tipoIngresso = ingresso.getTipoDeIngresso();
			
			System.out.println(tipoIngresso);
			
			return new Ingresso(sessao, tipoIngresso, lugar);
		}).collect(Collectors.toList());
	}

	public List<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}

}

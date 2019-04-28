package br.com.romulo.conceito.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.romulo.conceito.domain.PagamentoComBoleto;
import br.com.romulo.conceito.domain.PagamentoComCartao;
import br.com.romulo.conceito.repositories.PagamentoComBoletoRepository;
import br.com.romulo.conceito.repositories.PagamentoComCartaoRepository;
import br.com.romulo.conceito.services.expcetion.ObjetoNaoLocalizado;

@Service
public class PagamentoService {
	
	@Autowired
	private PagamentoComBoletoRepository pagamentoComBoletoRepository;
	
	@Autowired
	private PagamentoComCartaoRepository pagamentoComCartaoRepository;
	
	 public PagamentoComCartao buscarPagamentoComCartaoPorID(Integer idPagamento){
		 	Optional<PagamentoComCartao> obj = pagamentoComCartaoRepository.findById(idPagamento);
			return obj.orElseThrow(()-> new ObjetoNaoLocalizado());
	 }
	 
	 public PagamentoComBoleto  buscarPagamentoComBoletoPorID(Integer idPagamento){
		 	Optional<PagamentoComBoleto> obj = pagamentoComBoletoRepository.findById(idPagamento);
			return obj.orElseThrow(()-> new ObjetoNaoLocalizado());
	 }
	 
	 public List<PagamentoComCartao> listAllPagamentoComCartao(){
		 return pagamentoComCartaoRepository.findAll();
	 }
	 
	 public List<PagamentoComBoleto> listAllPagamentoComBoleto(){
		 return pagamentoComBoletoRepository.findAll();
	 }
}

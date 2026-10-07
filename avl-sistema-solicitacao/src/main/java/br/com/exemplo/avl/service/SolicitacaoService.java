package br.com.exemplo.avl.service;

import java.util.List;

import br.com.exemplo.avl.dto.SolicitacaoRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.exemplo.avl.model.Solicitacao;
import br.com.exemplo.avl.repository.SolicitacaoRepository;

@Service
public class SolicitacaoService {

    private SolicitacaoRepository repository;

    public SolicitacaoService(@Qualifier("arvoreAVLRepository") SolicitacaoRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(SolicitacaoRequest dto){
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setDescricao(dto.getDescricao());
        solicitacao.setDataHoraAbertura(dto.getDataHoraAbertura());
        solicitacao.setSolicitante(dto.getSolicitante());
        repository.save(solicitacao);
    }

    public String atualizarProduto(Solicitacao solicitacao, int numero) {
        Solicitacao solicitacaoExistente = repository.findById(numero)
                .orElseThrow(() -> new RuntimeException("Solicitação não registrada"));
        solicitacaoExistente.setSolicitante(solicitacao.getSolicitante());
        solicitacaoExistente.setDescricao(solicitacao.getDescricao());
       return "Dados atualizados!";
    }



    public Solicitacao buscar(int numero) {
        return repository.buscar(numero);
    }



    public boolean remover(int numero) {
        return repository.remover(numero);
    }

    public List<Solicitacao> listar() {
        return repository.listar();
    }

    public String exibirArvore() {
        return repository.exibirArvore();
    }
}

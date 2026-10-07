package br.com.exemplo.avl.repository;

import java.util.List;
import br.com.exemplo.avl.model.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Integer> {
    void inserir(Solicitacao solicitacao);

    Solicitacao buscar(int numero);

    boolean remover(int numero);

    List<Solicitacao> listar();

    String exibirArvore();
}

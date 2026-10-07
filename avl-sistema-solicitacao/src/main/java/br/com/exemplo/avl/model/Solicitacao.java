package br.com.exemplo.avl.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "solicitacao")
public class Solicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;
    private String solicitante;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime dataHoraAbertura;
    private String descricao;


    public Solicitacao(int numero, String descricao, String solicitante, LocalDateTime dataHoraAbertura) {
        this.numero = numero;
        this.descricao = descricao;
        this.solicitante = solicitante;
        this.dataHoraAbertura = dataHoraAbertura;
    }
    public Solicitacao() {

    }
    public LocalDateTime getDataHoraAbertura() {
        return dataHoraAbertura;
    }

    public void setDataHoraAbertura(LocalDateTime dataHoraAbertura) {
        this.dataHoraAbertura = dataHoraAbertura;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public int getNumero() {
        return numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    @Override
    public String toString() {
        return "Solicitacao{" +
                "numero=" + numero +
                ", solicitante='" + solicitante + '\'' +
                ", dataHoraAbertura=" + dataHoraAbertura +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}

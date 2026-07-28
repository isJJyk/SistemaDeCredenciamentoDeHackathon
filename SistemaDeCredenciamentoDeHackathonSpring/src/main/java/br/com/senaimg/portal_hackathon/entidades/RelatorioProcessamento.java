package br.com.senaimg.portal_hackathon.entidades;

public class RelatorioProcessamento extends Participante {

    private int quantidadeAprovados;
    private int quantidadeRejeitados;
    private String status;

    public RelatorioProcessamento(int quantidadeAprovados, int quantidadeRejeitados, String status) {
        super();
        this.quantidadeAprovados = quantidadeAprovados;
        this.quantidadeRejeitados = quantidadeRejeitados;
        this.status = status;
    }
    public String toString(){
        return  "Quantidade Aprovados: "+quantidadeAprovados+" Quantidade rejeitados: "+quantidadeRejeitados+" Status: "+status;
    }
}


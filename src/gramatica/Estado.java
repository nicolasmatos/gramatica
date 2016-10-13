package gramatica;

import java.util.ArrayList;

public class Estado {

    private boolean eNaoTerminal;
    private boolean eTerminal;

    private String representacao;

    private ArrayList<RegraProducao> regras;

    public Estado() { transicoes = new ArrayList<>(); }

    public Estado(boolean eInicial, boolean eFinal, String representacao, ArrayList<Transicao> transicoes) {
        this.eInicial = eInicial;
        this.eFinal = eFinal;
        this.representacao = representacao;
        this.transicoes = transicoes;
    }

    public boolean iseInicial() { return eInicial; }
    public void seteInicial(boolean eInicial) { this.eInicial = eInicial; }

    public ArrayList<Transicao> getTransicoes() { return transicoes; }
    public void setTransicoes(Transicao t) { this.transicoes.add(t); }

    public String getRepresentacao() { return representacao; }
    public void setRepresentacao(String representacao) { this.representacao = representacao; }

    public boolean iseFinal() { return eFinal; }
    public void seteFinal(boolean eFinal) { this.eFinal = eFinal; }
}

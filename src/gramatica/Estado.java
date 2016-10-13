package gramatica;

import java.util.ArrayList;

public class Estado {

    private boolean eTerminal;
    private boolean eNaoTerminal;

    private String representacao;

    private ArrayList<RegraProducao> regras;

    public Estado() { regras = new ArrayList<>(); }

    public Estado(boolean eNaoTerminal, boolean eTerminal, String representacao, ArrayList<RegraProducao> regras) {
        this.eTerminal = eTerminal;
        this.eNaoTerminal = eNaoTerminal;
        this.representacao = representacao;
        this.regras = regras;
    }

    public boolean iseTerminal() { return eTerminal; }
    public void seteTerminal(boolean eTerminal) { this.eTerminal = eTerminal; }

    public boolean iseNaoTerminal() { return eNaoTerminal; }
    public void seteNaoTerminal(boolean eNaoTerminal) { this.eNaoTerminal = eNaoTerminal; }

    public ArrayList<RegraProducao> getRegras() { return regras; }
    public void setTransicoes(RegraProducao t) { this.regras.add(t); }

    public String getRepresentacao() { return representacao; }
    public void setRepresentacao(String representacao) { this.representacao = representacao; }
}

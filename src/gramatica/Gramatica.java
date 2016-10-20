package gramatica;

import java.util.ArrayList;

public class Gramatica {

    private boolean eIvalido;

    private int saida;

    private String txtAlfabetoT;
    private String txtAlfabetoNT;
    private String txtRegrasDeProducao;
    private String txtEntrada;
    private char[] entrada;
    private char[] p;

    private ArrayList<Estado> estados;

    public Gramatica() { }

    public Gramatica(String txtAlfabetoT, String txtAlfabetoNT, String txtRegrasDeProducao, String txtEntrada) {
        this.txtAlfabetoT = txtAlfabetoT;
        this.txtAlfabetoNT = txtAlfabetoNT;
        this.txtRegrasDeProducao = txtRegrasDeProducao;
        this.txtEntrada = txtEntrada;
        estados = new ArrayList<Estado>();
        entrada = txtEntrada.replace(",", "").toString().toCharArray();

        eIvalido = false;
        saida = 0;
    }

    /**
     * Verifica se a entrada recebida é válida
     */
    public boolean verificarEntrada() {
        boolean result = false;
        char[] alfabetoT = txtAlfabetoT.replace(",", "").toString().toCharArray();

        for (int i = 0; i < entrada.length; i++) {
            result = false;
            for (int j = 0; j < alfabetoT.length; j++) {
                if (entrada[i] == alfabetoT[j]) {
                    result = true;
                    j = alfabetoT.length;
                } else if (j + 1 == alfabetoT.length && result != true) {
                    i = entrada.length;
                }
            }
        }
        return result;
    }

    /**
     * Inicializa o array de estados Inicializa o array de transições
     * determinando as transições de cada estado Determina o estado inicial e o
     * conjunto de estados finais
     */
    public void setValores() {
        
        char[] alfabetoNT = txtAlfabetoNT.replace(",", "").toString().toCharArray();
        char[] alfabetoT = txtAlfabetoT.replace(",", "").toString().toCharArray();

        for (int i = 0; i < alfabetoT.length; i++) {
            Estado e = new Estado();
            e.seteTerminal(true);
            e.seteNaoTerminal(false);
            e.setRepresentacao(alfabetoT[i]);
            estados.add(e);
        }

        for (int i = 0; i < alfabetoNT.length; i++) {
            Estado e = new Estado();
            e.seteTerminal(false);
            e.seteNaoTerminal(true);
            e.setRepresentacao(alfabetoNT[i]);
            estados.add(e);
        }

        String[] txtProducoes = txtRegrasDeProducao.split(",");
        for (String txtEstado : txtProducoes) {
            Estado estadoAtual = null;
            for (Estado e : estados) {
                if (String.valueOf(e.getRepresentacao()).equals(txtEstado.substring(0, 1))) {
                    estadoAtual = e;
                    break;
                }
            }

            for (String regras : txtEstado.substring(2, txtEstado.length()).split("/")) {
                RegraProducao regra = new RegraProducao();
                for (char c : regras.toCharArray()) {
                    for (Estado e : estados) {
                        if (e.getRepresentacao() == c) {
                            regra.setSimbolos(e);
                            break;
                        }
                    }
                }
                estadoAtual.setRegras(regra);
            }
        }
        
        estados.stream().forEach((e) -> {
            if (e.iseTerminal()) {
                System.out.println(e.getRepresentacao());
            } else {
                String regras = new String();
                for (int j = 0; j < e.getRegras().size(); j++) {
                    for (int z = 0; z < e.getRegras().get(j).getSimbolos().size(); z++) {
                        regras = regras + e.getRegras().get(j).getSimbolos().get(z).getRepresentacao();
                    }
                    regras = regras + ", ";
                }
                regras = regras.substring(0, regras.length()-2);
                System.out.println("\n" + e.getRepresentacao() + " -> " + regras);
            }
        });
    }

    public int verificacao_rec(Estado e, String palavra) {
        int i = 0, j = 0;
        while(i < e.getRegras().size()){
            if (palavra.length() < entrada.length) {
                if (e.iseTerminal()) {
                    palavra = palavra + e.getRepresentacao();
                }
                else {

                    while (j < e.getRegras().get(i).getSimbolos().size()) {
                        Estado estadoAtual = e.getRegras().get(i).getSimbolos().get(j);

                        if (estadoAtual.iseTerminal()) {
                            palavra = palavra + e.getRegras().get(i).getSimbolos().get(j).getRepresentacao();
                        }
                        else {
                            verificacao_rec(estadoAtual, palavra);
                        }
                        j++;
                    }
                }
            }
            else if(palavra.length() == entrada.length) {
                int ctrl = 1;
                p = palavra.toCharArray();
                for(i = 0; i < p.length; i++) {
                    if(p[i] != entrada[i]){
                        ctrl = 0;
                    }
                }
                
                if(ctrl == 1) {
                    return 1;
                }
            }
            i++;
        }
        return 0;
    }

    /**
     * Verifica se a entrada leva a um estado final válido
     */
    public String verificacao() {        
        
        this.setValores();
        String resultado = "";
        String palavra = "";
        
        if(!this.verificarEntrada()) {
            return resultado+="Entrada inválida!";
        }
        
        int result = verificacao_rec(estados.get(0), palavra);
        
        return result == 1 ? "Aceitou" : "Não aceitou";
    }

}

package gramatica;

import java.util.ArrayList;

public class Gramatica {

    private boolean eIvalido;

    private int saida;

    private String txtAlfabetoT;
    private String txtAlfabetoNT;
    private String txtRegrasDeProducao;
    private String txtEntrada;
    private String[] entrada;

    private ArrayList<Estado> estados;

    public Gramatica() { }

    public Gramatica(String txtAlfabetoT, String txtAlfabetoNT, String txtRegrasDeProducao, String txtEntrada) {
        this.txtAlfabetoT = txtAlfabetoT;
        this.txtAlfabetoNT = txtAlfabetoNT;
        this.txtRegrasDeProducao = txtRegrasDeProducao;
        this.txtEntrada = txtEntrada;
        estados = new ArrayList<Estado>();
        entrada = txtEntrada.split(",");

        eIvalido = false;
        saida = 0;
    }

    /**
     * Verifica se a entrada recebida é válida
     */
    public boolean verificarEntrada() {
        boolean result = false;
        String[] alfabetoT = txtAlfabetoT.split(",");

        for (int i = 0; i < entrada.length; i++) {
            result = false;
            for (int j = 0; j < alfabetoT.length; j++) {
                if (entrada[i].equals(alfabetoT[j])) {
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

        char[] alfabetoT = txtAlfabetoT.replace(",", "").toString().toCharArray();
        char[] alfabetoNT = txtAlfabetoNT.replace(",", "").toString().toCharArray();

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
                estadoAtual.setTransicoes(regra);
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

    /**
     * Verifica se a entrada leva a um estado final válido
     */
    public String verificacao() {
        
        this.setValores();
        String resultado = "";
        
        if(!this.verificarEntrada()) {
            return resultado+="Entrada inválida!";
        }
        
        /*
        for(int i = 0; i < entrada.length; i++) {
            for(int j = 0; j < estadoAtual.getTransicoes().size(); j++) {
                resultado+="\nEstado atual: " + estadoAtual.getRepresentacao();
                resultado+="\nValor: " + estadoAtual.getTransicoes().get(j).getValor();
                resultado+="\nEntrada: " + entrada[i];
                if (estadoAtual.getTransicoes().get(j).getValor().equals(entrada[i])) {
                    estadoAtual = estadoAtual.getTransicoes().get(j).getEstadoDest();
                    j = estadoAtual.getTransicoes().size();
                }
                else if(j + 1 == estadoAtual.getTransicoes().size()) {
                    eIvalido = true;
                    i = entrada.length;
                }
                resultado+="\nEstado Destino: " + estadoAtual.getRepresentacao() + "\n";
            }
        }

        if (estadoAtual.iseFinal() && eIvalido != true) {
            saida = 1;
        }

        resultado+="\n" + (eIvalido ? "Estado invalido" : "Estado Final: " + estadoAtual.getRepresentacao());
        resultado+="\nSaida: " + saida;
        return resultado;
        */
        return "";
    }

}

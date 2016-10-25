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
        estados = new ArrayList<>();
        entrada = txtEntrada.replace(",", "").toCharArray();

        eIvalido = false;
        saida = 0;
    }

    /**
     * Verifica se a entrada recebida é válida
     *
     * @return
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

        for (int i = 0; i < alfabetoNT.length; i++) {
            Estado e = new Estado();
            e.seteTerminal(false);
            e.seteNaoTerminal(true);
            e.setRepresentacao(alfabetoNT[i]);
            estados.add(e);
        }

        for (int i = 0; i < alfabetoT.length; i++) {
            Estado e = new Estado();
            e.seteTerminal(true);
            e.seteNaoTerminal(false);
            e.setRepresentacao(alfabetoT[i]);
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

        /*estados.stream().forEach((e) -> {
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
                regras = regras.substring(0, regras.length() - 2);
                System.out.println("\n" + e.getRepresentacao() + " -> " + regras);
            }
        });*/
    }

    public boolean verificacao_rec(ArrayList<Estado> palavra) {
        if (palavra.size() == txtEntrada.length()) {
            if (repPalavra(palavra).equals(txtEntrada)) {
                return true;
            }
        }

        if (palavra.size() <= txtEntrada.length()) {
            for (int i = 0; i < palavra.size(); i++) {
                if (palavra.get(i).iseNaoTerminal()) {
                    for (RegraProducao r : palavra.get(i).getRegras()) {
                        ArrayList<Estado> p = (ArrayList<Estado>) palavra.clone();
                        p.remove(palavra.get(i));
                        for (int j = 0; j < r.getSimbolos().size(); j++) {
                            p.add(i + j, r.getSimbolos().get(j));
                        }

                        System.out.println(repPalavra(p));
                        if (verificacao_rec(p)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    /**
     * Verifica se a entrada leva a um estado final válido
     *
     * @return
     */
    public String verificacao() {

        this.setValores();
        String resultado = "";
        String palavra = "";
        palavra = "";
        boolean valido = false;

        if (!this.verificarEntrada()) {
            return resultado += "Entrada inválida!";
        }

        //System.out.println(estados.get(0).getRepresentacao());
        for (RegraProducao rp : estados.get(0).getRegras()) {
            if (verificacao_rec(rp.getSimbolos())) {
                valido = true;
                break;
            }
        }

        System.out.println("=========================================");
        //return result == 1 ? "Aceitou" : "Não aceitou";
        return valido ? "Entrada válida" : "Entrada inválida";
    }

    public String repPalavra(ArrayList<Estado> estados) {
        String palavra = "";

        for (Estado e : estados) {
            palavra += e.getRepresentacao();
        }

        return palavra;
    }

    public ArrayList<Estado> getEstadosNaoTerminais() {
        ArrayList<Estado> ent = new ArrayList<>();
        for(Estado e : estados){
            if(e.iseNaoTerminal()) ent.add(e);
        }
        
        return ent;
    }

}

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

    public Gramatica(){}

    public Gramatica(String txtAlfabetoT, String txtAlfabetoNT, String txtRegrasDeProducao, String txtEntrada) {
        this.txtAlfabetoT = txtAlfabetoT;
        this.txtAlfabetoNT = txtAlfabetoNT;
        this.txtRegrasDeProducao = txtRegrasDeProducao;
        this.txtEntrada = txtEntrada;

        eIvalido = false;
        saida = 0;
    }

    /**
     * Verifica se a entrada recebida é válida
     */
    public boolean verificarEntrada(){
        boolean result = false;
        String[] alfabetoT = txtAlfabetoT.split(",");

        for(int i = 0; i < entrada.length; i++) {
            result = false;
            for(int j = 0; j < alfabetoT.length; j++) {
                if(entrada[i].equals(alfabetoT[j])){
                    result = true;
                    j = alfabetoT.length;
                }
                else if (j + 1 == alfabetoT.length && result != true) {
                    i = entrada.length;
                }
            }
        }
        return result;
    }

    /**
     * Inicializa o array de estados
     * Inicializa o array de transições determinando as transições de cada estado
     * Determina o estado inicial e o conjunto de estados finais
     */
    public void setValores () {
        
        String[] alfabetoT = txtAlfabetoT.split(",");
        String[] alfabetoNT = txtAlfabetoNT.split(",");
        char[] regras = txtRegrasDeProducao.toCharArray(); 
        for (int i=0; i<regras.length; i++) {
            System.out.println(regras[i]+" ");
        }
    }

    /**
     * Verifica se a entrada leva a um estado final válido
     */
    public String verificacao() {
        /*
        this.setValores();
        String resultado = "";

        if(!this.verificarEntrada()) {
            return resultado+="Entrada inválida!";
        }

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
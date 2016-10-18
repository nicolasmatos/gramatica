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
        estados = new ArrayList<Estado>();

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
        
        char[] alfabetoT = new char[txtAlfabetoT.length()];
        char[] alfabetoNT = new char[txtAlfabetoNT.length()];
        
        for (int i = 0, j = 0; i < txtAlfabetoT.length(); i++) {
            if (txtAlfabetoT.charAt(i) != ',') {
                alfabetoT[j++] = txtAlfabetoT.charAt(i);
            }
        }
        
        for (int i = 0, j = 0; i < txtAlfabetoNT.length(); i++) {
            if (txtAlfabetoNT.charAt(i) != ',') {
                alfabetoNT[j++] = txtAlfabetoNT.charAt(i);
            }
        }
       
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
        
        char[] regras = new char[txtRegrasDeProducao.length()];
        
        for (int i = 0; i < txtRegrasDeProducao.length(); i++) {
            regras[i] = txtRegrasDeProducao.charAt(i);
        }
        
        for (int i = 0; i < regras.length; i++) {  
                System.out.println("1");
                if (regras[i] == ':') {
                int x = i + 1;
                for (int j = 0; j < estados.size(); j++) {
                    System.out.println("2");
                    if (regras[i+1] == estados.get(j).getRepresentacao()) {
                        while(regras[x] != ',' && regras[x - 1] != ',') {
                            System.out.println("3");
                            RegraProducao r = new RegraProducao();
                            while(regras[x] != '/' && regras[x] != ',') {
                                System.out.println("4");
                                for (int z = 0; z < estados.size(); z++) {
                                    System.out.println("5");
                                    if (regras[x] == estados.get(z).getRepresentacao()) {
                                        r.setSimbolos(estados.get(z));
                                        estados.get(i).setTransicoes(r);
                                    }
                                }
                                x++;
                            }
                            x++;
                        }
                    }
                }
            }
        }
        
        
        for (int i = 0; i < estados.size(); i++) {
            if (estados.get(i).iseTerminal()) {
                System.out.println(estados.get(i).getRepresentacao());
            }
            else {
                System.out.println(estados.get(i).getRepresentacao());
                System.out.println("Regras: ");
                for (int j = 0; j < estados.get(i).getRegras().size(); j++) {
                    for (int z = 0; z < estados.get(i).getRegras().get(j).getSimbolos().size(); z++) {
                        System.out.println(estados.get(i).getRegras().get(j).getSimbolos().get(z).getRepresentacao());
                    }
                    System.out.println("/");
                }
            }
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
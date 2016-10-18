package gramatica;

import java.util.ArrayList;

public class RegraProducao {
    private ArrayList<Estado> simbolos;
    
    public RegraProducao() { simbolos = new ArrayList<Estado>(); }

    public ArrayList<Estado> getSimbolos() { return simbolos; }
    public void setSimbolos(Estado e) { this.simbolos.add(e); }
   
}

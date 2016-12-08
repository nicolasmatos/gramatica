package gramatica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Desenho extends JPanel {

    int centroX = 230;
    int centroY = 230;
    int raio = 300;

    ArrayList<Estado> estados;

    private int getX(int i) {
        return (i % 2 == 0) ? 144 : 432;
    }

    private int getY(int i) {
        if (i == 0 || i == 1) {
            return 50;
        } else {
            return 50 + 300 * (i / 2);
        }
    }

    /**
     * Calcula x e y para indicar onde o estado será desenhado Chama
     * DesenharLinha Chama DesenharEstados Chama Legenda
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 20000, 20000);
        if (estados != null) {
            for (int i = 0; i < estados.size(); i++) {
                g.setColor(Color.RED);
                DesenharEstados(g, estados.get(i).getRepresentacao(),getX(i) - 20, getY(i));

                ArrayList<RegraProducao> rp = estados.get(i).getRegras();
                for (int j = 0; j < rp.size(); j++) {
                    double cosseno = Math.cos(Math.toRadians(60 + (90 * j / rp.size())));
                    double seno = Math.sin(Math.toRadians(60 + (90 * j / rp.size())));

                    int x = getX(i) - 20 + (int) (200 * cosseno);
                    int y = getY(i) + (int) (200 * seno);
                    
                    g.setColor(Color.BLACK);
                    g.setFont(new Font("Arial", Font.PLAIN, 16));
                    g.drawString(buscarRepresentacao(rp.get(j).getSimbolos()) + "", x , y + 15);
                    
                    
                    Linha(g, getX(i), getY(i), x, y);
                }
            }
        }
    }
    
    public String buscarRepresentacao(ArrayList<Estado> e) {
        String result = "";
        for (int i = 0; i < e.size(); i++) {
            result = result + e.get(i).getRepresentacao();
        }
        return result;
    }

    /**
     * Desenha um estado na janela
     *
     * @param g
     * @param representacao
     * @param x
     * @param y
     */
    private void DesenharEstados(Graphics g, char representacao, int x, int y) {
        g.setColor(Color.RED);
        g.fillOval(x, y, 40, 40);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString(representacao + "", x + 15, y + 25);
    }

    /**
     * Desenha as linhas de transição entre os estados
     *
     * @param g
     * @param inicio
     * @param destino
     */
    private void Linha(Graphics g, int xInicio, int yInicio, int xDestino, int yDestino) {
        g.setColor(Color.DARK_GRAY);
        g.drawLine(xInicio + 10, yInicio + 10, xDestino + 10, yDestino + 10);
    }

    public void setEstados(ArrayList<Estado> estados) {
        this.estados = estados;
    }

}

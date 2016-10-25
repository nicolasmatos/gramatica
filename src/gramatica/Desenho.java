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
     * Passa os parametros para desenhar as linhas de transição Chama Linha
     * Chama Arco Chama Desenhar Transições
     *
     * @param g
     */
    private void DesenharLinha(Graphics g) {
        /*if (estados != null) {
            for (int i = 1; i < estados.length; i++) {
                Estado e = estados[i];
                for (int j = 0; j < e.getTransicoes().size(); j++) {
                    Transicao t = e.getTransicoes().get(j);
                    if (e.equals(t.getEstadoDest())) {
                        Arco(g, Integer.parseInt(e.getRepresentacao()));
                    } else {
                        Linha(g, Integer.parseInt(e.getRepresentacao()), Integer.parseInt(t.getEstadoDest().getRepresentacao()));
                    }
                    DesenharTransicoes(g, Integer.parseInt(e.getRepresentacao()), Integer.parseInt(t.getEstadoDest().getRepresentacao()));
                }
            }
        }*/
    }

    /**
     * Desenha a representação das transições
     *
     * @param g
     * @param inicio
     * @param destino
     */
    private void DesenharTransicoes(Graphics g, int inicio, int destino) {
        String valor = "";
        /*for (int i = 0; i < estados[inicio].getTransicoes().size(); i++) {
            Transicao t = estados[inicio].getTransicoes().get(i);
            if (Integer.parseInt(t.getEstadoDest().getRepresentacao()) == destino) {
                valor = valor + t.getValor() + ", ";
            }
        }*/
        valor = valor.substring(0, valor.length() - 2);

        int xInicio, yInicio, xDestino, yDestino;

        double cossenoInicio = Math.cos(Math.toRadians(360 * inicio / estados.size()));
        double senoInicio = Math.sin(Math.toRadians(360 * inicio / estados.size()));

        double cossenoDestino = Math.cos(Math.toRadians(360 * destino / estados.size()));
        double senoDestino = Math.sin(Math.toRadians(360 * destino / estados.size()));

        xInicio = centroX + (int) (raio * cossenoInicio);
        yInicio = centroY + (int) (raio * senoInicio);

        xDestino = centroX + (int) (raio * cossenoDestino);
        yDestino = centroY + (int) (raio * senoDestino);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        g.drawString(inicio + "->" + destino + ": " + valor, xInicio + (int) ((xDestino - xInicio) * 0.25), yInicio + (int) ((yDestino - yInicio) * 0.25));
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

    /**
     * Desenha um arco de loop de um estado
     *
     * @param g
     * @param estado
     */
    private void Arco(Graphics g, int estado) {
        double cosseno = Math.cos(Math.toRadians(360 * estado / estados.size()));
        double seno = Math.sin(Math.toRadians(360 * estado / estados.size()));

        int x = centroX + (int) (raio * cosseno);
        int y = centroY + (int) (raio * seno);

        g.setColor(Color.DARK_GRAY);
        g.drawArc(x - 10, y - 30, 40, 40, 240, -300);
    }

    public void setEstados(ArrayList<Estado> estados) {
        this.estados = estados;
    }

}

package gramatica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Desenho extends JPanel {

    int centroX = 230;
    int centroY = 230;
    int raio = 100;

    ArrayList<Estado> estados;

    Color newGray = new Color(147, 145, 144);

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
                g.fillOval(getX(i) - 20, getY(i), 40, 40);

                ArrayList<RegraProducao> rp = estados.get(i).getRegras();
                for (int j = 0; j < rp.size(); j++) {
                    double cosseno = Math.cos(Math.toRadians(60 + (30 * j / estados.size())));
                    double seno = Math.sin(Math.toRadians(60 + (30 * j / estados.size())));

                    int x = getX(i) - 20 + (int) (200 * cosseno);
                    int y = getY(i) + (int) (200 * seno);

                    g.fillOval(x, y, 20, 20);
                    //g.setFont(new Font("Arial", Font.PLAIN, 12));
                    //g.drawString(representacao + "", x + ((representacao < 10) ? 6 : 3), y + 15);
                }
            }
        }

        /*g.setColor(Color.white);
        //DesenharLinha(g);
        
        g.setColor(Color.RED);
        g.fillOval(centroX, centroY, 40, 40);*/
 /*for (int i = 1; i < estados.size() + 1; i++) {

            double cosseno = Math.cos(Math.toRadians(45 + (90 * i / estados.size())));
            double seno = Math.sin(Math.toRadians(45 + (90 * i / estados.size())));

            int x = centroX + (int) (raio * cosseno);
            int y = centroY + (int) (raio * seno);

            DesenharEstados(g, i, x, y);
        }
        Legenda(g, 10, 10);*/
    }

    /**
     * Desenha um estado na janela
     *
     * @param g
     * @param representacao
     * @param x
     * @param y
     */
    private void DesenharEstados(Graphics g, int representacao, int x, int y) {
        g.fillOval(x, y, 20, 20);
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        g.drawString(representacao + "", x + ((representacao < 10) ? 6 : 3), y + 15);
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
    private void Linha(Graphics g, int inicio, int destino) {
        int xInicio, yInicio, xDestino, yDestino;

        double cossenoInicio = Math.cos(Math.toRadians(360 * inicio / estados.size()));
        double senoInicio = Math.sin(Math.toRadians(360 * inicio / estados.size()));

        double cossenoDestino = Math.cos(Math.toRadians(360 * destino / estados.size()));
        double senoDestino = Math.sin(Math.toRadians(360 * destino / estados.size()));

        xInicio = centroX + (int) (raio * cossenoInicio);
        yInicio = centroY + (int) (raio * senoInicio);

        xDestino = centroX + (int) (raio * cossenoDestino);
        yDestino = centroY + (int) (raio * senoDestino);

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

    /**
     * Desenha a legenda do autômato na janela
     *
     * @param g
     * @param x
     * @param y
     */
    private void Legenda(Graphics g, int x, int y) {
        g.setColor(newGray);
        g.fillRect(x + 2, y, 18, 18);
        g.setColor(Color.WHITE);
        g.drawString("1", x + 7, y + 14);
        g.setColor(Color.BLACK);
        g.drawString("Texto Branco -> Estado Inicial", x + 25, y + 14);
        g.setColor(newGray);
        g.fillOval(x, y + 25, 20, 20);
        g.setColor(Color.BLACK);
        g.drawString("Estados", x + 25, y + 40);
        g.setColor(Color.RED);
        g.fillOval(x, y + 50, 20, 20);
        g.setColor(Color.BLACK);
        g.drawString("Estados Finais", x + 25, y + 65);

    }

    public void setEstados(ArrayList<Estado> estados) {
        this.estados = estados;
    }

}

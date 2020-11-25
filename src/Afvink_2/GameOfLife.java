package Afvink_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOfLife extends JFrame implements ActionListener {
    private JPanel paper;
    int[][] table = new int[10][10];

    public static void main(String[] args) {
        GameOfLife frame = new GameOfLife();
        frame.setSize(600, 600);
        frame.createGui();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void createGui() {
        /**
        De java GUI wordt gemaakt. Er is een start button om het spel
         te starten en een exit button om de GUI af te sluiten.
         */
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        JButton start_button = new JButton("Start");
        window.add(start_button);
        start_button.addActionListener(this);

        JButton stop_button = new JButton("Exit");
        window.add(stop_button);
        stop_button.addActionListener(this);

        paper = new JPanel();
        paper.setPreferredSize(new Dimension(500, 500));
        paper.setBackground(Color.white);
        window.add(paper);
        paper.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * De vakjes worden weergegeven en er wordt gezorgd dat het
         * algoritme 50 keer wordt herhaald.
         */
        NextGeneration nextgen = new NextGeneration();
        Graphics tekenveld = paper.getGraphics();
        table[0][0] = 1;
        table[1][1] = 1;
        table[1][0] = 1;
        table[0][1] = 1;

        table[6][7] = 1;
        table[8][8] = 1;
        table[7][7] = 1;
        table[8][7] = 1;
        table[9][7] = 1;
        table[7][9] = 1;

        table[4][6] = 1;
        table[5][6] = 1;
        table[3][7] = 1;

        table[0][7] = 1;
        table[0][9] = 1;
        table[1][8] = 1;
        table[2][7] = 1;
        table[2][9] = 1;

        switch (e.getActionCommand()) {
            case "Start" -> {
                //                System.out.println("Start");
                for (int x = 0; x < 50; x++) {
//                    System.out.println("while");
                    for (int i = 0; i < 10; i++) {
                        for (int k = 0; k < 10; k++) {
                            if (table[i][k] == 1) {
                                tekenveld.setColor(Color.BLACK);
                            } else {
                                tekenveld.setColor(Color.white);
                            }
                            tekenveld.fillRect(i * 50, k * 50, 50, 50);
                        }
                    }
                    table = nextgen.GetNext(table);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
            }
            case "Exit" -> {
//                System.out.println("Exit");
                this.dispose();
            }
        }
    }

    public static class NextGeneration {
        /**
         * Hier wordt ervoor gezorgd dat de juiste cellen blijven
         * leven.
         * @param table: hier wordt bepaald welke cellen blijven
         *             leven en welke als het ware dood gaan.
         * @return next_table: deze tabel wordt gebruikt in
         * ActionPerformed en deze wordt vervolgens 50 keer herhaald.
         */
        public int[][] GetNext(int[][] table) {
            int[][] next_table = new int[10][10];
            int s = 0;
            for (int i = 0; i < 10; i++) {
                for (int k = 0; k < 10; k++) {
                    if (i == 0 && k == 0) {
                        s = table[i + 1][k] + table[i][k + 1] + table[i + 1][k + 1];
                    } else if (i == 9 && k == 0) {
                        s = table[i - 1][k] + table[i][k + 1] + table[i - 1][k + 1];
                    } else if (i == 0 && k == 9) {
                        s = table[i + 1][k] + table[i][k - 1] + table[i + 1][k - 1];
                    } else if (i == 9 && k == 9) {
                        s = table[i - 1][k] + table[i][k - 1] + table[i - 1][k - 1];
                    } else if (i == 0) {
                        s = table[i][k - 1] + table[i + 1][k - 1] +
                                table[i + 1][k] +
                                table[i][k + 1] + table[i + 1][k + 1];
                    } else if (i == 9) {
                        s = table[i - 1][k - 1] + table[i][k - 1] +
                                table[i - 1][k] +
                                table[i - 1][k + 1] + table[i][k + 1];
                    } else if (k == 0) {
                        s = table[i - 1][k] + table[i + 1][k] +
                                table[i - 1][k + 1] + table[i][k + 1] + table[i + 1][k + 1];
                    } else if (k == 9) {
                        s = table[i - 1][k - 1] + table[i][k - 1] + table[i + 1][k - 1] +
                                table[i - 1][k] + table[i + 1][k];
                    } else {
                        s = table[i - 1][k - 1] + table[i][k - 1] + table[i + 1][k - 1] +
                                table[i - 1][k] + table[i + 1][k] +
                                table[i - 1][k + 1] + table[i][k + 1] + table[i + 1][k + 1];
                    }
                    if (table[i][k] == 1) {
                        if (s == 2 || s == 3) {
                            next_table[i][k] = 1;
                        } else {
                            next_table[i][k] = 0;
                        }
                    } else {
                        if (s == 3) {
                            next_table[i][k] = 1;
                        }
                    }
                }
            }
            return next_table;
        }
    }
}
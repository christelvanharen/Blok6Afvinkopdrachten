package Afvink_5;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneFinder extends JFrame implements ActionListener {
    private JTextArea textveld1;
    private JScrollPane scrol1;
    private JTextArea textveld2;
    private JScrollPane scrol2;
    private JTextArea textveld3;
    private JScrollPane scrol3;
    private JComboBox drop;
    private JButton check;
    private JTextArea uitkomst;
    private JScrollPane scrol4;

    public static void main(String[] args) throws InterruptedException {
        GeneFinder frame = new GeneFinder();
        frame.setSize(600, 600);
        frame.createGui();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void createGui() throws InterruptedException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        textveld1 = new JTextArea(10, 15);
        window.add(textveld1);

        scrol1 = new JScrollPane(textveld1);
        scrol1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        window.add(scrol1);

        textveld2 = new JTextArea(10, 15);
        window.add(textveld2);

        scrol2 = new JScrollPane(textveld2);
        scrol2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        window.add(scrol2);

        textveld3 = new JTextArea(10, 15);
        window.add(textveld3);

        scrol3 = new JScrollPane(textveld3);
        scrol3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        window.add(scrol3);

        String[] opties = {"Overeenkomsten 1&2&3", "Overeenkomsten 1&2", "Overeenkomsten 1&3", "Overeenkomsten 2&3"};
        drop = new JComboBox(opties);
        window.add(drop);
        drop.addActionListener(this);

        check = new JButton("Check overeenkomst");
        window.add(check);
        check.addActionListener(this);

        uitkomst = new JTextArea(15, 45);
        window.add(uitkomst);

        scrol4 = new JScrollPane(uitkomst);
        scrol4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        window.add(scrol4);
    }

    public void actionPerformed(ActionEvent event) {
        String text1 = textveld1.getText();
        String[] genen_1 = text1.split("\n");

        Set<String> genen1 = new HashSet<>(Arrays.asList(genen_1));

        String text2 = textveld2.getText();
        String[] genen_2 = text2.split("\n");

        Set<String> genen2 = new HashSet<>(Arrays.asList(genen_2));

        String text3 = textveld3.getText();
        String[] genen_3 = text3.split("\n");

        Set<String> genen3 = new HashSet<>(Arrays.asList(genen_3));

        switch (drop.getSelectedIndex()) {
            case 0 -> {
                genen1.retainAll(genen2);
                genen1.retainAll(genen3);
                String st = new String(String.valueOf(genen1));
                st = st.replace("[", "").replace("]", "");
                st = st.replaceAll(", ", "\n");
                uitkomst.setText(st);
            }
            case 1 -> {
                genen1.retainAll(genen2);
                String st = new String(String.valueOf(genen1));
                st = st.replace("[", "").replace("]", "");
                st = st.replaceAll(", ", "\n");
                uitkomst.setText(st);
            }
            case 2 -> {
                genen1.retainAll(genen3);
                String st = new String(String.valueOf(genen1));
                st = st.replace("[", "").replace("]", "");
                st = st.replaceAll(", ", "\n");
                uitkomst.setText(st);
            }
            case 3 -> {
                genen2.retainAll(genen3);
                String st = new String(String.valueOf(genen2));
                st = st.replace("[", "").replace("]", "");
                st = st.replaceAll(", ", "\n");
                uitkomst.setText(st);
            }
        }
    }
}

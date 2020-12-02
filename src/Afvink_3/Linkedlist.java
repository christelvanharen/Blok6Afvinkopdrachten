package Afvink_3;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Linkedlist {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException |
                InstantiationException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }

        Linkedlist linkedLists = new Linkedlist();
        String bestand = "C:\\Users\\cvanh\\IdeaProjects\\Blok6Afvinkopdrachten\\src\\Afvink_3\\Homo_sapiens.gene_info";
        ArrayList<String[]> geneInfoList = linkedLists.readFile(bestand);

        geneInfoList.remove(0);

        Scanner askListType = new Scanner(System.in);
        System.out.println("Arraylist or LinkedList?");
        String listType = askListType.nextLine();

        boolean arrayList;
        if (listType.toLowerCase().equals("arraylist")) {
            arrayList = true;
        } else if (listType.toLowerCase().equals("linkedlist")) {
            arrayList = false;
        } else {
            System.out.println("ArrayList or LinkedList");
            arrayList = true;
        }

        int lenList = 100;
        ArrayList<String[]> geneInfo = new ArrayList<>();
        for (int i = 0; i < lenList; i++) {
            geneInfo.add(geneInfoList.get(i));
        }

        ArrayList<String> chrList = linkedLists.makeChrList(geneInfo);

        // Als er gekozen wordt voor een ArrayList
        if (arrayList){
            ArrayList<ArrayList<String[]>> orderedList = linkedLists.makeOrderedArrayList(chrList, geneInfo);


            // Print de geordende lijst met genen per chromosoom
            for (ArrayList<String[]> geneList : orderedList) {
                System.out.println("Chromosome " + geneList.get(0)[6]);
                for (String[] gene : geneList) {
                    System.out.println(Arrays.toString(gene));
                }
            }
        } else {
            LinkedList<LinkedList<String[]>> orderedList = linkedLists.makeOrderedLinkedList(chrList, geneInfo);

            for (LinkedList<String[]> geneList : orderedList) {
                System.out.println("Chromosome " + geneList.get(0)[6]);
                for (String[] gene : geneList) {
                    System.out.println(Arrays.toString(gene));
                }
            }
            System.out.println(Arrays.toString(orderedList.get(16).get(2)));
        }
    }

    public ArrayList<String[]> readFile(String bestand) {
        ArrayList<String[]> list = new ArrayList<>();
        try {
            BufferedReader inFile = new BufferedReader(new FileReader(bestand));
            String line;
            while ((line = inFile.readLine()) != null) {
                // Voeg iedere regel in het bestand toe aan de ArrayList
                list.add(line.split("\t"));
            }
            inFile.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "File Error: " + e.toString());
        }
        return list;
    }

    public ArrayList<String> makeChrList(ArrayList<String[]> geneInfo) {
        ArrayList<String> chrList = new ArrayList<>();
        for (String[] gene : geneInfo) {
            if (!chrList.contains(gene[6])) {
                chrList.add(gene[6]);
            }
        }
        return chrList;
    }

    public ArrayList<ArrayList<String[]>> makeOrderedArrayList(ArrayList<String> chrList,
                                                               ArrayList<String[]> geneInfo) {
        ArrayList<ArrayList<String[]>> orderedList = new ArrayList<>();
        for (int i = 0; i < chrList.size(); i++) {
            orderedList.add(new ArrayList<>());
        }
        for (String[] gene : geneInfo) {
            for (int i = 0; i < chrList.size(); i++) {
                if (gene[6].equals(chrList.get(i))) {
                    orderedList.get(chrList.indexOf(chrList.get(i))).add(gene);
                }
            }
        }
        return orderedList;
    }

    public LinkedList<LinkedList<String[]>> makeOrderedLinkedList(ArrayList<String> chrList,
                                                                  ArrayList<String[]> geneInfo) {
        LinkedList<LinkedList<String[]>> orderedList = new LinkedList<>();
        for (int i = 0; i < chrList.size(); i++) {
            orderedList.add(new LinkedList<>());
        }

        for (String[] gene : geneInfo) {
            for (int i = 0; i < chrList.size(); i++) {
                if (gene[6].equals(chrList.get(i))) {
                    orderedList.get(chrList.indexOf(chrList.get(i))).add(gene);
                }
            }
        }
        return orderedList;
    }

}
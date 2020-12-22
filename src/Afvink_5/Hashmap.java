package Afvink_5;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Hashmap {
    public static void main(String[] args) {
        HashMap<String, String> volledig_afkorting = new HashMap<String, String>();

        volledig_afkorting.put("Alanine", "Ala");
        volledig_afkorting.put("Arginine", "Arg");
        volledig_afkorting.put("Asparagine", "Asn");
        volledig_afkorting.put("Asparaginezuur", "Asp");
        volledig_afkorting.put("Cysteïne", "Cys");
        volledig_afkorting.put("Fenylalanine", "Phe");
        volledig_afkorting.put("Glutamine", "Gln");
        volledig_afkorting.put("Glutaminezuur", "Glu");
        volledig_afkorting.put("Glycine", "Gly");
        volledig_afkorting.put("Histidine", "His");
        volledig_afkorting.put("Isoleucine", "Ile");
        volledig_afkorting.put("Leucine", "Leu");
        volledig_afkorting.put("Lysine", "Lys");
        volledig_afkorting.put("Methionine", "Met");
        volledig_afkorting.put("Proline", "Pro");
        volledig_afkorting.put("Serine", "Ser");
        volledig_afkorting.put("Threonine", "Thr");
        volledig_afkorting.put("Tryptofaan", "Trp");
        volledig_afkorting.put("Tyrosine", "Tyr");
        volledig_afkorting.put("Valine", "Val");

        HashMap<String, String> afkorting_letter = new HashMap<String, String>();

        afkorting_letter.put("Ala", "A");
        afkorting_letter.put("Arg", "R");
        afkorting_letter.put("Asn", "N");
        afkorting_letter.put("Asp", "D");
        afkorting_letter.put("Cys", "C");
        afkorting_letter.put("Phe", "F");
        afkorting_letter.put("Gln", "Q");
        afkorting_letter.put("Glu", "E");
        afkorting_letter.put("Gly", "G");
        afkorting_letter.put("His", "H");
        afkorting_letter.put("Ile", "I");
        afkorting_letter.put("Leu", "L");
        afkorting_letter.put("Lys", "K");
        afkorting_letter.put("Met", "M");
        afkorting_letter.put("Pro", "P");
        afkorting_letter.put("Ser", "S");
        afkorting_letter.put("Thr", "T");
        afkorting_letter.put("Trp", "W");
        afkorting_letter.put("Tyr", "Y");
        afkorting_letter.put("Val", "V");

        HashMap<String, String> letter_volledig = new HashMap<String, String>();

        letter_volledig.put("A", "Alanine");
        letter_volledig.put("R", "Arginine");
        letter_volledig.put("N", "Asparagine");
        letter_volledig.put("D", "Asparaginezuur");
        letter_volledig.put("C", "Cysteïne");
        letter_volledig.put("F", "Fenylalanine");
        letter_volledig.put("Q", "Glutamine");
        letter_volledig.put("E", "Glutaminezuur");
        letter_volledig.put("G", "Glycine");
        letter_volledig.put("H", "Histidine");
        letter_volledig.put("I", "Isoleucine");
        letter_volledig.put("L", "Leucine");
        letter_volledig.put("K", "Lysine");
        letter_volledig.put("M", "Methionine");
        letter_volledig.put("P", "Proline");
        letter_volledig.put("S", "Serine");
        letter_volledig.put("T", "Threonine");
        letter_volledig.put("W", "Tryptofaan");
        letter_volledig.put("Y", "Tyrosine");
        letter_volledig.put("V", "Valine");

        Scanner sc= new Scanner(System.in);
        System.out.print("Let op! Hoofdletter gevoelig!" + "\n" +
                "Voer een eenletterige afkorting van een aminozuur " +
                "in: ");
        String str= sc.nextLine();
        if (str.length()==1){
            if (letter_volledig.get(str)!= null) {
                System.out.println(volledig_afkorting.get(letter_volledig.get(str)));
                System.out.println(letter_volledig.get(str));
            } else {
                System.out.println(str + " is geen aminozuur");
            }

        }
        else if (str.length()==3){
            if (afkorting_letter.get(str) != null) {
                System.out.println(afkorting_letter.get(str));
                System.out.println(letter_volledig.get(afkorting_letter.get(str)));
            } else {
                System.out.println(str + " is geen aminozuur");
            }

        }
        else{
            if (volledig_afkorting.get(str) != null) {
                System.out.println(volledig_afkorting.get(str));
                System.out.println(afkorting_letter.get(volledig_afkorting.get(str)));
            } else {
                System.out.println(str + " is geen aminozuur");
            }

        }
    }
}

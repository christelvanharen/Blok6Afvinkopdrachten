package Afvink_2;

public class NextGeneration {

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
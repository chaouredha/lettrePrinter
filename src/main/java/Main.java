package main.java;

public class Main {
    public static void main(String[] args) {
        afficheA(5);
        afficheE(5);
        afficheF(5);
    }

    private static void afficheA(Integer hauteur) {
        char[][] table = new char[hauteur * 2][hauteur * 2];
        String str = "\t";
        int n = hauteur * 2 / 2;
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < hauteur * 2; j++) {
                if (j == n || j == ((hauteur * 2) - n) || (i == hauteur / 2 && j < ((hauteur * 2) - n)) && j > n) {
                    table[i][j] = '*';
                    str += table[i][j];
                } else {
                    table[i][j] = ' ';
                    str += table[i][j];
                }
            }
            n--;
            System.out.println(str);
            str = "\t";
        }
    }

    private static void afficheE(Integer hauteur) {
        char[][] table = new char[hauteur][hauteur];
        String str = "\t";
        for (int i = 0; i < hauteur; i++) {
            table[i][0] = '*';
            str += table[i][0];
            for (int j = 0; j < hauteur; j++) {
                if ((i == 0 || i == hauteur - 1)
                        || (i == hauteur / 2
                        && j <= hauteur / 2)) {
                    table[i][j] = '*';
                    str += table[i][j];
                }
            }
            System.out.println(str);
            str = "\t";
        }
    }

    private static void afficheF(int hauteur) {
        char[][] table = new char[hauteur][hauteur];
        String str = "\t";
        for (int i = 0; i < hauteur; i++) {
            table[i][0] = '*';
            str += table[i][0];
            for (int j = 0; j < hauteur; j++) {
                if ((i == 0) || (i == hauteur / 2
                        && j <= hauteur / 2)) {

                    table[i][j] = '*';
                    str += table[i][j];
                }
            }
            System.out.println(str);
            str = "\t";
        }
    }
}

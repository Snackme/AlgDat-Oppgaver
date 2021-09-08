package LocNguyen.Oppgaver.Uke34;

import java.util.Arrays;

public class Oppgave1122 {
    public static void main(String[] args) {

        // a er en heltallstabell
        int[] a = {8, 20, 4, 17, 10, 6, 20, 1, 11, 15, 3, 18, 9, 2, 7, 19};

        System.out.println("tabellen: " + Arrays.toString(a));

        int min_index = min(a);
        System.out.println("Posisjonen til den minste verdien er: " + min_index);

    }


    static int min(int[] a) {

        if (a.length < 1)
            throw new java.util.NoSuchElementException("Tabellen a er tom!");

        // indeks til foreløpig største verdi (m for maks)
        int m = 0;

        int min_value = a[0];
        int min_index = 0;

        // obs: starter med i = 0
        for (int i = 0; i < a.length; i++) {

            int value = a[i];
            int index = i;

            if (value < min_value) {

                min_value = value;
                min_index = index;
            }
        }

        // returnerer indeksen/posisjonen til største verdi
        return min_index;

    }
}

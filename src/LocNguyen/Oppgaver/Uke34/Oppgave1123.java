package LocNguyen.Oppgaver.Uke34;

import java.util.Arrays;

public class Oppgave1123 {

    public static void main(String[] args) {

        // a er en heltallstabell
        int[] a = {8, 20, 4, 17, 10, 6, 20, 20, 11, 15, 3, 18, 9, 2, 7, 19};

        System.out.println("tabellen: " + Arrays.toString(a));

        int min_index = maks(a);
        System.out.println("Posisjonen til den nest største verdien er: " + min_index);

    }


    public static int maks(int[] a)  // a er en heltallstabell
    {
        if (a.length < 1)
            throw new java.util.NoSuchElementException("Tabellen a er tom!");

        int m = 0;  // indeks til foreløpig største verdi (m for maks)

        for (int i = 1; i < a.length; i++) // obs: starter med i = 1
        {
            if (a[i] >= a[m]) m = i;  // indeksen oppdateres
        }

        // indeksen oppdateret

        return m;  // returnerer indeksen/posisjonen til største verdi

    } // maks
}

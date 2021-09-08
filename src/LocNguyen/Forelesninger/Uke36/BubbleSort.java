package LocNguyen.Forelesninger.Uke36;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] values = {5, 6, 9, 2, 8, 3, 1, 10, 32, 4, 7, 14, 17, 18, 13};

        //To for-løkker
        //ytre løkke: sorterer et tall per gjennomgang
        for (int i = 0; i < values.length - 1; i++) {

            System.out.println("Array før sortering av index " + i);
            System.out.println(Arrays.toString(values));
            //indre løkke: bobler opp tall til riktig posisjon
            for (int j = values.length - 1; j > i; j--) {


                //Sjekk om tall på posisjon j og (j-i) er sortert riktig
                if (values[j] < values[j - 1]) {
                    System.out.println("Inversjon, bytter plass på " + j + " og " + (j + 1));
                    int temp = values[j];
                    values[j] = values[j - 1];
                    values[j - 1] = temp;
                }
            }

            System.out.println("sorterer verdier");
            System.out.println(Arrays.toString(values));
        }


    }
}

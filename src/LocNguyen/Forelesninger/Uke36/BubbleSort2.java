package LocNguyen.Forelesninger.Uke36;

import java.util.Arrays;

public class BubbleSort2 {
    public static void main(String[] args) {

        int[] values = {5, 6, 9, 2, 8, 3, 1, 10, 32, 4, 7, 14, 17, 18, 13};

        bubbleSort(values);

        System.out.println(Arrays.toString(values));

        int index1 = binarySearch(values, 9);
        System.out.println("fant tallet 9 på " + index1);

        int index2 = binarySearchRecursive(values, 12345, 0, values.length);
        System.out.println("fant tallet 9 rekursivt på " + index2);

        int index3 = binarySearchRecursive(values, 2, 0, values.length);
        System.out.println("fant tallet 11 rekursivt på "+ index3);
    }

    public static int binarySearchRecursive(int[] values, int search_value, int l, int r) {
        int m = (l + r) / 2;

        if (l > r){
            return -l;
        }

        if (values[m] > search_value) {
            r = m - 1;
            return binarySearchRecursive(values, search_value, l, r);
        } else if (values[m] < search_value) {
            l = m + 1;
            return binarySearchRecursive(values, search_value, l, r);
        } else if (values[m] == search_value) {
            return m;
        }
        System.out.println("sum ting wong again, recusion");
            return -m;
    }

    private static void bubbleSort(int[] values) {
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


    public static int binarySearch(int[] values, int search_value) {
        //Intervaller;
        // Halvåpent intervall:
        // [8, 10) => 8 9 ==> Vanlig for-løkke: for(int 1=0; i<10; i++)
        // (8,10] => 9, 10
        //Lukket intervall:
        // [8,10] => 8, 9, 10 => "vanlig" for-løkkge: for(int i = 8; i <= 10; i++)

        //Søk etter 6
        //[L                R]
        //[ a b c d e f g h i j ]
        //[ 0 1 2 3 4 5 6 7 8 9 10]
        // value.length = 10
        // L = 0 // Left index 0
        //R = 9 // right index 9
        // m = (L+r) / 2=(0+9)/2 //middle
        //values.length = 10, midten = values.length-1/2  = e.


        //Søk i intervallet [L, r]
        int l = 0;
        int r = values.length - 1;


        //Hvis midten er større,
        //gå til venstre

        while (l <= r) {
            int m = (l + r) / 2;
            if (values[m] > search_value) {
                r = m - 1;
            } else if (values[m] < search_value) {
                l = m + 1;
            } else if (values[m] == search_value) {
                return m;
            } else {
                System.out.println("sum ting wong");
            }

        }
        return -l;
    }
}
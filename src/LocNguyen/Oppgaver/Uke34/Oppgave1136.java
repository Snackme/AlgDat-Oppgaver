package LocNguyen.Oppgaver.Uke34;

public class Oppgave1136 {
    public static void main(String[] args) {



        System.out.println(fak(8));

    }

    public static long fak(int n)
    {
        if (n < 0)
            throw new IllegalArgumentException("n < 0");
        long fak = 1;

        for (int i = 2; i <= n; i++) fak *= i;

        return fak;
    }

}

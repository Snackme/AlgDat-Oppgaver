package LocNguyen.Forelesninger;

/**
 * Windows: [alt] + [enter] mens du holder på klassen for å lage tester
 * Mac: [option] + [enter] --"--
 */
public class MyFirstSort {

    public static void main(String[] args) {
        System.out.println("Hello algdat");

        int values[] = {1, 7, 2, 4, 6, 9};

        myFirstSort(values);
    }

    /**
     * Denne funksjonen tar inn ett array med verdier (heltall),
     * og sorterer dem "in place"
     *
     * @param values Verdier vi skal sortere.
     */
    public static void myFirstSort(int[] values) {
        for (int k = 0; k < values.length - 1; k++) {
            //Sjekk at vi får fornuftig svar for *ett* tilfelle.
            //Vi må utføre ordentlig testing før vi
            //faktisk kan stole på kildekoden vår
            int max_index = findMax(values, k, values.length);
            //System.out.println("Største verdi ligger på plass "
            //        + max_index + " og har verdi " + values[max_index]);

            //Bytte plass på tall på plass 0 og max_index
            int temp = values[k];
            values[k] = values[max_index];
            values[max_index] = temp;

            //System.out.println("Bytter plass " + k + " med plass " + max_index);
            //System.out.println("Arrayet etter ombytting");
            //for (int i = 0; i < values.length; ++i) {
            //    System.out.print(values[i] + ", ");
            //}
            //System.out.println();
        }
    }

    /**
     * Findmax - finner index til største tall i et array,
     * men søker bare innenfor tallene i [fra, til)
     */
    public static int findMax(int[] values, int fra, int til) {
        //Test at grensene gir mening

        if (til - fra < 2) {
            throw new ArrayIndexOutOfBoundsException("Feil i grenser");
        }
        if (fra < 0) {
            throw new ArrayIndexOutOfBoundsException("Fra er negativ");
        }
        if (til < 2) {
            throw new ArrayIndexOutOfBoundsException("Til er ikke lang nok");
        }
        if (til > values.length) {
            throw new ArrayIndexOutOfBoundsException("Tul er ikke lang nok");
        }

        //Indekser: 0 1 2 3 4 5
        //values.length = 6
        //Starter med verdiene {1, 7, 2, 4, 6, 9}

        //Initialiser ved å se på første "kort"
        //Dette er det største og nest største tallene jeg har funnet
        //så langt
        int index_max = fra;//1
        int index_nestmax = fra + 1; //7

        int max_value = values[fra]; // 1
        int nest_max_value = values[fra + 1]; // 7

        //Hvis nest_max_value har en verdi som er større enn variabelen max_value så må vi bytte den
        if (max_value < nest_max_value) {
            int temp = max_value;
            max_value = nest_max_value;
            nest_max_value = temp;

            temp = index_max;
            index_max = index_nestmax;
            index_nestmax = temp;
        }

        //Status så langt:
        //Array: {1, 7, 2, 4, 6, 9};
        //Vi har sett på de to første elementene {1, 7}
        //max_value = 7, index_max = 1
        //nest_max_value = 1, index_nestmax = 0;
        //nå må vi løpe gjennom resten av arrayet

        //Sjekk at grensene for løkken er riktig.
        // Intervallet vårt er [fra, til)
        //Siden vi har sjekket de to første tallene, begynner vår for-løkke fra+2.
        for (int i = fra + 2; i < til; i++) {

            //Tilfelle 1: nytt største tall:

            if (values[i] > max_value){
                int temp = max_value; //Tallet 7 i vårt tilfelle
                max_value = values[i]; //f.eks: 14
                nest_max_value = temp; //Taller 7

                //oppdater indexene
                temp = index_max;
                index_max = i;
                index_nestmax = temp;
            }
            //Sjekk om vi har funnet nytt største tall
            if (values[i] > max_value) {
                max_value = values[i];
                max_value = i;
            }
            else if (values[i] > nest_max_value){
                nest_max_value = values[i];
                index_nestmax = i;
            }
            else {
                //ingenting, max og n estmax er større begge to.
            }
        }

        return index_nestmax;
    }


    /**
     * Findmax- finner index til største og nest største tall i et array, men søker bare innenfor tallene i [fra, til)
     */
    public static int findTwoMaxIndices(int[] values, int fra, int til) {
        //Initialiser ved å se på første "kort"
        //Dette er det største tallet jeg har funnet
        //så langt
        int index = fra;
        int max_value = values[fra];

        //Sjekk at grensene for løkken er riktig.
        // [1, values.length)
        for (int i = fra + 1; i < til; i++) {
            //Sjekk om vi har funnet nytt største tall
            if (values[i] > max_value) {
                max_value = values[i];
                index = i;
            }
        }

        return index;
    }
}
public class Main {

    // Methode = Methodenkopf + Methodenrumpf

    // Methodenkopf = Sichtbarbeit (public) Modifikator (static)
    //                  Datentyp (void) Methodenname Parameterliste

    // Parameterliste = "(" Datentyp Parametername ... ")"

    // Methodensignatur = Methodenname + Datentypen der Parameter

    // Methodenrumpf = "{" Anweisungen "}"

    // Übgergabepradigma: Call-By-Value

    // Übgergabepradigma: Call-By-Reference

    // Überladung: Methoden haben den selben Methodennamen,
    //             unterscheiden sich aber in der Parameterlist,
    //             d.h. haben eine unterschiedliche Methodensignatur
    public static void ausgabe(int x) {
        System.out.println("x = " + x );
    }
    public static void ausgabe(double x) {
        System.out.println("x = " + x );
    }

    public static double berechneGerade(double m, double x, double b) {
        return m * x + b;
    }

    // typische Überladung, Faulenzer, um einen (Default) Parameter
    // einzusparen
    public static double berechneGerade(double m, double x) {
        //return m * x; // SO NICHT  !!! -> WEIL: DRY !!!
        return berechneGerade(m, x, 0.0);
    }

    // Selbstaufruf einer Funktion/Methode: Rekursion
    public static int fakultät(int n) {
        if (n == 1) return 1;
        return n * fakultät( n-1 );
    }

    public static long anzahlAufrufe = 0;

    public static long fibonacci(long n) {
        anzahlAufrufe++;
        if (n <= 2) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static long fibonacci_iterativ(long n) {
        long fibo = 0;
        long fibo_vorher = 1;
        while (n > 0) {
            //System.out.println("aktuelle Fibo: " + fibo);
            long fibo_merken = fibo;
            fibo = fibo + fibo_vorher;
            fibo_vorher = fibo_merken;
            n--;
        }
        return fibo;
    }

    public static void main(String[] args) {
        ausgabe( 10 );
        ausgabe( 17.7 );
        System.out.println( berechneGerade(4, 2) );
        System.out.println( berechneGerade(3, 5) );
        System.out.println( fakultät(6) );
        //System.out.println( fibonacci(8) );
        //System.out.println( fibonacci_iterativ(8) );
        System.out.println( "fibo(50)_i = " + fibonacci_iterativ(50) );
        System.out.println( "fibo(50)_r = " + fibonacci(50) );
        System.out.println("Es hat " + anzahlAufrufe + " Aurufe gekostet");
    }
}

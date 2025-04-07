//LEGGERE LE ISTRUZIONI NEL FILE README.md

//Import di Classi Java necessarie al funzionamento del programma
import java.util.Scanner;
import java.util.Random;

// Classe principale, con metodo main
class Esercizio {
    
    public static void bubbleSort(String[] A, int[] P) {
        int i, j, tempP;
        String tempA;
        boolean scambio;
        scambio = true;
        i = 0;
        while (i<P.length && scambio) {
            scambio = false;
            j = 0;
            while (j<(P.length-1)-i) {
                if (P[j]>P[j+1]) {
                    tempP = P[j];
                    P[j] = P[j+1];
                    P[j+1] = tempP;
                    tempA = A[j];
                    A[j] = A[j+1];
                    A[j+1] = tempA;
                    scambio = true;
                }
                ++j;
            }
            ++i;
        }
    }

    public static void impostaVettoreRandom(int[] V) {
        int i;
        Random random = new Random();
        for (i=0; i<V.length; ++i) {
            V[i] = random.nextInt(V.length)+1;
        }
    }

    public static void visualizzaVettori(String[] A, int[] P) {
        int i;
        for (i=0; i<P.length; ++i) {
            System.out.println("Posizione: " + P[i] + " - Macchina: " + A[i]);
        }
    }

    public static int ricercaBinaria(int[]P, int val) {
        int iStart, iEnd, centro, idx;
        iStart = 0;
        iEnd = P.length-1;
        centro = iStart+(iEnd-iStart)/2;
        idx = -1;
        while (idx!=centro && iEnd>=iStart) {
            if (val>P[centro]) {
                iStart = centro+1;
            } else if (val<P[centro]) {
                iEnd = centro-1;
            } else {
                idx = centro;
            }
            centro = iStart+(iEnd-iStart)/2;
        }
        return idx;
    }

    public static int ricercaSequenziale(int[] P, int N, int val) {
        int i, idx;
        idx = -1;
        for (i=0; i<N && idx==-1; ++i) {
            if (P[i]==val) {
                idx = i;
            }
        }
        return idx;
    }

    public static void main(String args[]) {

        Scanner in = new Scanner( System.in );
        int N, i, pos, idx;
        String nome;
        System.out.println("Inserire il numero di automobili partecipanti alla gara: ");
        N = Integer.parseInt(in.nextLine());
        String[] A = new String[N];
        int[] P = new int[N];
        for (i=0; i<N; ++i) {
            System.out.println("Inserisci il nome dell'automobile: ");
            nome = in.nextLine();
            A[i] = nome;
        }
        impostaVettoreRandom(P);
        System.out.println("------ CLASSIFICA NON ORDINATA ------");
        visualizzaVettori(A, P);
        System.out.println("------ CLASSIFICA ORDINATA ------");
        bubbleSort(A, P);
        visualizzaVettori(A, P);
        System.out.println("Inserire la posizione dell'automobile da cercare con ricerca binaria: ");
        pos = Integer.parseInt(in.nextLine());
        idx = ricercaBinaria(P, pos);
        if (idx!=-1) {
            System.out.println("La macchina alla posizione " + pos + " si trova all'indice " + idx);
        } else {
            System.out.println("La macchina non è stata trovata");
        }
        System.out.println("Inserire la posizione dell'automobile da cercare con ricerca sequenziale: ");
        pos = Integer.parseInt(in.nextLine());
        idx = ricercaSequenziale(P, pos);
        if (idx!=-1) {
            System.out.println("La macchina alla posizione " + pos + " si trova all'indice " + idx);
        } else {
            System.out.println("La macchina non è stata trovata");
        }
    }
}

//LEGGERE LE ISTRUZIONI NEL FILE README.md
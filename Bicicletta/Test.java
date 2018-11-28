import java.util.*;
public class Test
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci nome1");
        String nome1 = in.nextLine();
        System.out.println("Inserisci cognome1");
        String cognome1 = in.nextLine();
        Utente utente1 = new Utente(nome1,cognome1);
        System.out.println("Inserisci nome2");
        String nome2 = in.nextLine();
        System.out.println("Inserisci cognome2");
        String cognome2 = in.nextLine();
        Utente utente2 = new Utente(nome2,cognome2);
        System.out.println("Inserisci nome3");
        String nome3 = in.nextLine();
        System.out.println("Inserisci cognome3");
        String cognome3 = in.nextLine();
        Utente utente3 = new Utente(nome3,cognome3);
        Bicicletta bici1 = new Bicicletta("101",true);
        Bicicletta bici2 = new Bicicletta("102",false);
        Bicicletta bici3 = new Bicicletta("103",true);
        Stazione stazione1 = new Stazione("san donato",2.0,3.0,5,true);
        System.out.println(stazione1.toString());
        utente1.prendiInUso(bici1);
        stazione1.aggancia(utente1, 3);
    }
}

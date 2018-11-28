import java.util.*;
public class TestUtente
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("inserisci nome");
        String nome = in.nextLine();
        System.out.println("inserisci cognome");
        String cognome = in.nextLine();
        System.out.println("inserisci data di nascita");
        System.out.println("giorno: ");
        int giorno = Integer.parseInt(in.nextLine());
        System.out.println("mese: ");
        int mese = Integer.parseInt(in.nextLine());
        System.out.println("anno: ");
        int anno = Integer.parseInt(in.nextLine());
        Data dataDiNascita = new Data(giorno,mese,anno);
        Utente utente = new Utente(nome,cognome,dataDiNascita);
        System.out.println("Nuovo utente");
        System.out.println(utente.toString());

    }
}

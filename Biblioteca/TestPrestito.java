import java.util.*;
public class TestPrestito
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String[] autori = new String[3];
        System.out.println("Inserisci titolo(libro1)");
        String titolo = in.nextLine();
        System.out.println("Inserisci autori(libro1)");
        for (int i=0; i<autori.length; i++)
        {
            autori[i] = in.nextLine();
        }
        String autore = autori[0];
        System.out.println("Inserisci prestabile(libro1)");
        boolean prest = Boolean.parseBoolean(in.nextLine());
        Libro libro1 = new Libro(titolo, autore, prest);
        System.out.println("Libro1");
        System.out.println(libro1.toString());

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

        Data oggi = new Data();

        Prestito prestito = new Prestito(libro1, utente,oggi, oggi.successiva());
        System.out.println(prestito.toString());
        System.out.println(prestito.riguardaLibro(libro1));
        System.out.println(prestito.riguardaData(oggi));
    }
}

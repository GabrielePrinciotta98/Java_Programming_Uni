import java.util.*;
public class TestBiblioteca
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        //String[] autori = new String[3];
        System.out.println("Inserisci titolo(libro1)");
        String titolo1 = in.nextLine();
        System.out.println("Inserisci autore(libro1)");
        String autore1 = in.nextLine();
        System.out.println("Inserisci prestabile(libro1)");
        boolean prest1 = Boolean.parseBoolean(in.nextLine());
        Libro libro1 = new Libro(titolo1, autore1, prest1);
        System.out.println("Libro1");
        System.out.println(libro1.toString());
        System.out.println("Inserisci titolo(libro2)");
        String titolo2 = in.nextLine();
        System.out.println("Inserisci autore(libro2)");
        String autore2 = in.nextLine();
        System.out.println("Inserisci prestabile(libro2)");
        boolean prest2 = Boolean.parseBoolean(in.nextLine());
        Libro libro2 = new Libro(titolo2, autore2, prest2);
        System.out.println("Libro2");
        System.out.println(libro2.toString());
        System.out.println("Inserisci titolo(libro3)");
        String titolo3 = in.nextLine();
        System.out.println("Inserisci autore(libro3)");
        String autore3 = in.nextLine();
        System.out.println("Inserisci prestabile(libro3)");
        boolean prest3 = Boolean.parseBoolean(in.nextLine());
        Libro libro3 = new Libro(titolo3, autore3, prest3);
        System.out.println("Libro3");
        System.out.println(libro3.toString());

        System.out.println("inserisci nome(utente1)");
        String nome1 = in.nextLine();
        System.out.println("inserisci cognome(utente1)");
        String cognome1 = in.nextLine();
        System.out.println("inserisci data di nascita(utente1)");
        System.out.println("giorno: ");
        int giorno1 = Integer.parseInt(in.nextLine());
        System.out.println("mese: ");
        int mese1 = Integer.parseInt(in.nextLine());
        System.out.println("anno: ");
        int anno1 = Integer.parseInt(in.nextLine());
        Data dataDiNascita1 = new Data(giorno1,mese1,anno1);
        Utente utente1 = new Utente(nome1,cognome1,dataDiNascita1);
        System.out.println("Nuovo utente(utente1)");
        System.out.println(utente1.toString());

        System.out.println("inserisci nome(utente2)");
        String nome2 = in.nextLine();
        System.out.println("inserisci cognome(utente2)");
        String cognome2 = in.nextLine();
        System.out.println("inserisci data di nascita(utente2)");
        System.out.println("giorno: ");
        int giorno2 = Integer.parseInt(in.nextLine());
        System.out.println("mese: ");
        int mese2 = Integer.parseInt(in.nextLine());
        System.out.println("anno: ");
        int anno2 = Integer.parseInt(in.nextLine());
        Data dataDiNascita2 = new Data(giorno2,mese2,anno2);
        Utente utente2 = new Utente(nome2,cognome2,dataDiNascita2);
        System.out.println("Nuovo utente(utente1)");
        System.out.println(utente2.toString());
        Data oggi = new Data();

        Prestito prestito = new Prestito(libro1, utente1,oggi, oggi.successiva());
        System.out.println(prestito.toString());
        System.out.println("Nome biblioteca:");
        String biblio = in.nextLine();
        Biblioteca biblioteca = new Biblioteca(biblio);
        biblioteca.nuovoUtente(utente1);
        biblioteca.nuovoUtente(utente2);
        biblioteca.nuovoLibro(libro1);
        biblioteca.nuovoLibro(libro2);
        biblioteca.nuovoLibro(libro3);
        System.out.println("Biblioteca: ");
        System.out.println(biblioteca.toString());
        System.out.println("Numero libri:");
        System.out.println(biblioteca.numeroLibri());
        System.out.println("Numero utenti:");
        System.out.println(biblioteca.numeroUtenti());
        System.out.println("cerca libro con la parola");
        String x = in.nextLine();
        System.out.println(biblioteca.cercaLibro(x).toString());
        System.out.println("è disponibile il libro -la divina commedia-?");
        System.out.println(biblioteca.disponibile(libro3));
        System.out.println("prestito a utente1(divina commedia)");
        System.out.println(biblioteca.daiInPrestito(libro3, utente1));
        System.out.println("prestito a utente2(divina commedia)");
        System.out.println(biblioteca.daiInPrestito(libro3, utente2));
        System.out.println("chi ha in prestito la divina commedia?");
        System.out.println(biblioteca.chiHaInPrestito(libro3).toString());
        System.out.println("quanti prestiti ha l'utente1?");
        System.out.println(biblioteca.quantiPrestiti(utente1));
    }
}

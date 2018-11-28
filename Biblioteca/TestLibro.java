import java.util.*;
public class TestLibro
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
        Libro libro2 = new Libro(titolo, autori);
        System.out.println("Libro2");
        System.out.println(libro2.toString());
        Libro libro3 = new Libro(titolo, autore);
        System.out.println("Libro3");
        System.out.println(libro3.toString());
    }
}

import java.util.*;
public class TestUnita
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci nome");
        String nome1 = in.nextLine();
        System.out.println("Inserisci sigla");
        String sigla1 = in.nextLine();
        UnitaDiMisura unita1 = new UnitaDiMisura(nome1,sigla1);
        System.out.println(unita1.toString());
        //System.out.println(unita1.riferimento().toString());
        System.out.println("Inserisci nome");
        String nome2 = in.nextLine();
        System.out.println("Inserisci sigla");
        String sigla2 = in.nextLine();
        System.out.println("Inserisci qta");
        double qta = Double.parseDouble(in.nextLine());
        UnitaDiMisura unita2 = new UnitaDiMisura(nome2,sigla2,unita1,qta);
        System.out.println(unita2.toString());
        //System.out.println(unita2.riferimento().toString());
        System.out.println("Inserisci nome reparto");
        String nomereparto = in.nextLine();
        System.out.println("Inserisci nome responsabile");
        String nomeresponsabile = in.nextLine();
        Reparto reparto = new Reparto(nomereparto,nomeresponsabile);
        System.out.println("Inserisci nome prodotto");
        String prodotto1 = in.nextLine();
        System.out.println("Inserisci id prodotto");
        String id1 = in.nextLine();
        System.out.println("Inserisci quantità prodotto");
        double quantita1 = Double.parseDouble(in.nextLine());
        System.out.println("Inserisci prezzo prodotto");
        double prezzo1 = Double.parseDouble(in.nextLine());
        Prodotto birra = new Prodotto(prodotto1,reparto,id1,quantita1,prezzo1,unita2);
        System.out.println("Prodotto 1:");
        System.out.println(birra.toString());
        System.out.println("TEST OFFERTA");
        System.out.println("Inserisci nome offerta");
        String nomeOff = in.nextLine();
        System.out.println("Inserisci sconto");
        double sconto = Double.parseDouble(in.nextLine());
        System.out.println("Inserisci qunatità minima");
        int numMin = Integer.parseInt(in.nextLine());
        System.out.println("Inserisci solo carta fedeltà");
        boolean carta = Boolean.parseBoolean(in.nextLine());
        Offerta offerta = new Offerta(nomeOff,birra,sconto,numMin,carta);
        System.out.println(offerta.toString());
        System.out.println(offerta.prezzo(3,true));
        ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
        ArrayList<Offerta> offerte = new ArrayList<Offerta>();
        ArrayList<Reparto> reparti = new ArrayList<Reparto>();
        System.out.println("ma che cazzo");
        Supermercato esselunga = new Supermercato();
        esselunga.aggiungiReparto(reparto);
        esselunga.aggiungiOfferta(offerta);
        esselunga.aggiungiProdotto(birra);
        System.out.println("Supermercato");
        System.out.println(esselunga.toString());
    }
}

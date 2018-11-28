import java.util.*;
public class Tester
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Nome 1 civiltà:");
        String nomeCiv1 = in.nextLine();
        System.out.println("Nome 2 civiltà:");
        String nomeCiv2 = in.nextLine();
        System.out.println("Legno:");
        String nomeRis1 = in.nextLine();
        System.out.println("Marmo:");
        String nomeRis2 = in.nextLine();
        System.out.println("Armi:");
        String nomeRis3 = in.nextLine();

        System.out.println("TEST CIVILTA:");
        Civilta civGreci = new Civilta(nomeCiv1);
        Civilta civRomani = new Civilta(nomeCiv2);
        System.out.println(civGreci.toString());
        Risorsa risMarmo = new Risorsa(nomeRis2, 10);
        Risorsa risLegno = new Risorsa(nomeRis1, 5);
        Risorsa risArmi = new Risorsa(nomeRis3, 20);
        System.out.println("Fonda 1 citta(atene):");
        String nomeCit1 = in.nextLine();
        System.out.println("Fonda 2 citta(roma):");
        String nomeCit2 = in.nextLine();
        civGreci.fondaCitta(nomeCit1, risLegno);
        civGreci.aggiungiDenaro(1000);
        civGreci.aggiungiRisorsa(risMarmo);
        System.out.println(civGreci.toString());
        civGreci.faiProdurre();
        System.out.println(civGreci.toString());
        System.out.println(civGreci.possiede(risLegno));
        System.out.println(civGreci.vendiRisorseA(civRomani));
        civRomani.aggiungiDenaro(2000);
        civRomani.fondaCitta(nomeCit2, risArmi);

        System.out.println("TEST STORIA:");
        ArrayList<Civilta> antica = new ArrayList<Civilta>();
        antica.add(civGreci);
        antica.add(civRomani);
        Storia stAntichita = new Storia(antica);
        stAntichita.commercia();
        System.out.println(civGreci.toString());
        System.out.println(civRomani.toString());
        System.out.println("Civiltà piu ricca:"+stAntichita.piuRicca().toString());
        System.out.println("Civiltà piu povera: "+stAntichita.piuPovera().toString());
        System.out.println("evoluzione:"+ stAntichita.evolvi(3));
        stAntichita.conquista();
        System.out.println("conquista: ");
        System.out.println(antica.toString());

        System.out.println("FINE TEST");
    }
}

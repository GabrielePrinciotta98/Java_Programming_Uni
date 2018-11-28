import java.util.*;
public class TestData
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci giorno");
        int giorno = Integer.parseInt(in.nextLine());
        System.out.println("Inserisci mese");
        int mese = Integer.parseInt(in.nextLine());
        System.out.println("Inserisci anno");
        int anno = Integer.parseInt(in.nextLine());
        Data d = new Data(giorno,mese,anno);
        System.out.println(d.toString());
        Data oggi = new Data();
        System.out.println("Data di oggi");
        System.out.println(oggi.toString());
        System.out.println("Giorni da epoca");
        System.out.println(oggi.giorniDaEpoca());
        System.out.println("d viene prima di oggi?");
        System.out.println(d.vienePrimaDi(oggi));
        System.out.println("Data successiva a oggi");
        System.out.println(oggi.successiva().toString());
    }
}

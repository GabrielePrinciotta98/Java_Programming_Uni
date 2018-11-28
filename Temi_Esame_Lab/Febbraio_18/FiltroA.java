import java.util.*;
import java.io.*;
public class FiltroA
{
    public static void main(String[] args) throws FileNotFoundException
    {
        String nomefile = args[0];
        File file = new File(nomefile);
        Scanner inR = new Scanner(file);
        int r = 0;//numero riga
        int temp = 0;
        ArrayList<Character> andamento = new ArrayList<Character>();
        while (inR.hasNextLine())
        {
            String riga = inR.nextLine();
            Scanner inP = new Scanner(riga);
            int c = 0;//numero parole per riga
            int n = 0;//numero parole pari per riga
            double rapporto;
            while (inP.hasNext())
            {
                String parola = inP.next();
                if (parola.length() % 2 == 0)
                    n++;
                c++;
            }
            if (r != 0)
            {
                if (temp < n)
                    andamento.add('/');
                else
                    if (temp > n)
                        andamento.add('\\');
                    else
                        andamento.add('-');
            }
            temp = n;
            rapporto = (double)(n) / c;
            System.out.println("Riga: "+riga);
            System.out.println("Pari: "+n);
            System.out.println("Rapporto: "+rapporto);
            r++;
        }
        for (int i=0; i<andamento.size(); i++)
            System.out.print(andamento.get(i));
        System.out.println();
    }
}

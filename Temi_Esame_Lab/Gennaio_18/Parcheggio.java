import java.util.*;
public class Parcheggio
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int riga = 0;
        ArrayList<Integer> parcheggio = new ArrayList<Integer>(20);
        ArrayList<Integer> macchina = new ArrayList<Integer>();
        //ArrayList<Integer> libero = new ArrayList<Integer>();
        //StringBuilder sb = new StringBuilder();
        while (in.hasNextLine())
        {
            String t = in.nextLine().trim();
            if (riga == 0)
            {
                for (int i=0; i<t.length(); i++)
                {
                    if  (Character.isDigit(t.charAt(i)))
                        parcheggio.add(Character.getNumericValue(t.charAt(i)));
                }
            }
            else
            {
                for (int i=0; i<t.length(); i++)
                {
                    if  (Character.isDigit(t.charAt(i)))
                        macchina.add(Character.getNumericValue(t.charAt(i)));
                }
            }
            riga++;
        }
        for (int i=0; i<macchina.size(); i++)
        {
            for (int j=0; j<parcheggio.size(); j++)
            {
                if (macchina.get(i) == parcheggio.get(j))
                {
                    parcheggio.remove(j);
                    break;
                }
            }
        }
        for (int i=0; i<parcheggio.size(); i++)
            System.out.print(parcheggio.get(i)+" ");
        System.out.println();
    }
}

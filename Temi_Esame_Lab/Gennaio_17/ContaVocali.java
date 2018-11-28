import java.util.*;
public class ContaVocali
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int c = 0;
        int n = 0;
        int max = 0;
        int somma = 0;
        while (in.hasNext())
        {
            String s = in.next();
            for (int i=0; i<s.length(); i++)
            {
                char m = s.charAt(i);
                if (m == 'a' || m == 'e' || m == 'i' || m == 'o' || m == 'u')
                {
                    c++;
                }
                if (max < c)
                    max = c;
            }
            somma += c;
            n++;
            c = 0;
        }
        System.out.println("SOMMA: "+somma);
        System.out.println("N: "+n);
        int media = somma / n;
        System.out.println("Max: "+ max);
        System.out.println("Media: "+media);
    }
}

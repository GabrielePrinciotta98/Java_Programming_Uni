import java.util.Scanner;
public class LunghezzaParole
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int somma = 0;
        int c = 0;
        while(in.hasNext())
        {
            String s = in.next();
            if (s.length() > max)
                max = s.length();
            if (s.length() < min)
                min = s.length();
            somma += s.length();
            c++;
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Med: " + (somma/c));
    }
}

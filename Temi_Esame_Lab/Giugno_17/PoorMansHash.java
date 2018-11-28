import java.util.*;
public class PoorMansHash
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String s = args[0];
        char[] out = new char[15];
        char nuovo = '0';
        for (int i=0; i<15; i++)
            out[i] = (char)(32);
        for (int i=0; i<s.length(); i++)
        {
            int n = (int)(s.charAt(i));
            n /= 3;
            int k = i%15;
            n += out[k];
            out[k] = (char)((n % 95) + 33);

        }
        for (int i=0; i<15; i++)
        {
            System.out.print(out[i]);
        }
        System.out.println();
    }
}

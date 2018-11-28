import java.util.*;
public class PotenzeDiDue
{
    public static void main(String[] args)
    {
        int c = 0;
        for (int i=0; i<args.length; i++)
        {
            int n = Integer.parseInt(args[i]);
            while(n != 1)
            {
                n /= 2;
                if (n%2 != 0 || n == 0)
                    break;
            }
            if (n == 1)
                c++;
        }
            System.out.println(c);
    }
}

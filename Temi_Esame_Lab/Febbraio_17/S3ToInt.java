import java.util.*;
public class S3ToInt
{
    public static void main(String[] args)

    {
        int ris = 0;
        for (int i=0; i<args[0].length(); i++)
        {
            int parz1 = 1;
            int parz2 = 1;
            char m = args[0].charAt(i);
            if ( m != 'u' && m != 'd' && m != 'z')
            {
                System.out.println("input non valido");
                break;
            }
            else
            {
                switch (m)
                {
                    case 'z': break;

                    case 'u': for (int j=args[0].length()-1; j>i; j--)
                            {
                                parz1 *= 3;
                            }
                            ris += parz1;
                            break;

                    case 'd': for (int j=args[0].length()-1; j>i; j--)
                            {
                                parz2 *= 3;
                            }
                            ris += (parz2 * 2);
                            break;
                }
            }
        }
        if (ris != 0)
            System.out.println(ris);
    }
}

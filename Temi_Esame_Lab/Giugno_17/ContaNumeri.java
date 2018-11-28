import java.util.*;
public class ContaNumeri
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        boolean virgola = false;
        int fl = 0;
        int inter = 0;
        while(in.hasNext())
        {
            String s = in.next();
            if(isNumber(s))
            {
                for (int i=0; i<s.length(); i++)
                {
                    if (!(Character.isDigit(s.charAt(i))))
                    {
                        virgola = true;
                        break;
                    }
                }
                if (virgola)
                    fl++;
                else
                    inter++;
            }
            virgola = false;
            System.out.println("ISNUMBER: "+isNumber(s));//TRACK
            //System.out.println("VIRGOLA: "+virgola);//TRACK
        }
        System.out.println("Interi: "+inter);
        System.out.println("Floating: "+fl);
    }
    public static boolean isNumber(String s)
    {
        int c = 1;
        int j = 0;
        if (Character.isDigit(s.charAt(0)))
        {
            for (int i=1; i<s.length(); i++)
            {
                char m = s.charAt(i);
                if (Character.isDigit(m) || (m == '.' && Character.isDigit(s.charAt(i+1))))
                {
                    c++;
                }
            }
            if (s.length() == c)
                return true;
            else
                return false;
        }
        else
            return false;
    }
}

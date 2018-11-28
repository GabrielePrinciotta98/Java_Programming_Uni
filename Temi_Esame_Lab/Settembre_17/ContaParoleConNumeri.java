import java.util.Scanner;
public class ContaParoleConNumeri
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int concifre = 0;
        int senzacifre = 0;
        int numerocifre = 0;
        while(in.hasNext())
        {
            String s = in.next();
            boolean withdigit = false;
            for (int i=0; i<s.length(); i++)
            {
                if (Character.isDigit(s.charAt(i)))
                {
                    numerocifre++;
                    withdigit = true;
                }
                if (withdigit && i == s.length()-1)
                    concifre++;
                if (withdigit == false && i == s.length()-1)
                    senzacifre++;
            }
        }
        System.out.println("Parole con cifre: "+concifre);
        System.out.println("Parole senza cifre: "+senzacifre);
        System.out.println("Numero totale di cifre: "+numerocifre);
    }
}

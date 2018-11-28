import java.util.*;
public class Vigenere
{
    public static void main(String[] args)
    {
        try
        {
            String chiave = args[0].toUpperCase();
            StringBuilder sb = new StringBuilder();
            Scanner in = new Scanner(System.in);
            int k = 0;
            while (in.hasNextLine())
            {
                String testo = in.nextLine().toUpperCase();
                for (int i=0; i<testo.length(); i++)
                {
                    if (Character.isLetter(testo.charAt(i)))
                    {
                        sb.append((char)((((testo.charAt(i) - 'A') + (chiave.charAt(k%chiave.length()) - 'A')) % 26)+ 'A'));
                        k++;
                    }
                    else
                        sb.append(testo.charAt(i));
                }
                sb.append('\n');
            }
            System.out.println(sb.toString());
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Chiave non fornita");
        }
    }
}

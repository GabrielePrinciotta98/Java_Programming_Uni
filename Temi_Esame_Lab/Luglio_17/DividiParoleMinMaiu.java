import java.util.*;
import java.io.*;
public class DividiParoleMinMaiu
{
    public static void main(String[] args)
    {
        String nomefile = args[0];
        File file = new File(nomefile);
        try
        {
            Scanner in = new Scanner(file);
            ArrayList<String> minuscola = new ArrayList<String>();
            ArrayList<String> maiuscola = new ArrayList<String>();
            boolean parolacorretta = true;
            while (in.hasNext())
            {
                String parola = in.next();
                parolacorretta = true;
                for (int i=0; i<parola.length(); i++)
                {
                    if (Character.isLetter(parola.charAt(i)) == false)
                    {
                        parolacorretta = false;
                        break;
                    }
                }
                if (parolacorretta == false)
                    continue;
                if (Character.isLowerCase(parola.charAt(0)) == true)
                    minuscola.add(parola);
                else
                    maiuscola.add(parola);
            }
            System.out.println("Iniziano con minuscole:");
            for (int i=0; i<minuscola.size(); i++)
                System.out.println(minuscola.get(i));
            System.out.println("Iniziano con maiuscole:");
            for (int i=0; i<maiuscola.size(); i++)
                System.out.println(maiuscola.get(i));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File inesistente");
        }
    }
}

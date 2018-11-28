import java.util.*;
import java.io.*;
public class SortParole
{
    public static void main(String[] args) throws FileNotFoundException
    {
        String nomefile = args[0];
        File file = new File(nomefile);
        Scanner in = new Scanner(file);
        ArrayList<String> parola = new ArrayList<String>();
        while(in.hasNext())
        {
            String s = in.next();
            parola.add(s);
        }
        parola.sort(String:: compareToIgnoreCase);
        for (int i=0; i<parola.size(); i++)
        {
            System.out.println(parola.get(i));
        }
    }
}

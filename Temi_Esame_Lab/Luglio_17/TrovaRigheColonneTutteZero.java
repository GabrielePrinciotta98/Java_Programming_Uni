import java.util.*;
import java.io.*;
public class TrovaRigheColonneTutteZero
{
    public static void main(String[] args)
    {
        String nomefile = args[0];
        File file = new File(nomefile);
        try
        {
            int cR = 1;
            int cC = 1;
            int altezza = 0;
            int larghezza;
            String s = "";
            boolean riganonzeri = false;
            boolean colonnanonzeri = false;
            ArrayList<String> riga = new ArrayList<String>();
            ArrayList<Integer> indiciR = new ArrayList<Integer>();
            ArrayList<Integer> indiciC = new ArrayList<Integer>();
            Scanner in = new Scanner(file);
            while (in.hasNextLine())
            {
                riga.add(in.nextLine());
                altezza++;
            }
            larghezza = riga.get(0).length();
            char[][] tabella = new char[altezza][larghezza];
            for (int i=0; i<altezza; i++)
            {
                s = riga.get(i);
                for (int j=0; j<larghezza; j++)
                {
                    tabella[i][j] = s.charAt(j);
                }
            }
            for (int i=0; i<altezza; i++)
            {
                riganonzeri = false;
                for(int j=0; j<larghezza; j++)
                {
                    if (tabella[i][j] != '0')
                        riganonzeri = true;
                    if (riganonzeri == false && i == altezza-1)
                        indiciR.add(i+1);
                }
            }
            for (int j=0; j<larghezza; j++)
            {
                colonnanonzeri = false;
                for (int i=0; i<altezza; i++)
                {
                    if(tabella[i][j] != '0')
                        colonnanonzeri = true;
                    if (colonnanonzeri == false && j == larghezza-1)
                        indiciC.add(j+1);
                }
            }
            System.out.println("Righe: ");
            for (int i=0; i<indiciR.size(); i++)
                System.out.println(indiciR.get(i));
            System.out.println("Colonne: ");
            for (int i=0; i<indiciC.size(); i++)
                System.out.println(indiciC.get(i));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File inesistente");
        }
    }
}

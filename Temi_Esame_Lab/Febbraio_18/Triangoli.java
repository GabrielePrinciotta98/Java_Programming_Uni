import java.util.*;
public class Triangoli
{
    public static void main(String[] args)
    {
        try
        {
            boolean datiValidi = true;
            boolean triangolo1;
            boolean triangolo2;
            boolean uguali = false;
            int[] tri1 = new int[3];
            int[] tri2 = new int[3];
            if (args.length != 6)
                datiValidi = false;
            for (int i=0; i<args.length; i++)
            {
                if (Integer.parseInt(args[i]) < 0)
                {
                    datiValidi = false;
                    break;
                }
                else
                    if (i < 3)
                        tri1[i] = Integer.parseInt(args[i]);
                    else
                        tri2[i-3] = Integer.parseInt(args[i]);
            }
            if (datiValidi == false)
                System.out.println("Dati non validi");
            else
            {
                triangolo1 = isTriangolo(tri1[0],tri1[1],tri1[2]);
                if (triangolo1)
                    System.out.println(Arrays.toString(tri1)+" è un triangolo");
                else
                    System.out.println(Arrays.toString(tri1)+" non è un triangolo");
                triangolo2 = isTriangolo(tri2[0],tri2[1],tri2[2]);
                if (triangolo2)
                    System.out.println(Arrays.toString(tri2)+" è un triangolo");
                else
                    System.out.println(Arrays.toString(tri2)+" non è un triangolo");
                if (triangolo1 && triangolo2)
                {
                    uguali = areEquals(tri1,tri2);
                    if (uguali)
                        System.out.println("Sono uguali");
                    else
                        System.out.println("Non sono uguali");
                }
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println("Dati non validi");
        }
    }

    public static boolean isTriangolo(int a, int b, int c)
    {
        if (a < b+c && b < a+c && c < a+b)
            return true;
        else
            return false;
    }

    public static boolean areEquals(int[] triangolo1, int[] triangolo2)
    {
        int c = 0;
        for (int i=0; i<3; i++)
        {
            for (int j=0; j<3; j++)
            {
                if (triangolo1[i] == triangolo2[j])
                {
                    c++;
                    break;
                }
            }
        }
        if (c == 3)
            return true;
        else
            return false;
    }
}

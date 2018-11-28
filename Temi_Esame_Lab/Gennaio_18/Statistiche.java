import java.util.*;
public class Statistiche
{
    public static void main(String[] args)
    {
        int[] data = {1,1,3,2,4,5,1,4,6,7,3,5,5,8,9,10,0,0,2,1};
        int[] frequenza = frequenze(data);
        System.out.println("serie di dati:");
        for (int x : data)
            System.out.print(x+" ");
        System.out.println("\nfrequenze:");
        for (int i=0; i<frequenza.length; i++)
            System.out.printf("%2d: %d\n", i, frequenza[i]);
        System.out.println("mediana: "+mediana(data)+'\n'); //dovrebbe stampare 3.5
    }

    public static int[] frequenze (int data[])
    {
        Arrays.sort(data);
        int c = 0;
        for (int i=1; i<data.length; i++)
        {
            if (data[i] != data[i-1])
                c++;
        }
        int[] ris = new int[c+1];
        int n = 1;
        int j = 0;
        for (int i=1; i<data.length; i++)
        {
            if (data[i] == data[i-1])
            {
                n++;
                ris[j] = n;
            }
            else
            {
                ris[j] = n;
                n = 1;
                j++;
            }
            if (data[i] != data[i-1] && i == data.length-1)
                ris[j] = 1;
        }
        return ris;
    }

    public static double mediana (int[] data)
    {
        double med;
        Arrays.sort(data);
        if (data.length % 2 != 0)
        {
            med = data[(int)(data.length / 2)];
        }
        else
        {
            med = (data[data.length / 2 - 1] + data[data.length / 2]) / 2.0;
        }
        return med;
    }
}

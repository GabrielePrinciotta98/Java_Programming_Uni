import java.util.*;
public class Test
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        ModelloLinguistico ita = new ModelloLinguistico();
        while (in.hasNextLine())
        {
            String s = in.nextLine();
            ita.addestra(s);
        }
        Istogramma isto1 = new Istogramma(100);
        System.out.println(isto1.toString(ita));
    }

}

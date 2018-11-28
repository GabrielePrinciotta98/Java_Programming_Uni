import java.util.*;
public class CostoAbbonamento
{
    public static void main(String[] args)
    {
        String sesso = args[0];
        int eta = Integer.parseInt(args[1]);
        System.out.println("SESSO: "+sesso);
        System.out.println("ETA: "+eta);
        if (!(sesso.equals("m")) && !(sesso.equals("M")) && !(sesso.equals("f")) && !(sesso.equals("F")))
            System.out.println("Input non valido");
        if (sesso.equals("m") || sesso.equals("M"))
        {
            if (eta <= 10 || eta > 75)
                System.out.println("Per te abbonamento gratis");
            else
                if((eta > 10 && eta < 26) || (eta >= 65 && eta <=75))
                    System.out.println("Costo abbonamento: 10,00 euro");
                else
                    System.out.println("Costo abbonamento: 18,50 euro");
        }
        //if (sesso == "f" || sesso == "F")
        else
        {
            if (eta <= 14 || eta > 75)
                System.out.println("Per te abbonamento gratis");
            else
                if((eta > 14 && eta < 31) || (eta >= 65 && eta <=75))
                    System.out.println("Costo abbonamento: 10,00 euro");
                else
                    System.out.println("Costo abbonamento: 18,50 euro");
        }
    }
}

import java.util.*;
public class Test
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Dispensa dispensa = new Dispensa();
        while (in.hasNext())
        {
            String s = in.next();
            boolean isProdotto = true;
            for (int i=0; i<s.length(); i++)
            {
                if (Character.isDigit(s.charAt(i)))
                {
                    isProdotto = false;
                    break;
                }
            }
            if (isProdotto)
            {
                Prodotto p = new Prodotto(s);
                dispensa.getProdotti().add(p);
            }
            else
                dispensa.getQuantita().add(Integer.parseInt(s));
        }
        for (int i=0; i<dispensa.getProdotti().size(); i++)
            dispensa.scortaMinima(dispensa.getProdotti().get(i), 3);
        System.out.println(dispensa.toString());
        ListaDellaSpesa lista = dispensa.preparaLista();
        System.out.println(lista.toString());

    }
}

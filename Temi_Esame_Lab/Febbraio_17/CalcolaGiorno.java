public class CalcolaGiorno
{
    public static void main(String[] args)
    {
        try
        {
            int giorno = Integer.parseInt(args[0]);
            int mese = Integer.parseInt(args[1]);
            int anno = Integer.parseInt(args[2]);
            int giornoAnno = 0;
            if (mese > 12 || mese <= 0 || giorno <= 0)
                System.out.println("errore");
            else
                if (giorno >=31 && giorniMese(mese,anno) == 30 || giorno > 31 && giorniMese(mese,anno) == 31)
                    System.out.println("errore");
                else
                    if (!(isBisestile(anno)) && mese == 2 && giorno >= 29 || giorniMese(mese,anno) == 29 && giorno >= 30)
                        System.out.println("errore");
            //System.exit(1);
            if(mese != 1)
            {
                for (int i=1; i<mese; i++)
                {
                    giornoAnno += giorniMese(i,anno);
                }
                giornoAnno += giorno;
            }
            else
                giornoAnno += giorno;
            System.out.println(giornoAnno);
        }
        catch (NumberFormatException e)
        {
            System.out.println("errore");
        }
    }


    public static boolean isBisestile(int anno)
    {
        if ((anno % 4 == 0 && anno % 100 != 0) || (anno % 100 == 0 && anno % 400 == 0))
            return true;
        else
            return false;
    }


    public static int giorniMese(int mese, int anno)
    {
        int n;
        switch (mese)
        {
            case 4: n = 30;
                    break;
            case 6: n = 30;
                    break;
            case 9: n = 30;
                    break;
            case 11: n = 30;
                    break;
            case 2: if(isBisestile(anno))
                        n = 29;
                    else
                        n = 28;
                    break;
            default: n = 31;
        }
        return n;
    }
}

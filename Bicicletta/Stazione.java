public class Stazione
{
    private String nome;
    private double x;
    private double y;
    private int nPosti;
    private boolean elettriche;
    private Bicicletta[] bicicletta;

    public Stazione(String nome, double x, double y, int posizioni, boolean elettriche)
    {
        this.nome = nome;
        this.x = x;
        this.y = y;
        this.nPosti = posizioni;
        this.elettriche = elettriche;
        this.bicicletta = new Bicicletta[this.nPosti];
    }

    public int nPosizioni()
    {
        return this.nPosti;
    }

    public int nBiciclette()
    {
        int c = 0;
        for (Bicicletta x : bicicletta)
        {
            if (x != null)
                c++;
        }
        return c;
    }

    public boolean piena()
    {
        return this.nBiciclette() == this.nPosti;
    }

    public boolean vuota()
    {
        return this.nBiciclette() == 0;
    }

    public boolean ammetteElettriche()
    {
        return this.elettriche;
    }

    public boolean ciSonoElettriche()
    {
        boolean elettrica = false;
        for (int i=0; i<bicicletta.length; i++)
        {
            if (bicicletta[i].elettrica())
            {
                elettrica = true;
                break;
            }
        }
        return elettrica;
    }

    public Bicicletta posizione(int i)
    {
        return this.bicicletta[i];
    }

    public void aggancia(Utente u, int i) throws IllegalStateException
    {
        if (bicicletta[i] == null && u.bicicletta() != null)
        {
            bicicletta[i] = u.bicicletta();
            u.bicicletta().restituisci();
            u.restituisci();
        }
        else
            throw new IllegalStateException();
    }

    public void prendi(Utente u, int i) throws IllegalStateException
    {
        if (bicicletta[i] != null && u.bicicletta() == null)
        {
            u.prendiInUso(bicicletta[i]);
            bicicletta[i].daiInUso(u);
        }
        else
            throw new IllegalStateException();
    }

    public int disponibile(boolean elettrica)
    {
        if (elettrica && this.ciSonoElettriche())
        {
            for (int i=0; i<bicicletta.length; i++)
            {
                if (bicicletta[i] != null && bicicletta[i].elettrica())
                {
                    return i;
                }
            }
        }
        else
            if (elettrica == false)
            {
                for (int i=0; i<bicicletta.length; i++)
                {
                    if (bicicletta[i] != null)
                    {
                        return i;
                    }
                }
            }
        return -1;
    }

    public double distanzaDa(double x, double y)
    {
        return Math.sqrt((this.y - y)*(this.y - y) + (this.x - x)*(this.x - x));
    }

    public static Stazione cerca(Stazione[] s, boolean elettrica, double x, double y)
    {
        Stazione ris = null;
        double min = Double.MAX_VALUE;
        for (int i=0; i<s.length; i++)
        {
            if (s[i].disponibile(elettrica) != -1)
            {
                if (s[i].distanzaDa(x,y) < min)
                {
                    ris = s[i];
                    min = s[i].distanzaDa(x,y);
                }
            }
        }
        return ris;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.nome+'\n');
        sb.append("Locazione: "+ Double.toString(this.x) + ","+Double.toString(this.y));
        sb.append('\n');
        sb.append("Numero posti: "+Integer.toString(this.nPosti)+ '\n');
        if (this.ammetteElettriche())
            sb.append("ammette bici elettriche");
        else
            sb.append("non ammette bici elettriche");
        return sb.toString();
    }
}

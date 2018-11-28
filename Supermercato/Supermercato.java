import java.util.*;
public class Supermercato
{
    private ArrayList<Prodotto> prodotti;
    private ArrayList<Offerta> offerte;
    private ArrayList<Reparto> reparti;

    public Supermercato()
    {
        this.prodotti = new ArrayList<Prodotto>();
        this.offerte = new ArrayList<Offerta>();
        this.reparti = new ArrayList<Reparto>();
    }

    public void aggiungiReparto(Reparto r)
    {
        reparti.add(r);
    }

    public void aggiungiProdotto(Prodotto p)
    {
        prodotti.add(p);
    }

    public boolean cancellaProdotto(Prodotto p)
    {
        return prodotti.remove(p);
    }

    public void aggiungiOfferta(Offerta o)
    {
        offerte.add(o);
    }

    public boolean cancellaOfferta(Offerta o)
    {
        return offerte.remove(o);
    }

    public double prezzo(Prodotto[] p, boolean carta)
    {
        double tot = 0;
        Offerta[] off = new Offerta[this.offerte.size()];
        for (int i=0; i<this.offerte.size(); i++)
            off[i] = this.offerte.get(i);
        for (int i=0; i<off.length; i++)
        {
            tot += Offerta.totale(off,p,Supermercato.calcolaQuantita(p),carta);
        }
        return tot;
    }

    public static int[] calcolaQuantita(Prodotto[] p)
    {
        int[] frequenze = new int[p.length];
        int c = 1;
        for (int i=1; i<p.length; i++)
        {
            if (p[i] == p[i-1])
                c++;
            else
            {
                frequenze[i] = c;
                c = 1;
                break;
            }
            if (i == p.length-1 && c == 1)
                frequenze[i] = c;
        }
        return frequenze;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista prodotti: "+'\n');
        for (int i=0; i<prodotti.size(); i++)
            sb.append(prodotti.get(i)+" ");
        sb.append("Lista reparti: "+ '\n');
        for (int i=0; i<reparti.size(); i++)
            sb.append(reparti.get(i)+" ");
        sb.append("Lista offerte: "+ '\n');
        for (int i=0; i<offerte.size(); i++)
            sb.append(offerte.get(i)+" ");
        sb.append('\n');
        return sb.toString();
    }
}

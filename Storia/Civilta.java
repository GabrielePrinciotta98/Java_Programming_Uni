import java.util.*;
public class Civilta
{
    private String nome;
    private ArrayList<Citta> citta = new ArrayList<Citta>();
    private int tesoro;
    private ArrayList<Risorsa> stock = new ArrayList<Risorsa>();

    public Civilta(String nome)
    {
        this.nome = nome;
        ArrayList<Citta> citta = new ArrayList<Citta>();
        this.citta = citta;
        this.tesoro = 0;
        ArrayList<Risorsa> stock = new ArrayList<Risorsa>();
        this.stock = stock;
    }

    public Citta fondaCitta(String nome, Risorsa risorsa)
    {
        Citta citta = new Citta(nome, risorsa);
        this.citta.add(citta);
        return citta;
    }

    public void aggiungiRisorsa(Risorsa r)
    {
        stock.add(r);
    }

    public ArrayList<Risorsa> getStock()
    {
        return this.stock;
    }

    public void aggiungiDenaro(int d)
    {
        this.tesoro += d;
    }

    public void faiProdurre()
    {
        for (int i=0; i<this.citta.size(); i++)
            stock.add(citta.get(i).produci());
    }

    public boolean possiede(Risorsa r)
    {
        boolean possiede = false;
        for (int i=0; i<this.stock.size(); i++)
        {
            if (stock.get(i).equals(r))
                possiede = true;
            else
                possiede = false;
        }
        return possiede;
    }

    public boolean vendiRisorseA(Civilta altra)
    {
        boolean commercioAvvenuto = false;
        ArrayList<Risorsa> stockAltra = altra.getStock();
        for (int i=0; i<this.stock.size(); i++)
        {
            Risorsa r = this.stock.get(i);
            if (altra.possiede(r) == false)
            {
                stockAltra.add(r);
                altra.aggiungiDenaro(r.getPrezzo());
                commercioAvvenuto = true;
            }
        }
        return commercioAvvenuto;
    }

    public boolean equals(Object x)
    {
        if (!(x instanceof Civilta))
            return false;
        Civilta c = (Civilta)(x);
        return this.nome.equals(c.nome);
    }

    public int hashCode()
    {
        int sommaChar = 0;
        for (int i=0; i<this.nome.length(); i++)
            sommaChar += (int)(this.nome.charAt(i));
        return sommaChar;
    }

    public int getTesoro()
    {
        return this.tesoro;
    }

    public ArrayList<Citta> getCitta()
    {
        return this.citta;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.nome);
        sb.append(',');
        sb.append(this.tesoro + " di denaro");
        sb.append('\n');
        sb.append("Citta possedute:");
        sb.append('\n');
        if (this.citta.size() != 0)
        {
            for (int i=0; i<this.citta.size(); i++)
                sb.append(citta.get(i).toString());
        }
        else
            sb.append("nessuna citta");
        sb.append('\n');
        sb.append("Risorse possedute:");
        sb.append('\n');
        if (this.stock.size() != 0)
        {
            for (int i=0; i<this.stock.size(); i++)
                sb.append(stock.get(i).toString());
        }
        else
            sb.append("nessuna risorsa");
        return sb.toString();
    }
}

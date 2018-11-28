public class Risorsa
{
    private String nome;
    private int prezzo;

    public Risorsa(String s, int n)
    {
        this.nome = s;
        this.prezzo = n;
    }

    public int getPrezzo()
    {
        return this.prezzo;
    }

    public String getNome()
    {
        return this.nome;
    }

    public boolean equals(Object x)
    {
        if (!(x instanceof Risorsa))
            return false;
        Risorsa r = (Risorsa)(x);
        return this.nome.equals(r.nome);
    }

    public int hashCode()
    {
        int sommaChar = 0;
        for (int i=0; i<this.nome.length(); i++)
            sommaChar += (int)(this.nome.charAt(i));
        return sommaChar + this.prezzo;
    }

    public String toString()
    {
        return " "+this.nome;
    }
}

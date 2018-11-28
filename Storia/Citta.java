public class Citta
{
    private String nome;
    private Risorsa r;

    public Citta(String nome, Risorsa r)
    {
        this.nome = nome;
        this.r = r;
    }

    public Risorsa produci()
    {
        return this.r;
    }

    public String toString()
    {
        return this.nome+", che produce: "+this.r.toString();
    }
}

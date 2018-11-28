/**Le istanze di questa classe rappresentano i prodotti di una
*  dispensa familiare.
*  @author Gabriele Princiotta
*/
public class Prodotto
{
    private String nome;

    /**Costruisce un Prodotto a partire dal nome
    *  @param nome il nome del Prodotto
    */
    public Prodotto(String nome)
    {
        this.nome = nome;
    }

    /**Restituisce il Prodotto su cui è invocato sotto forma di stringa
    *  @return l'oggetto sotto forma di stringa
    *  @override
    */
    public String toString()
    {
        return this.nome;
    }

    /**Verifica se due Prodotti sono uguali
    *  @param x l'oggetto con cui si confronta il Prodotto su cui è invocato.
    *  @return <code>true</code> se i due oggetti sono uguali, <code>false</code> altrimenti.
    *  @override
    */
    public boolean equals(Object x)
    {
        if (!(x instanceof Prodotto))
            return false;
        Prodotto p = (Prodotto)(x);

        return this.nome.toLowerCase().equals(p.nome.toLowerCase());
    }

    /**Restituisce l'hashCode del Prodotto su cui è invocato
    *  @return l'hashCode del Prodotto
    */
    public int hashCode()
    {

        int sommaChar = 0;
        String s = this.nome.toLowerCase();
        for (int i=0; i<s.length(); i++)
            sommaChar += s.charAt(i);
        return sommaChar;
    }
}

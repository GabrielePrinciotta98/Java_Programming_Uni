/**Le istanze di questa classe sono biciclette.Ogni bicicletta è identificata
*  da un identificatore e può essere o meno elettrica. In ogni istante la
*  bicicletta può essere libera o in uso a un utente.
*  @author Gabriele Princiotta
*/
public class Bicicletta
{
    private String id;
    private boolean elettrica;
    private boolean libera;
    private Utente utente;

    /**crea una bicicletta libera con identificatore dato,la bicicletta è elettrica solo se il booleano è true.
    *  @param id la stringa identificativa della bicicletta
    *  @param elettrica
    */
    public Bicicletta(String id, boolean elettrica)
    {
        this.id = id;
        this.elettrica = elettrica;
        this.libera = true;
        this.utente = null;
    }

    /**Restituisce true se e solo se la bicicletta è elettrica.
    *  @return <code>true</code> se la bicicletta è elettrica, <code>false</code> altrimenti.
    */
    public boolean elettrica()
    {
        return this.elettrica;
    }

    public void daiInUso(Utente x) throws IllegalStateException
    {
        if (this.libera)
        {
            this.libera = false;
            this.utente = x;
            x.getHaInUso() = true;
            x.bicicletta8 = this;
        }
        else
            throw new IllegalStateException();
    }

    public void restituisci() throws IllegalStateException
    {
        if (this.libera == false)
        {
            this.libera = true;
            this.utente = null;
            this.utente.haInUso = false;
            this.utente.biciInUso = null;
        }
        else
            throw new IllegalStateException();
    }

    public Utente utente()
    {
        return this.utente;
    }

    /**Restituisce una bicicletta sotto forma di stringa
    *  @return l'oggetto su cui è invocato sotto forma di stringa
    *  @override
    */
    public String toString()
    {
        String elet = "";
        String usata = "";
        if (this.elettrica)
            elet = "elettrica ";
        else
            elet = "Non elettrica ";
        if (this.libera == false)
            usata = "in uso da " + this.utente.getNominativoUtente();
        else
            usata = "attualmente libera";
        return this.id + ", "+elet+usata;
    }

    public String getId()
    {
        return this.id;
    }

    /**Restituisce <code>true</code> se e solo i due oggetti sono uguali
    *  @param x l'oggetto con cui si vuole confrontare questo oggetto
    *  @return <code>true</code> se i due oggetti sono uguali, <code>false</code> altrimenti
    */
    public boolean equals(Object x)
    {
        if (!(x instanceof Bicicletta))
            return false;
        Bicicletta b = (Bicicletta)(x);
        return this.id.equals(b.id);
    }

    public int hashCode()
    {
        int sommaChar = 0;
        for (int i=0; i<this.id.length(); i++)
            sommaChar += this.id.charAt(i);
        return sommaChar;
    }

    public boolean getLibera()
    {
        return this.libera;
    }
}

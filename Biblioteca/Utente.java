/**Le istanze di questa classe rappresentano gli utenti della biblioteca.
*  @author Gabriele Princiotta*/
public class Utente
{
    private String nome;
    private String cognome;
    private Data dataDiNascita;
    private int id;

    /**Costruisce un utente con i dati indicati
    *  @param nome il nome dell'utente
    *  @param cognome il cognome dell'utente
    *  @param dataDiNascita la data di nascita dell'utente*/
    public Utente(String nome, String cognome, Data dataDiNascita)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
    }

    /**Restituisce sotto forma di strigna l'utente su cui è invocato
    *  @return l'oggeto sotto forma di stringa
    *  @override*/
    public String toString()
    {
        return this.nome + " " + this.cognome + ", nato il " + this.dataDiNascita.toString();
    }

    /**verifica se due libri sono uguali
    *  @param x l'oggetto con cui si vuole confrontare il libro su cui è invocato
    *  @return <code>true</code> se i due oggetti sono uguali, <code>false</code> altrimenti.*/
    public boolean equals(Object x)
    {
        if (!(x instanceof Utente))
            return false;
        Utente u = (Utente)(x);
        int id1 = this.hashCode();
        int id2 = u.hashCode();
        return id1 == id2;
    }

    /**Restituisce l'hashCode dell'Utente su cui è invocato
    *  @return l'hashCode dell'utente
    *  @override*/
    public int hashCode()
    {
        int sommaChar = 0;
        for (int i=0; i<this.nome.length(); i++)
            sommaChar += this.nome.charAt(i);
        for (int i=0; i<this.cognome.length(); i++)
            sommaChar += this.cognome.charAt(i);
        this.id = sommaChar + this.dataDiNascita.getGiorno() + this.dataDiNascita.getMese() + this.dataDiNascita.getAnno();
        return sommaChar + this.dataDiNascita.getGiorno() + this.dataDiNascita.getMese() + this.dataDiNascita.getAnno();
    }
}

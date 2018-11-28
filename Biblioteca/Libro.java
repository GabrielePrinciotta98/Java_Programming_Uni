import java.util.*;
/**Le istanze di questa classe rappresentano i libri posseduti
*  dalla biblioteca.
*  @author Gabriele Princiotta*/
public class Libro
{
    private String titolo;
    private String[] autori;
    private int id;
    private boolean prestabile;

    /**Costruisce un libro con i dati indicati.
    *  @param titolo il titolo del libro
    *  @param autori la lista degli autori
    *  @param prestabile un booleano che è true solo se è possibile dare in prestito questo libro.*/
    public Libro(String titolo, String[] autori, boolean prestabile)
    {
        this.titolo = titolo;
        this.autori = autori;
        this.prestabile = prestabile;
    }

    /**Costruisce un libro con un solo autore
    *  @param titolo il titolo del libro
    *  @param autore il nome dell'autore
    *  @param prestabile un booleano che è true solo se è possibile dare in prestito questo libro.*/
    public Libro(String titolo, String autore, boolean prestabile)
    {
        String[] autori = {autore};
        this.titolo = titolo;
        this.autori = autori;
        this.prestabile = prestabile;
    }

    /**Costruisce un libro prestabile con i dati indicati
    *  @param titolo il titolo del libro
    *  @param autori la lista degli autori*/
    public Libro(String titolo, String[] autori)
    {
        this(titolo,autori,true);
    }

    /**Costruisce un libro prestabile con un solo autore.
    *  @param titolo il titolo del libro
    *  @param autore il nome dell'autore*/
    public Libro(String titolo, String autore)
    {
        this(titolo, autore, true);
    }


    public String getTitolo()
    {
        return this.titolo;
    }

    public boolean getPrestabile()
    {
        return this.prestabile;
    }
    
    /**Restituisce sotto forma di stringa il libro su cui è invocato.
    *  @return l'oggetto sotto forma di stringa
    *  @override */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.titolo);
        sb.append('\n');
        for (int i=0; i<autori.length; i++)
            sb.append(autori[i]+" ");
        sb.append('\n');
        if (this.prestabile)
            sb.append("prestabile");
        else
            sb.append("non prestabile");
        return sb.toString();
    }

    /**verifica se due libri sono uguali
    *  @param x l'oggetto con cui si vuole confrontare il libro su cui è invocato
    *  @return <code>true</code> se i due oggetti sono uguali, <code>false</code> altrimenti.
    *  @override*/
    public boolean equals(Object x)
    {
        if (!(x instanceof Libro))
            return false;
        Libro l = (Libro)(x);
        int id1 = this.hashCode();
        int id2 = l.hashCode();
        return id1 == id2;
    }

    /**Restituisce l'hashCode del Libro su cui è invocato
    *  @return l'hashCode del libro
    *  @override*/
    public int hashCode()
    {
        int sommaChar = 0;
        for (int i=0; i<this.titolo.length(); i++)
            sommaChar += this.titolo.charAt(i);
        this.id = sommaChar;
        return sommaChar;
    }
}

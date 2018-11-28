import java.util.*;
/**Un prestito rappresenta il prestito di un libro a un certo
*  utente, attuato da una certa data a un'altra data.
*  @author Gabriele Princiotta.*/
public class Prestito
{
    private Libro x;
    private Utente u;
    private Data da;
    private Data a;

    /**Crea un prestito per il libro x , che viene dato all'utente u
    *  dalla data da (compresa) alla data a (esclusa).
    *  @param x il libro prestato
    *  @param u l'utente che richiede il prestito
    *  @param da la data di inizio prestito
    *  @param a la data di fine prestito*/
    public Prestito(Libro x, Utente u, Data da, Data a)
    {
        this.x = x;
        this.u = u;
        this.da = da;
        this.a = a;
    }

    /**Crea un prestito per il libro x , che viene dato
    *  all'utente u dalla data da (compresa) alla data
    *  ottenuta invocando il metodo successiva() su da.
    *  @param x il libro prestato
    *  @param u l'utente che richiede il prestito
    *  @param da la data di inizio prestito*/
    public Prestito(Libro x, Utente u, Data da)
    {
        this(x,u,da,da.successiva());
    }

    /**Restituisce true se e solo se il prestito su cui è
    *  invocato riguarda il libro passato come argomento.
    *  @param t il libro di cui si vuole verificare il prestito
    *  @return true or false*/
    public boolean riguardaLibro(Libro t)
    {
        return this.x.equals(t);
    }

    /**Restituisce true se e solo se la data passata come
    *  argomento rientra nel periodo per cui vale questo prestito.
    *  @param d data di cui si vuole verificare il prestito
    *  @return true or false*/
    public boolean riguardaData(Data d)
    {
        if (d.vienePrimaDi(this.a) && d.vienePrimaDi(this.da) == false)
            return true;
        else
            return false;
    }

    /**Restituisce l'utente del prestito su cui è invocato.
    *  @return l'utente del prestito*/
    public Utente getUtente()
    {
        return this.u;
    }

    public Libro getLibro()
    {
        return this.x;
    }

    /**Restituisce il prestito sotto forma di stringa
    *  @return l'oggetto sotto forma di stringa
    *  @override*/
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Libro prestato: "+'\n');
        sb.append(this.x.toString());
        sb.append('\n');
        sb.append("all'utente:"+ '\n');
        sb.append(this.u.toString());
        sb.append('\n');
        sb.append("dal:"+ '\n');
        sb.append(this.da.toString());
        sb.append('\n');
        sb.append("al:"+ '\n');
        sb.append(this.a.toString());
        return sb.toString();
    }
}

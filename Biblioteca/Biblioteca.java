import java.util.*;
/**Le istanze di questa classe rappresentano biblioteche, ciascuna
*  con un nome, una listi di libri, una lista di utenti, una lista di prestiti
*  @author Gabriele Princiotta*/
public class Biblioteca
{
    private String nome;
    private ArrayList<Libro> libri;
    private ArrayList<Utente> utenti;
    private ArrayList<Prestito> prestiti;

    /**Costriusce una biblioteca il cui nome è passato come argomento
    *  @param nome il nome della biblioteca*/
    public Biblioteca(String nome)
    {
        this.nome = nome;
        this.libri = new ArrayList<Libro>();
        this.utenti = new ArrayList<Utente>();
        this.prestiti = new ArrayList<Prestito>();
    }

    /**Aggiunge l'utente specificato.
    *  @param x il nuovo utente*/
    public void nuovoUtente(Utente x)
    {
        this.utenti.add(x);
    }

    /**Aggiunge il libro specificato.
    *  @param x il nuovo libro*/
    public void nuovoLibro(Libro x)
    {
        this.libri.add(x);
    }

    /**Restituisce il numero di utenti.
    *  @return il numero di utenti*/
    public int numeroUtenti()
    {
        return this.utenti.size();
    }

    /**Restituisce il numero di libri.
    *  @return il numero di libri*/
    public int numeroLibri()
    {
        return this.libri.size();
    }

    /**Restituisce l'array di libri che contengono nel titolo
    *  la stringa x.
    *  @param x la stringa che può essere contenuta nel titolo
    *  @return l'array dei libri che contengono x*/
    public Libro[] cercaLibro(String x)
    {
        ArrayList<Libro> libriTrovati = new ArrayList<Libro>();
        for (int i=0; i<this.libri.size(); i++)
        {
            if (this.libri.get(i).getTitolo().contains(x))
                libriTrovati.add(this.libri.get(i));
        }
        Libro[] out = new Libro[libriTrovati.size()];
        for (int i=0; i<libriTrovati.size(); i++)
            out[i] = libriTrovati.get(i);
        return out;
    }

    /**Restituisce true se e solo se il libro è prestabile e nessun
    *  prestito che riguarda questo libro copre la data di oggi.
    *  @param x il libro su cui si vuole verificare
    *  @return <code>true</code> se il libro è disponibile, <code>false</code> altrimenti*/
    public boolean disponibile(Libro x)
    {
        Data oggi = new Data();
        boolean disponibile = true;
        ArrayList<Prestito> prestitiDiX = new ArrayList<Prestito>();
        for (int i=0; i<this.prestiti.size(); i++)
        {
            if (this.prestiti.get(i).riguardaLibro(x))
                prestitiDiX.add(this.prestiti.get(i));
        }
        for (int i=0; i<prestitiDiX.size(); i++)
        {
            if (x.getPrestabile() && prestitiDiX.get(i).riguardaData(oggi) == false)
            {
                disponibile = true;
                break;
            }
            else
                disponibile = false;
        }
        return disponibile;
    }

    /**Restituisce il numero di prestiti dell'utente x alla data
    *  attuale.
    *  @param x l'utente di cui si vuole verificare il numero di prestiti
    *  @return il numero di prestiti di x*/
    public int quantiPrestiti(Utente x)
    {
        int c = 0;
        for (int i=0; i<this.prestiti.size(); i++)
        {
            if (this.prestiti.get(i).getUtente().equals(x))
                c++;
        }
        return c;
    }

    /**Controlla se il libro x può essere dato in prestito
    *  oggi e se l'utente u non ha più di 4 prestiti attivi;
    *  se una di queste due condizioni è falsa, restituisce false.
    *  Altrimenti, crea il prestito con i dati indicati (da oggi
    *  fino alla data finoA) e l'aggiunge alla lista dei prestiti.
    *  @param x il libro da controllare
    *  @param u l'utente da controllare
    *  @param finoA la data di fine prestito se il prestito viene effettuato
    *  @return <code>true</code> se il prestito è avvenuto, <code>false</code> altrimenti.*/
    public boolean daiInPrestito(Libro x, Utente u, Data finoA)
    {
        Data oggi = new Data();
        if (this.disponibile(x) && this.quantiPrestiti(u) <= 4)
        {
            Prestito nuovo = new Prestito(x,u,oggi,finoA);
            this.prestiti.add(nuovo);
            return true;
        }
        else
            return false;
    }

    /**Controlla se il libro x può essere dato in prestito
    *  oggi e se l'utente u non ha più di 4 prestiti attivi;
    *  se una di queste due condizioni è falsa, restituisce false.
    *  Altrimenti, crea il prestito da oggi fino alla data
    *  successiva() e l'aggiunge alla lista dei prestiti.
    *  @param x il libro da controllare
    *  @param u l'utente da controllare
    *  @return <code>true</code> se il prestito è avvenuto, <code>false</code> altrimenti.*/
    public boolean daiInPrestito(Libro x, Utente u)
    {
        Data oggi = new Data();
        if (this.disponibile(x) && this.quantiPrestiti(u) <= 4)
        {
            Prestito nuovo = new Prestito(x,u,oggi,oggi.successiva());
            this.prestiti.add(nuovo);
            return true;
        }
        else
            return false;
    }

    /**Restituisce l'utente che ha attualmente in prestito il
    *  libro indicato (oppure null se il libro non è attualmente
    *  in prestito).
    *  @param x il libro che si vuole verificare
    *  @return l'utente in possesso del libro x*/
    public Utente chiHaInPrestito(Libro x)
    {
        Utente u = null;
        for (int i=0; i<this.prestiti.size(); i++)
        {
            if (this.prestiti.get(i).getLibro().equals(x))
                u = this.prestiti.get(i).getUtente();
        }
        return u;
    }

    /**Restituisce la Biblioteca sotto forma di stringa
    *  @return l'oggetto sotto forma di stringa
    *  @override*/
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.nome + '\n');
        sb.append("Lista libri: " +'\n');
        for (int i=0; i<this.libri.size(); i++)
            sb.append(this.libri.get(i).toString() +" ");
        sb.append("Lista utenti: " +'\n');
        for (int i=0; i<this.utenti.size(); i++)
            sb.append(this.utenti.get(i).toString() +" ");
        sb.append("Lista prestiti: " +'\n');
        for (int i=0; i<this.prestiti.size(); i++)
            sb.append(this.prestiti.get(i).toString() +" ");
        return sb.toString();
    }
}

import java.util.*;
/**Gli oggetti di questa classe rappresentano delle dispense familiari.
*  @author Gabriele Princiotta
*/
public class Dispensa
{
    private ArrayList<Prodotto> prodotti;
    private ArrayList<Integer> quantitaPresente;
    private ArrayList<Integer> quantitaScorta;

    /**Crea una Dispensa vuota
    */
    public Dispensa()
    {
        this.prodotti = new ArrayList<Prodotto>();
        this.quantitaPresente = new ArrayList<Integer>();
        this.quantitaScorta = new ArrayList<Integer>();
    }

    /**stabilisce che il prodotto p abbia quantità minima q (se era stata
    *  precedentemente fissata un'altra quantità minima per quel prodotto,
    *  ora essa verrà modificata).
    *  @param p il Prodotto di cui si vuole modificare la quantità minima
    *  @param q la quantità minima di p
    */
    public void scortaMinima(Prodotto p, int q)
    {
        this.quantitaScorta.add(this.prodotti.indexOf(p),q);
    }

    /**Restituisce la quantità presente in dispensa del prodotto p
    *  @param p il prodotto di cui si vuole conoscere la quantità
    *  @return la quantità di p in dispensa
    */
    public int qta(Prodotto p)
    {
        return this.quantitaPresente.get(this.prodotti.indexOf(p));
    }

    /**assume che una quantità q del prodotto p sia stata consumata;
    *  se la dispensa contiene meno di q unità di quel prodotto, questo metodo solleva
    *  l'eccezione (non controllata) NoSuchElementException.
    *  @param p il prodotto da consumare
    *  @param q la quantità da consumare di p
    *  @throws NoSuchElementException se la dispensa contiene meno di q unità di p
    */
    public void consuma(Prodotto p, int q) throws NoSuchElementException
    {
        int n = this.quantitaPresente.get(this.prodotti.indexOf(p));
        if (this.quantitaPresente.get(this.prodotti.indexOf(p)) < q)
            throw new NoSuchElementException();
        n -= q;
        this.quantitaPresente.set(this.prodotti.indexOf(p), n);
    }

    /**Restituisce una lista della spesa, contenente tutti i prodotti la cui
    *  quantità in dispensa è inferiore alla quantità minima prevista.
    */
    public ListaDellaSpesa preparaLista()
    {
        ListaDellaSpesa lista = new ListaDellaSpesa();
        for (int i=0; i<prodotti.size(); i++)
        {
            if (this.quantitaPresente.get(i) < this.quantitaScorta.get(i))
            {
                lista.aggiungi(this.prodotti.get(i), this.quantitaScorta.get(i) - this.quantitaPresente.get(i));
            }
        }
        return lista;
    }
    /**la lista è stata acquistata, e i prodotti vengono
    *  tolti dai sacchetti e messi nella dispensa.
    *  @param s la lista della spesa effettuata
    */
    public void riponi(ListaDellaSpesa s)
    {

    }

    /**Restituisce la Dispensa su cui è invocato sotto forma di stringa
    *  @return l'oggetto sotto forma di stringa
    *  @override
    */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Prodotti presenti:" + '\n');
        for (Prodotto x : prodotti)
            sb.append(x.toString() + " ");
        sb.append('\n');
        sb.append("Quantita presente:" + '\n');
        for (int y : quantitaPresente)
            sb.append(Integer.toString(y) + " ");
        sb.append('\n');
        sb.append("Scorte minime:" + '\n');
        for (int y : quantitaScorta)
            sb.append(Integer.toString(y) + " ");
        sb.append('\n');
        return sb.toString();
    }

    public ArrayList<Prodotto> getProdotti()
    {
        return this.prodotti;
    }

    public ArrayList<Integer> getQuantita()
    {
        return this.quantitaPresente;
    }
}

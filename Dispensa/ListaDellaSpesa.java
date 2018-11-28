import java.util.*;
/**Le istanze di questa classe sono liste della spesa (elenchi di prodotti
*  con associata la quantità da acquistare).
*  @author Gabriele Princiotta
*/
public class ListaDellaSpesa
{
    private ArrayList<Prodotto> prodotti;
    private ArrayList<Integer> quantita;

    /**crea una lista della spesa vuota.
    */
    public ListaDellaSpesa()
    {
        this.prodotti = new ArrayList<Prodotto>();
        this.quantita = new ArrayList<Integer>();
    }

    /**aggiunge la quantità q del prodotto p alla lista.
    *  @param p il Prodotto da aggiungere
    *  @param q la quantità di p da aggiungere
    */
    public void aggiungi(Prodotto p, int q)
    {
        this.prodotti.add(p);
        this.quantita.add(q);
    }

    /**restituisce un array con tutti i prodotti che compaiono nella lista.
    *  @return un ArrayList con tutti i prodotti della lista su cui è invocato
    */
    public ArrayList<Prodotto> prodotti()
    {
        return this.prodotti;
    }

    /**Restituisce la ListaDellaSpesa su cui è invocato sotto forma di stringa
    *  @return l'oggetto sotto forma di stringa
    *  @override
    */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Prodotti da comprare:"+ '\n');
        for (Prodotto x : prodotti)
            sb.append(x.toString() + " ");
        sb.append('\n');
        for (int y : quantita)
            sb.append(Integer.toString(y) + " ");
        sb.append('\n');
        return sb.toString();
    }


}

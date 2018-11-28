import java.util.*;
/**Le istanze di questa classe sono date
*  @author Gabriele Princiotta*/
public class Data
{
    private int giorno;
    private int mese;
    private int anno;
    /**Costruisce una data a partire da i tre argomenti numerici passati
    *  per argomento.
    *  @param g il giorno (deve essere compreso tra 1 e 31)
    *  @param m il mese (deve essere compreso tra 1 e 12)
    *  @param a l'anno */
    public Data(int g, int m, int a)
    {
        this.giorno = g;
        this.mese = m;
        this.anno = a;
    }
    /**Costruisce una data senza alcun argomento*/
    public Data()
    {
        this.giorno = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        this.anno = Calendar.getInstance().get(Calendar.YEAR);
        this.mese = Calendar.getInstance().get(Calendar.MONTH) + 1;
    }
    /**Calcola il numero di giorni trascorsi dal 1/1/1970 alla data su cui
    *  è invocato.
    *  @return il numero di giorni trascorsi dall'Epoca*/
    public int giorniDaEpoca()
    {
        Data epoca = new Data(1, 1, 1970);
        return giorniDa(epoca);
    }
    /**Calcola il numero di giorni trascorsi dalla data d a quella su cui
    *  il metodo è invocato.
    *  @param d la data di partenza
    *  @return il numero di giorni da d(negativo se la data su cui è invocato viene prima di d)*/
    public int giorniDa(Data d)
    {
        int n = 0;
        n += 365 * (this.anno - d.anno);
        n += 31 * (this.mese - d.mese);
        n += this.giorno - d.giorno;
        return n;
    }

    /**Restituisce true se e solo se la data su cui è invocata
    *  viene prima della data d.
    *  @param d la data passata per argomento
    *  @return true or false*/
    public boolean vienePrimaDi(Data d)
    {
        return giorniDa(d) < 0;
    }

    /**Restituisce la data ottenuta come il giorno 1 del mese m+2 (dove m è il
    *  mese della data su cui è invocato).
    *  @return la data successiva secondo la regola scritta sopra*/
    public Data successiva()
    {
        int ms = (this.mese + 2) % 12;
        int as = this.anno;
        if (this.mese == 11 || this.mese == 12)
            as += 1;
        Data succ = new Data(1, ms, as);
        return succ;
    }

    /**Restituisce la data su cui è invocato sotto forma di stringa.
    *  @return l'oggetto sotto forma di stringa
    *  @override */

    public int getGiorno()
    {
        return this.giorno;
    }

    public int getMese()
    {
        return this.mese;
    }

    public int getAnno()
    {
        return this.anno;
    }


    public String toString()
    {
        return Integer.toString(this.giorno) + "/" + Integer.toString(this.mese) + "/" + Integer.toString(this.anno);
    }
}

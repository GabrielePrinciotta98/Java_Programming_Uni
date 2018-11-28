public class Offerta
{
    private String nomeOfferta;
    private Prodotto p;
    private double percSconto;
    private int numeroMinimo;
    private boolean soloCartaFedelta;

    public Offerta(String nomeOfferta, Prodotto p, double percSconto, int numeroMinimo, boolean soloCartaFedelta)
    {
        this.nomeOfferta = nomeOfferta;
        this.p = p;
        this.percSconto = percSconto;
        this.numeroMinimo = numeroMinimo;
        this.soloCartaFedelta = soloCartaFedelta;
    }

    public double prezzo(int qta, boolean carta)
    {
        if (this.soloCartaFedelta && carta && qta >= this.numeroMinimo)
            return (this.p.prezzo() * qta) - (this.p.prezzo() * qta * percSconto);
        else
            if (this.soloCartaFedelta == false && qta >= this.numeroMinimo)
                return (this.p.prezzo() * qta) - (this.p.prezzo() * qta * percSconto);
            else
                return this.p.prezzo() * qta;
    }

    public static double totale(Offerta[] off, Prodotto[] p, int[] qta, boolean carta)
    {
        int tot = 0;
        for (int i=0; i<p.length; i++)
        {
            for (int j=0; j<off.length; j++)
            {
                if (off[j].inOfferta(p[i]))
                {
                    tot += off[j].prezzo(qta[i], carta);
                    break;
                }
            }
        }
        return tot;
    }

    public boolean inOfferta(Prodotto x)
    {
        return this.p.equals(x);
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        String carta;
        if (this.soloCartaFedelta)
            carta = "necessaria";
        else
            carta = "non necessaria";
        sb.append(this.nomeOfferta+'\n');
        sb.append("Per il prodotto: "+ this.p.toString() + '\n');
        sb.append("Sconto del: "+ (this.percSconto*100) +"%"+ '\n');
        sb.append("Requisiti: quantità minima = "+ this.numeroMinimo + ", carta fedeltà: "+ carta+ '\n');
        return sb.toString();
    }
}

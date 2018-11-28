import java.util.*;
public class Prodotto
{
    private String nome;
    private String id;
    private Reparto reparto;
    private double quantita;
    private double prezzo;
    private UnitaDiMisura mis;

    public Prodotto(String nome, Reparto reparto, String id, double quantita, double prezzo, UnitaDiMisura mis)
    {
        this.nome = nome;
        this.reparto = reparto;
        this.id = id;
        this.quantita = quantita;
        this.prezzo = prezzo;
        this.mis = mis;
    }

    public double prezzo()
    {
        return this.prezzo;
    }

    public double prezzoUnitario()
    {
        return mis.qta()*this.prezzo/this.quantita;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.nome + '\n');
        sb.append(this.reparto.toString()+'\n');
        sb.append(this.id + '\n');
        sb.append(Double.toString(this.quantita) + " " +this.mis.sigla() + '\n');
        sb.append(Double.toString(this.prezzo) +'\n');
        return sb.toString();
    }

    public boolean equals(Object x)
    {
        if (!(x instanceof Prodotto))
            return false;
        Prodotto p = (Prodotto)(x);
        return this.id.equals(p.id);
    }
}

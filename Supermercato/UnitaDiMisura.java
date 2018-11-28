public class UnitaDiMisura
{
    private String nome;
    private String sigla;
    private UnitaDiMisura riferimento;
    private double qta;

    public UnitaDiMisura(String nome, String sigla)
    {
        this(nome, sigla, null, 1);
    }

    public UnitaDiMisura(String nome, String sigla, UnitaDiMisura riferimento, double qta)
    {
        this.nome = nome;
        this.sigla = sigla;
        this.riferimento = riferimento;
        this.qta = qta;
    }

    public UnitaDiMisura riferimento()
    {
        if (this.qta() != 1)
            return this.riferimento;
        else
            return this;
    }

    public double qta()
    {
        return this.qta;
    }

    public String sigla()
    {
        return this.sigla;
    }

    public String toString()
    {
        return this.nome + "," + this.sigla;
    }
}

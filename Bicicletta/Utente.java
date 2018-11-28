public class Utente
{
    private String nome;
    private String cognome;
    private boolean haInUso;
    private Bicicletta biciInUso;

    public Utente(String nome, String cognome)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.haInUso = false;
        this.biciInUso = null;
    }

    public Bicicletta bicicletta()
    {
        return this.biciInUso;
    }

    public void prendiInUso(Bicicletta x) throws IllegalStateException
    {
        if (this.haInUso)
            throw new IllegalStateException();
        else
        {
            this.haInUso = true;
            this.biciInUso = x;
            x.getLibera() = false;
            x.utente() = this;
        }
    }

    public void restituisci() throws IllegalStateException
    {
        if (this.haInUso)
        {
            this.haInUso = false;
            this.biciInUso = null;
            this.biciInUso.getLibera() = true;
            this.biciInUso.utente() = null;
        }
        else
            throw new IllegalStateException();
    }

    public String toString()
    {
        String usando = "";
        if (this.haInUso)
            usando = ", sta usando la bici: "+ this.biciInUso.getId();
        else
            usando = ", non sta usando nessuna bici";
        return this.nome + " " + this.cognome + usando;
    }

    public String getNominativoUtente()
    {
        return this.nome + " " + this.cognome;
    }

    public boolean getHaInUso()
    {
        return this.haInUso;
    }

}

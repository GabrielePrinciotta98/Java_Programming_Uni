import java.util.*;
public class ModelloLinguistico
{
    private final char[] alfabeto = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private int[] contatore;
    private int numeroTesti;
    private int numeroCaratteri;

    public ModelloLinguistico()
    {
        this.contatore = new int[26];
        this.numeroTesti = 0;
        this.numeroCaratteri = 0;
    }

    public ModelloLinguistico(String testo)
    {
        this();
        this.addestra(testo);
    }

    public void addestra(String testo)
    {
        for (int i=0; i<testo.length(); i++)
        {
            char m = testo.charAt(i);
            if (Character.isLetter(m))
            {
                char x = Character.toLowerCase(m);
                this.numeroCaratteri++;
                int k = (int)(x) - 'a';
                this.contatore[k]++;
            }
        }
        this.numeroTesti++;
    }

    public int quantiTesti()
    {
        return this.numeroTesti;
    }

    public int quantiCaratteri()
    {
        return this.numeroCaratteri;
    }

    public int frequenzaAssoluta(char c)
    {
        if (Character.isLetter(c))
        {
            int k = (int)(c) - 'a';
            return this.contatore[k];
        }
        else
            return -1;
    }

    public double frequenzaRelativa(char c)
    {
        if (this.quantiCaratteri() > 0)
        {
            return this.frequenzaAssoluta(c)/(double)(this.quantiCaratteri());
        }
        else
            return 1.0/26;
    }

    public double differenza(ModelloLinguistico m)
    {
        int sommaQuadrati = 0;
        for (int i=0; i<this.contatore.length; i++)
        {
            int quadrato = (this.contatore[i] - m.contatore[i])*(this.contatore[i] - m.contatore[i]);
            sommaQuadrati += quadrato;
        }
        return Math.sqrt(sommaQuadrati);
    }

    public int[] getContatore()
    {
        return this.contatore;
    }

    public char[] getAlfabeto()
    {
        return this.alfabeto;
    }
}

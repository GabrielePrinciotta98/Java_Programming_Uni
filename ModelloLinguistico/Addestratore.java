import java.util.*;
public class Addestratore
{
    private ArrayList<ModelloLinguistico> modelli;
    private ArrayList<String> lingue;

    public Addestratore()
    {
        this.modelli = new ArrayList<ModelloLinguistico>();
        this.lingue = new ArrayList<String>();
    }

    public void addestra(String nomeLingua, String testo)
    {
        ModelloLinguistico m = null;
        if (lingue.indexOf(nomeLingua) == -1)
        {
            lingue.add(nomeLingua);
            m = new ModelloLinguistico(testo);
            modelli.add(m);
        }
        else
        {
            modelli.get(lingue.indexOf(nomeLingua)).addestra(testo);
        }
    }

    public String classifica(String testo)
    {
        double min = Double.MAX_VALUE;
        ModelloLinguistico m = new ModelloLinguistico(testo);
        int ris = 0;
        for (int i=0; i<modelli.size(); i++)
        {
            double diff = m.differenza(modelli.get(i));
            if (diff < min)
            {
                min = diff;
                ris = i;
            }
        }
        return lingue.get(ris);
    }

    /*public getLinguaDelModello(ModelloLinguistico m)
    {
        return lingue.get(modelli.indexOf(m));
    }*/

    public void stampa(int larg)
    {
        for (int i=0; i<lingue.size(); i++)
        {
            Istogramma isto = new Istogramma(larg);
            System.out.println(lingue.get(i));
            System.out.println(isto.toString(modelli.get(i)));
        }
    }
}

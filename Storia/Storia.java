import java.util.*;
public class Storia
{
    private ArrayList<Civilta> civilta = new ArrayList<Civilta>();

    public Storia(ArrayList<Civilta> civilta)
    {
        this.civilta = civilta;
    }

    public void commercia()
    {
        for (int c=0; c<civilta.size(); c++)
        {
            for (int k=0; k<civilta.size(); k++)
            {
                if (this.civilta.get(c).equals(this.civilta.get(k)) == false)
                {
                    this.civilta.get(c).vendiRisorseA(this.civilta.get(k));
                    break;
                }
            }
        }
    }

    public Civilta piuRicca()
    {
        int max = Integer.MIN_VALUE;
        for (int i=0; i<this.civilta.size(); i++)
        {
            if (this.civilta.get(i).getTesoro() > max)
                max = this.civilta.get(i).getTesoro();
        }
        for (int i=0; i<this.civilta.size(); i++)
        {
            if (this.civilta.get(i).getTesoro() == max)
                return this.civilta.get(i);
        }
        return null;
    }

    public Civilta piuPovera()
    {
        int min = Integer.MAX_VALUE;
        for (int i=0; i<this.civilta.size(); i++)
        {
            if (this.civilta.get(i).getTesoro() < min)
                min = this.civilta.get(i).getTesoro();
        }
        for (int i=0; i<this.civilta.size(); i++)
        {
            if (this.civilta.get(i).getTesoro() == min)
                return this.civilta.get(i);
        }
        return null;
    }

    public Civilta evolvi(int n)
    {
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<this.civilta.size(); j++)
                this.civilta.get(j).faiProdurre();
            this.commercia();
        }
        return this.piuRicca();
    }

    public void conquista()
    {
        Civilta cr = this.piuRicca();
        Civilta cp = this.piuPovera();
        int min = Integer.MAX_VALUE;
        if (cr.getTesoro() != cp.getTesoro())
        {
            for (int i=0; i<cp.getCitta().size(); i++)
            {
                if (cp.getCitta().get(i).produci().getPrezzo() > min && i == cp.getCitta().size()-1)
                    cr.getCitta().add(cp.getCitta().get(i));
            }
        }
    }
}

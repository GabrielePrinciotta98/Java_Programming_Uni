import java.util.*;
public class Istogramma
{
    private int larg;
    private final int numeroRighe = 26;

    public Istogramma(int larg)
    {
        this.larg = larg;
    }

    public String toString(ModelloLinguistico m)
    {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<numeroRighe; i++)
        {
            sb.append(m.getAlfabeto()[i]);
            sb.append('\t');
            for (int j=0; j<m.getContatore()[i]; j++)
            {
                sb.append('*');
                if (m.getContatore()[i] > this.larg)
                    break;
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}

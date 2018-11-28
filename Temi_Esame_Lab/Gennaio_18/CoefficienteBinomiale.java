public class CoefficienteBinomiale
{
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        System.out.println(coeffBin(n,k));
    }

    public static int coeffBin(int n, int k)
    {
        int ris;
        if (k == 0)
            ris = 1;
        else
            if (n == 0)
                ris = 0;
            else
                ris = coeffBin(n-1,k-1) + coeffBin(n-1,k);
        return ris;
    }
}

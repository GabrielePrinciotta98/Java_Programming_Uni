public class QuanteVolteIn
{
    public static void main(String[] args)
    {
        System.out.println(quanteVolteIn(args[0],args[1]));
    }

    public static int quanteVolteIn(String a,String b)
    {
        int n;
        if (a.length() > b.length())
            n = 0;
        else
            if (b.startsWith(a))
                n = quanteVolteIn(a,b.substring(1,b.length())) + 1;
            else
                n = quanteVolteIn(a,b.substring(1,b.length()));
        return n;
    }
}

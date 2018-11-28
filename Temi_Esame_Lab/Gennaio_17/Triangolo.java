import java.util.*;
public class Triangolo
{
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        System.out.println(triangolare(n));
    }

    public static int triangolare(int n)
    {
        if (n == 0)
            return 0;
        else
            return n + triangolare(n-1);
    }
}

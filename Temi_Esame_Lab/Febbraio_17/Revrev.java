import java.util.*;
public class Revrev
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Stack <String> stringhe = new Stack<String>();
        int c = 0;
        while(in.hasNext())
        {
            String s = in.nextLine();
            if (s.length() != 0)
                stringhe.push(s);
            else
                stringhe.push("vuota");
            c++;
        }
        for (int i=0; i<c; i++)
        {
            if(stringhe.peek() == "vuota")
            {
                System.out.println();
                System.out.println();
                stringhe.pop();
            }
            else
            {
                String s = stringhe.pop();
                for (int j=s.length()-1; j>=0; j--)
                    System.out.print(s.charAt(j));
            }
        }
        System.out.println();
    }
}

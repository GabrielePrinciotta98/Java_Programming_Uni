import java.util.Scanner;
public class Calcolatrice
{
    public static void main(String[] args)
    {
        try
        {
            Scanner in = new Scanner(System.in);
            double acc = 0;
            boolean continuainput = in.hasNextLine();
            while (continuainput)
            {
                String s = in.nextLine();
                int pos = s.indexOf(' ');
                String op = s.substring(0,pos);
                double numero = Double.parseDouble(s.substring(pos+1,s.length()));
                switch (op)
                {
                    case "+":   acc += numero;
                                break;
                    case "-":   acc -= numero;
                                break;
                    case "*":   acc *= numero;
                                break;
                    case "/":   if (numero != 0)
                                    acc /= numero;
                                else
                                    System.out.println("divisione per zero");
                                break;
                    case "S":   acc = numero;
                                break;
                    case "E":   continuainput = false;
                                break;
                    default:    System.out.println("operatore sconosciuto");
                                break;
                }
                System.out.println(acc);
            }
        }
        catch (StringIndexOutOfBoundsException e)
        {};
    }
}

import java.util.*;
public class CampoMinato
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(args[0]);
        char[][] schema = new char[100][100];
        while (in.hasNextLine())
        {
            for (int i=0; i<n; i++)
            {
                String s = in.nextLine();
                for (int j=0; j<n; j++)
                {
                    schema[i][j] = s.charAt(j);
                }
            }
        }
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<n; j++)
            {
                if(schema[i][j] != '*')
                    schema[i][j] = (char)(contaMine(schema,i,j)+48);
            }
        }
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<n; j++)
            {
                System.out.print(schema[i][j]);
            }
            System.out.println();
        }
        /*System.out.println(bombFinder(schema,0,0));
        System.out.println(bombFinder(schema,0,2));
        System.out.println(bombFinder(schema,4,0));*/
    }


    public static int bombFinder(char[][] matrice,int i,int j)
    {
        int c = lunghezzaEffettiva(matrice);
        if (i < c && j < c && matrice[i][j] == '*')
            return 1;
        else
            return 0;

    }

    public static int contaMine(char[][] matrice,int r,int c)
    {
        int n = lunghezzaEffettiva(matrice);
        int mine = 0;
        for (int i=-1; i<2; i++)
        {
            for (int j=-1; j<2; j++)
            {
                try
                {
                    mine += bombFinder(matrice,r+i,c+j);
                }
                catch (ArrayIndexOutOfBoundsException e)
                {}
            }
        }
        return mine;
    }


    public static int lunghezzaEffettiva(char[][] matrice)
    {
        int c = 0;
        for (int k=0; k<matrice.length; k++)
        {
            for (int h=0; h<matrice.length; h++)
            {
                if (matrice[k][h] != '0')
                    c++;
            }
        }
        return c;
    }
}

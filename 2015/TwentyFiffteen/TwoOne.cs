using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

class TwoOne
{
    private static string filepath = @"Data\two.txt";
    public static void Program()
    {
        using (StreamReader sr = new StreamReader(filepath))
        {
            int total = 0;
            string line;
            while((line = sr.ReadLine()) != null)
            {
                // l w h
                int[] a = Array.ConvertAll(line.Split('x'), s => int.Parse(s));
                Array.Sort(a);
                // 2*l*w + 2*w*h + 2*h*l + slack
                // slack is shortest + next
                total += ((2 * a[0] * a[1]) + (2 * a[0] * a[2]) + (2 * a[1] * a[2])) + (a[0] * a[1]);
            }
            Console.WriteLine(total);
        }

    }
}


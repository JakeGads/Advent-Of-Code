using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

public class OneTwo
{
    private static string filepath = @"Data\one.txt";
    public static void Program()
    {
        int floor = 0;
        int step = 0;
        using (StreamReader sr = new StreamReader(filepath))
        {
            foreach(var value in sr.ReadToEnd())
            {
                step++;
                switch (value)
                {
                    case '(': floor++; break;
                    case ')': floor--; break;
                }

                if(floor == -1)
                {
                    Console.WriteLine(step);
                    break;
                }
            }
            
        }
    }
}

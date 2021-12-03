using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

class ThreeOne
{
    private static string filepath = @"Data\Three.txt";
    public static void Program()
    {
        using (StreamReader sr = new StreamReader(filepath))
        {
            int total = 0;
            int x = 0;
            int y = 0;
            HashSet<string> set = new HashSet<string>();

            foreach (var val in sr.ReadToEnd()){
                set.Add($"{x}x{y}");
                switch (val)
                {
                    case '^': y++;break;
                    case 'v': y--;break;
                    case '>': x++;break;
                    case '<': x--;break;
                }
                total++;
            }

            Console.WriteLine($"{set.Count}: {total}");
        }

    }
}


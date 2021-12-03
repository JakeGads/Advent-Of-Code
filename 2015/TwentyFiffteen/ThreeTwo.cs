using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

class ThreeTwo
{
    private class Santa
    {
        public int x { get; set; }
        public int y { get; set; }
        public int steps { get; set; }
    }


    private static string filepath = @"Data\Three.txt";
    public static void Program()
    {
        using (StreamReader sr = new StreamReader(filepath))
        {
            int total = 0;
            Santa[] santas = new Santa[] { new Santa(), new Santa() };
            HashSet<string> set = new HashSet<string>();
            

            foreach (var val in sr.ReadToEnd()){
                var current = santas[total % santas.Length];
                set.Add($"{current.x}x{current.y}");
                switch (val)
                {
                    case '^': current.y++;break;
                    case 'v': current.y--;break;
                    case '>': current.x++;break;
                    case '<': current.x--;break;
                }
                total++;
            }

            Console.WriteLine($"{set.Count}: {total}");
        }

    }
}


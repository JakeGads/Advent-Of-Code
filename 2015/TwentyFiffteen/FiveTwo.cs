using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

class FiveTwo
{
    private static string filepath = @"Data\Five.txt";
    public static void Program()
    {
        using (StreamReader sr = new StreamReader(filepath))
        {
            int count = 0;
            string line;
            while((line = sr.ReadLine()) != null)
            {
                if(twopairs(line) && sameWBuffer(line))
                {
                    count++;
                }
            }
            Console.WriteLine(count);
        }

        static bool twopairs(string line)
        {
            for(int i = 0; i < line.Length-1; i++)
            {
                var tuple = $"{line[i]}{line[i + 1]}";
                for (int j = i + 2; j < line.Length - 1; j++)
                {
                    
                    var testTuple = $"{line[j]}{line[j + 1]}";
                    if (testTuple == tuple)
                    {
                        return true;
                    }
                }
            }

            return false;
            
        }
        static bool sameWBuffer(string line)
        {
            for(int i = 0; i < line.Length - 2; i++)
            {
                var sub = $"{line[i]}{line[i+1]}{line[i+2]}";
                if(sub[0] != sub[1] && sub[0] == sub[2])
                {
                    return true;
                }
            }
            return false;

        }
    }
}


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

class FiveOne
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
                if(threeVowels(line) && doubleChar(line) && bannedCombos(line))
                {
                    count++;
                }
            }
            Console.WriteLine(count);
        }

        static bool threeVowels(string line)
        {
            int count = 0;
            foreach(var value in line)
            {
                switch (value)
                {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u': count++;break;
                }

                if(count == 3)
                {
                    return true;
                }
            }
            return false;
        }

        static bool doubleChar(string line)
        {
            var arr = line.ToCharArray();
            for (int i = 0; i < line.Length - 1; i++)
            {
                if(arr[i] == arr[i + 1])
                {
                    return true;
                }
            }

            return false;
        }

        static bool bannedCombos(string line)
        {
            char[] arr = line.ToCharArray();
            for(int i = 0; i < arr.Length-1; i++)
            {
                string temp = $"{arr[i]}{arr[i + 1]}";
                switch (temp)
                {
                    case "ab":
                    case "cd":
                    case "pq":
                    case "xy": return false;
                }
            }
            return true;
        }

    }
}


using System;
using System.Collections.Generic;
using System.IO;

public static class Runner
{
    public static void Main(string[] args)
    {
        string textFile = "C:\\Users\\Jake Gadaleta\\source\\repos\\Advent-Of-Code\\2021\\day1\\Day1\\input.txt";
        two(textFile);
    }

    public static void one(string text)
    {
        using (StreamReader file = new StreamReader(text))
        {
            int counter = -1;
            int current = 0;
            string ln;

            while ((ln = file.ReadLine()) != null)
            {
                if (current < int.Parse(ln))
                {
                    counter++;
                }

                current = int.Parse(ln);
            }
            file.Close();
            Console.WriteLine(counter);
        }
    }

    public static void two(string text)
    {
        List<int> values = new List<int>();
        int count = 0;
        using (StreamReader file = new StreamReader(text))
        {
            string ln;
            while ((ln = file.ReadLine()) != null)
            {
                values.Add(int.Parse(ln));
            }
        }

        for(int i = 0; i + 3 < values.Count; i++)
        {
            int a = values[i] + values[i+1] + values[i+2];
            int b = values[i + 3] + values[i + 1] + values[i + 2];

            if(b < a)
            {
                count += 1;
            }
        }

        Console.WriteLine(count);

    }
}

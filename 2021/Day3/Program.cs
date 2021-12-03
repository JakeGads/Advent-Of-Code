// See https://aka.ms/new-console-template for more information
public class Program
{
    public static void Main(string[] args)
    {
        Console.WriteLine("Part 1:");
        var firstLine = one();
        Console.WriteLine("\n\nPart 2:");
        two(firstLine);
    }

    public static void two(string first)
    {
        List<string> Filter(List<string> items, int position, char defaultDigit)
        {
            var digitPositions = items.SelectMany(x => x.Select((y, i) => (Digit: y, Position: i))).ToList();
            var digits = digitPositions.Where(x => x.Position == position).GroupBy(x => x.Digit);

            var sortedDigits = defaultDigit == '0'
                ? digits.OrderBy(x => x.Count()).ToArray()
                : digits.OrderByDescending(x => x.Count()).ToArray();

            var filterCriteria = digits.Count() == 1 ? sortedDigits[0].Key : sortedDigits[0].Count() == sortedDigits[1].Count() ? defaultDigit : sortedDigits[0].Key;
            return items.Where(x => x[position] == filterCriteria).ToList();
        }

        var _entries = File.ReadAllLines("input.txt").ToList();
        var oxygen = _entries;
        var scrubber = _entries;

        for (int i = 0; i < _entries[0].Length && oxygen.Count() > 1; i++)
        {
            oxygen = Filter(oxygen, i, '1');
        }

        for (int i = 0; i < _entries[0].Length && scrubber.Count() > 1; i++)
        {
            scrubber = Filter(scrubber, i, '0');
        }

        var common = Convert.ToInt32(oxygen[0], 2);
        var leastCommon = Convert.ToInt32(scrubber[0], 2);
        Console.WriteLine(common * leastCommon);

    }

    public static string one()
    {
        string firstLine = "";
        List<List<int>> master = new List<List<int>>();

        using(StreamReader sr = new StreamReader("input.txt"))
        {
            bool first = true;
            string line;
            while((line = sr.ReadLine()) != null)
            {
                for (int i = 0; i < line.Length; i++)
                {
                    if (first)
                    {
                        firstLine = line;
                        master.Add(new List<int>());
                    }
                    master[i].Add(int.Parse(line.ToCharArray()[i].ToString()));
                }
                first = false;
            }

            var gamma = "";
            var epsolon = "";
            foreach(List<int> list in master)
            {
                int oneCount = 0;
                foreach(int i in list)
                {
                    if (i == 1)
                    {
                        oneCount++;
                    }
                }

                if(oneCount > (list.Count / 2))
                {
                    gamma += "1";
                    epsolon += "0";
                }
                else
                {
                    gamma += "0";
                    epsolon += "1";
                }
            }

            Console.WriteLine($"Gamma\n\t\tBinary:\t{gamma}\n\t\tDecimal:{Parse(gamma)}");
            Console.WriteLine($"Epsolon\n\t\tBinary:\t{epsolon}\n\t\tDecimal:{Parse(epsolon)}");
            Console.WriteLine($"Gamma x Epsolon\n\t\tValue:\t{Parse(gamma) * Parse(epsolon)}");
            return firstLine;
        }
    }

    public static int Parse(string value)
    {
        return int.Parse(Convert.ToInt32(value, 2).ToString());
    }
}
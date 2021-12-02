public class Program
{
    public static void Main(string[] args)
    {
        two();
    }

    public static void one()
    {
        using (StreamReader sr = new StreamReader("input.txt"))
        {
            int x = 0;
            int y = 0;
            string line;
            while ((line = sr.ReadLine()) != null)
            {
                var direction = line.Split(' ')[0];
                switch (direction)
                {
                    case "forward": x += int.Parse(line.Split(' ')[1]); break;
                    case "down": y -= int.Parse(line.Split(' ')[1]); break;
                    case "up": y += int.Parse(line.Split(' ')[1]); break;
                }
            }

            Console.WriteLine($"Height:{y}\nLength:{x}\nEuclidan:{x * y}");
        }
    }
    public static void two()
    {
        using (StreamReader sr = new StreamReader("input.txt"))
        {
            int aim = 0;
            int x = 0;
            int y = 0;
            string line;
            while ((line = sr.ReadLine()) != null)
            {
                var direction = line.Split(' ')[0];
                switch (direction)
                {
                    case "forward": 
                        x += int.Parse(line.Split(' ')[1]);
                        y += int.Parse(line.Split(' ')[1]) * aim;
                        break;
                    case "down": 
                        aim -= int.Parse(line.Split(' ')[1]); 
                        break;
                    case "up": 
                        aim += int.Parse(line.Split(' ')[1]); 
                        break;
                }
            }

            Console.WriteLine($"Height:{y}\nLength:{x}\nEuclidan:{x * y}");
        }
    }
}
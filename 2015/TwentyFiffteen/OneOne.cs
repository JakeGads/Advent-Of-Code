public class OneOne
{
    private static string filepath = @"Data\one.txt";
    public static void Program()
    {
        int currentFloor = 0;
        using (StreamReader sr = new StreamReader(filepath))
        {
            foreach(char val in sr.ReadToEnd())
            {
                switch (val)
                {
                    case '(': currentFloor++;break;
                    case ')': currentFloor--;break;
                }
            }
        }
        Console.WriteLine(currentFloor);
    }
}
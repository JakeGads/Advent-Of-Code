using (StreamReader file = new StreamReader("C:\\Users\\Jake Gadaleta\\source\\repos\\Advent-Of-Code\\2021\\day1\\Day1\\input.txt"))
{
    int counter = -1;
    int current = 0;
    string ln;

    while ((ln = file.ReadLine()) != null)
    {
        if(current < int.Parse(ln))
        {
            counter++;
        }

        current = int.Parse(ln);
    }
    file.Close();
    Console.WriteLine(counter);
}
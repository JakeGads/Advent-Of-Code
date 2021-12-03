using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

class FourOne
{
    private static string key = "ckczppom";
    public static void Program()
    {
        const string secret = "ckczppom";
        const string pattern = @"^00000"; // replace with @"^000000" for part two  

        using (var md5 = MD5.Create())
        {
            for (var i = 1; i < 1000000000; i++)
            {
                var tmpSecret = string.Concat(new[] { secret, i.ToString() });
                using (var s = GenerateStreamFromString(tmpSecret))
                {
                    var key = BitConverter.ToString(md5.ComputeHash(s)).Replace("-", string.Empty);
                    var r = new Regex(pattern, RegexOptions.IgnoreCase);
                    var m = r.Match(key);
                    if (!m.Success) continue;
                    Console.WriteLine("Result: " + i);
                    Console.ReadLine();
                    return;
                }
            }
        }
    }

    public static Stream GenerateStreamFromString(string s)
    {
        var stream = new MemoryStream();
        var writer = new StreamWriter(stream);
        writer.Write(s);
        writer.Flush();
        stream.Position = 0;
        return stream;
    }

    public static void Part2()
    {
        var input = "ckczppom";
        var hash = MD5.Create();
        for (int i = 0; ; ++i)
        {
            var bytes = hash.ComputeHash(Encoding.UTF8.GetBytes(input + i));
            if (bytes[0] < 0x1 && bytes[1] < 0x1 && bytes[2] < 0x1)
            {
                Console.WriteLine(i);
                return;
            }
        }
    }
}



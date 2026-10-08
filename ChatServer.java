import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class ChatServer
{
    public static void main(String A[]) throws Exception
    {
        System.out.println("Server application is running...");

        ServerSocket ssobj = new ServerSocket(2100);

        System.out.println("Server is waiting at port 2100");

        Socket sobj = ssobj.accept();

        System.out.println("Clients request gets accepted successfully");

        PrintStream pobj = new PrintStream(sobj.getOutputStream());

        BufferedReader bobj1 = new BufferedReader(
            new InputStreamReader(sobj.getInputStream())
        );

        BufferedReader bobj2 = new BufferedReader(
            new InputStreamReader(System.in)
        );

        System.out.println("------------------------------------------");
        System.out.println("--------- Marvellous Chat Server ---------");
        System.out.println("------------------------------------------");

        String str1 = null;
        String str2 = null;

        while((str1 = bobj1.readLine()) != null)
        {
            System.out.println("Client says : " + str1);

            logMessage("Client says: " + str1);

            if(str1.equals("End"))
            {
                break;
            }

            System.out.println("Enter message for client : ");

            str2 = bobj2.readLine();

            pobj.println(str2);

            logMessage("Server says: " + str2);
        }

        sobj.close();
        ssobj.close();
    }

    public static void logMessage(String message)
    {
        String timestamp = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss"
        ).format(new Date());

        String entry = "[" + timestamp + "] " + message;

        try
        {
            FileWriter fwobj = new FileWriter("ChatLog.txt", true);
            BufferedWriter bwobj = new BufferedWriter(fwobj);

            bwobj.write(entry);
            bwobj.newLine();

            bwobj.close();
            fwobj.close();
        }
        catch(IOException e)
        {
            System.out.println(
                "Unable to write to log file : " + e.getMessage()
            );
        }
    }
}
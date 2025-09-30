import java.util.Scanner;
public class selRepARQ
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = 10;
        int w = 3;
        int b = 0;
        boolean[] arr = new boolean[n];
        while(b<n)
        {
            for(int i = b ; i < (b+w) && i < n ; i++)
            {
                if(arr[i] == false)
                System.out.println("Sending Frame " + i);
            }

            for(int i = b ; i < (b+w) && i < n ; i++)
            {
                if(arr[i] == false)
                {
                    System.out.println("Did acknowledgement receive for frame " + i + " (y/n): ");
                    String ans = sc.next();
                    if(ans.equals("y"))
                    {
                        arr[i] = true;
                        System.out.println("ACK received for frame " + i);
                    }
                    else 
                    {
                        System.out.println("Frame " + i + " will be retransmitted");
                    }
                }
            }

            while(b<n && arr[b]==true)
            {
                b++;
            }
        }
    }
}
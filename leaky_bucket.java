import java.util.Scanner;
class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter bucket capacity : ");
        int capacity = sc.nextInt();
        
        System.out.println("Enter the output rate : ");
        int rate = sc.nextInt();
        
        System.out.println("Enter the number of packets : ");
        int n = sc.nextInt();
        
        int currentSize = 0;
        
        for(int i = 0 ; i < n ; i++)
        {
            System.out.println("Enter the packet : ");
            int packet = sc.nextInt();
            
            if (packet+currentSize>capacity)
            {
                System.out.println("packet discarded");
            }
            else
            {
                currentSize += packet;
                System.out.println("Current Size" + currentSize);
            }
            
            int leak = Math.min(rate,currentSize);
            currentSize -= leak;
        }
        
        while(currentSize > 0)
        {
            System.out.println("Current Size" + currentSize);
            currentSize-=Math.min(rate,currentSize);
        }
        
        sc.close();
    }
}
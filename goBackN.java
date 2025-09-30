public class goBackN
{
    public static void main(String args[]) throws Exception
    {
        int n = 10; //number of frames
        int w = 3; //window size
        int l = 0;// current ponter
        int r = 0;
        while(l<n)
        {
            r = Math.min(l+w-1,n-1);
            System.out.println("Sneding frames from "+l+"to "+r);
            for(int i = l ; i<=r ; i++ )
            {
                System.out.println("receved frame "+i+"sending acknowledgement for frame "+i);
            }
            l=r+1;
        }
    }
}
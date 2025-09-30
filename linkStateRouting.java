import java.util.*;
class router 
{
    String name;
    Map<String,Integer> neighbours;
    router(String name)
    {
        this.name = name;
        neighbours = new HashMap<>();
    }
    void addLink(String r1,int cost)
    {
        neighbours.put(r1,cost);
    }
}
public class linkStateRouting
{
    Map<String,router> network;

    linkStateRouting()
    {
        network = new HashMap<>();
    }
    void addRouter(String name)
    {
        network.put(name,new router(name));
    }
    void addLink(String r1,String r2,int cost)
    {
        network.get(r1).addLink(r2,cost);
        network.get(r2).addLink(r1,cost);
    }

    void dijkstra(String source)
    {
        Map<String,Integer> dist = new HashMap<>();
        Map<String,String> prev = new HashMap<>();
        Set<String> visited = new HashSet<>();

        for(String router:network.keySet())
        {
            dist.put(router,999);
            prev.put(router,null);
        }
        dist.put(source,0);

        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));
        pq.add(source);

        while(!pq.isEmpty())
        {
            String u = pq.poll();
            if(!visited.add(u))
            continue;
            
            else
            {
                for(Map.Entry<String,Integer> entry : network.get(u).neighbours.entrySet())
                {
                    String v = entry.getKey();
                    int newCost = entry.getValue()+dist.get(u);

                    if(newCost < dist.get(v))
                    {
                        dist.put(v,newCost);
                        prev.put(v,u);
                        pq.add(v);
                    }
                }
            }
        }

        //building the routing table;
        Map<String,String> routingTable = new HashMap<>();
        for(String dest : network.keySet())
        {
            if(dest.equals(source))
            {
                routingTable.put(dest,source);
            }
            else
            {
                String nextHop = dest;
                while(prev.get(nextHop) != null && !prev.get(nextHop).equals(source))
                {
                    nextHop = prev.get(nextHop);
                }
                if(prev.get(nextHop) == null)
                    routingTable.put(dest,"-");
                else
                    routingTable.put(dest,nextHop);
            }
        }

        for(String dest : network.keySet()) {
            System.out.println(dest + "   " +
                (dist.get(dest) == Integer.MAX_VALUE ? "∞" : dist.get(dest)) +
                "   " + routingTable.get(dest));
        }
    }

    public static void main(String args[])
    {
        linkStateRouting lsr = new linkStateRouting();
        lsr.addRouter("A");
        lsr.addRouter("B");
        lsr.addRouter("C");
        lsr.addRouter("D");

        lsr.addLink("A", "B", 1);
        lsr.addLink("A", "C", 5);
        lsr.addLink("B", "C", 2);
        lsr.addLink("B", "D", 4);
        lsr.addLink("C", "D", 1);

        for (String router : lsr.network.keySet()) 
        {
            System.out.println("SOURCE ROUTER "+router);
            lsr.dijkstra(router);
            
        }
    }
}

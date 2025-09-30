import java.util.*;
class Router
{
    String name;
    Map<String,Integer> distanceVector;
    Map<String,String> nextHop;
    List<Router> neighbors;
    Map<String,Integer> linkCost;

    Router(String name)
    {
        this.name = name;
        this.distanceVector = new HashMap<>();
        this.nextHop = new HashMap<>();
        this.neighbors = new ArrayList<>();
        this.linkCost = new HashMap<>();
        distanceVector.put(name,0);
        nextHop.put(name,name);
    }

    void addNeighbour(Router r,int cost)
    {
        neighbors.add(r);
        linkCost.put(r.name,cost);
        distanceVector.put(r.name,cost);
        nextHop.put(r.name,r.name);
    }

    boolean updateTable()
    {
        boolean updated = false;
        for(Router neighbour : neighbors)
        {
            for(Map.Entry<String,Integer> entry : neighbour.distanceVector.entrySet())
            {
                String dest = entry.getKey();
                int newCost = linkCost.get(neighbour.name) + entry.getValue();
                if(distanceVector.containsKey(dest)==false || distanceVector.get(dest)>newCost)
                {
                    distanceVector.put(dest,newCost);
                    nextHop.put(dest,neighbour.name);
                    updated = true;
                }

            }
        }
        return updated;
    }

    void printTable()
    {
        System.out.println("Routing Table for "+this.name);
        System.out.println("Destination , Cost , NextHop");
        for(Map.Entry<String,Integer> entry : distanceVector.entrySet())
        {
            System.out.println(entry.getKey()+" , "+entry.getValue()+" , "+nextHop.get(entry.getKey()));
        }
    }
}

class distVector
{
    public static void main(String[] args)
    {
        Router A = new Router("A");
        Router B = new Router("B");
        Router C = new Router("C");

        A.addNeighbour(B,1);
        B.addNeighbour(A,1);

        B.addNeighbour(C,2);
        C.addNeighbour(B,2);

        C.addNeighbour(A,5);
        A.addNeighbour(C,5);

        boolean updated = true;
        while(updated)
        {
            updated = A.updateTable() || B.updateTable() || C.updateTable();
        }
        A.printTable();
        B.printTable();
        C.printTable();

    }
}
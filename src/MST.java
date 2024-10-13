import java.util.ArrayList;
import java.util.Comparator;

public class MST {
    public static int calculateMinimumWeight(ArrayList<int[]> edges){
        int minWeight = 0;
        ArrayList<Integer> connectedUnion = new ArrayList<>();
        ArrayList<int[]>  selectedPath = new ArrayList<>();
        for(int[] edge : edges){
            boolean firstVertex = false, secondVertex = false;
            for(int vertex : connectedUnion){
                if(vertex == edge[0]) firstVertex=true;
                else if(vertex == edge[1]) secondVertex=true;
            }
            if(!firstVertex) connectedUnion.add(edge[0]);
            if(!secondVertex) connectedUnion.add(edge[1]);
            if(!firstVertex || !secondVertex){
                minWeight+=edge[2];
                selectedPath.add(edge);
            }
        }
        System.out.println("number of edges: "+ connectedUnion.size());
        System.out.print("Connected union: ");
        for (int vertex : connectedUnion) {
            System.out.print(vertex + " ");
        }
        System.out.println("\n\nSelected path ");
        for(int[] path : selectedPath){
            System.out.println("Parent: "+ path[0]+ " Child: "+ path[1]+ " Weight: "+ path[2]);
        }
        System.out.println("\nMinimum Spanning Tree: "+ minWeight);
        return minWeight;
    }

    public static void main(String[] args) {
        int numberOfVertices = 5;
        ArrayList<int[]> edges = new ArrayList<>();
        edges.add(new int[]{0, 1, 1});
        edges.add(new int[]{2, 3, 2});
        edges.add(new int[]{0, 4, 3});
        edges.add(new int[]{1, 2, 1});
        edges.add(new int[]{0, 3, 2});
        edges.add(new int[]{1, 4, 6});
        edges.add(new int[]{3, 4, 3});
        for(int[] edge : edges) {
            System.out.println("Parent: "+ edge[0]+ " Child: "+ edge[1]+ " Weight: "+ edge[2]);
        }

        edges.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]<o2[2]?-1:1;
            }
        });

        System.out.println("\nAfter Sorting");
        for(int[] edge : edges) {
            System.out.println("Parent: "+ edge[0]+ " Child: "+ edge[1]+ " Weight: "+ edge[2]);
        }
        int min = calculateMinimumWeight(edges);

//        int i=0;
        ArrayList<int[]> criticalEdges = new ArrayList<>();
        ArrayList<int[]> pseudoCriticalEdges = new ArrayList<>();
        for(int i=0; i< edges.size(); i++) {
            int[] edge = edges.get(i);
            edges.remove(edge);
            int newMin = calculateMinimumWeight(edges);
//            System.out.println(edges.size());
            if(newMin > min){
                criticalEdges.add(edge);
            }else if(newMin == min){
                pseudoCriticalEdges.add(edge);
            }
            edges.add(i, edge);
        }

        System.out.println("\nCritical Edges");
        for(int[] edge : criticalEdges) {
            System.out.println("Parent: "+ edge[0]+ " Child: "+ edge[1]+ " Weight: "+ edge[2]);
        }
        System.out.println("\nPseudo Critical Edges");
        for(int[] edge : pseudoCriticalEdges) {
            System.out.println("Parent: "+ edge[0]+ " Child: "+ edge[1]+ " Weight: "+ edge[2]);
        }

    }
}

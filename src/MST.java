import java.util.ArrayList;
import java.util.Comparator;

public class MST {
    public static int calculateMinimumWeight(ArrayList<int[]> edges){
        int minWeight = 0;
        ArrayList<Integer> connectedUnion = new ArrayList<>();
        for(int[] edge : edges){
            boolean firstVertex = false, secondVertex = false;
            for(int vertex : connectedUnion){
                if(vertex == edge[0]) firstVertex=true;
                else if(vertex == edge[1]) secondVertex=true;
            }
            if(!firstVertex) connectedUnion.add(edge[0]);
            if(!secondVertex) connectedUnion.add(edge[1]);
            if(!firstVertex || !secondVertex) minWeight+=edge[2];
        }
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
        int m = calculateMinimumWeight(edges);
        System.out.println("Minimum Spanning Tree: "+ m);
    }
}

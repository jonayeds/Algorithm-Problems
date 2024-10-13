import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MinimumStandingTree {

    public static int findRoot(int[] treeArray, int vertex){
        int pointer=vertex;

        while(treeArray[pointer] >= 0){
            pointer = treeArray[pointer];
        }
        return pointer;
    }

    public static int calculateMinimumStandingTree(ArrayList<int[]> graph, int numberOfVertices) {
        int minWeight = 0;
        int[] treeArray = new int[numberOfVertices];
        Arrays.fill(treeArray, -1);
        System.out.println("Selected edges");
        for(int[] edge : graph) {
            System.out.print("\nTree Array: ");
            for(int i=0; i<treeArray.length; i++) System.out.print(treeArray[i]+" ");
            int ultimateRoot1 = findRoot(treeArray, edge[0]);
            int ultimateRoot2 = findRoot(treeArray, edge[1]);
            System.out.println("ultimateRoot1 = " + ultimateRoot1+ " ultimateRoot2 = " + ultimateRoot2);
            if(ultimateRoot1 != ultimateRoot2){
                if(treeArray[ultimateRoot1] <= treeArray[ultimateRoot2]){
                    treeArray[ultimateRoot1] += treeArray[ultimateRoot2];
                    treeArray[ultimateRoot2] = ultimateRoot1;
                }else {
                    treeArray[ultimateRoot2] += treeArray[ultimateRoot1];
                    treeArray[ultimateRoot1] = ultimateRoot2;
                }
                minWeight+= edge[2];
                System.out.println("Source: "+ edge[0]+ " Destination: "+ edge[1]+ " Weight: "+ edge[2]);
            }
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
            System.out.println("Source: "+ edge[0]+ " Destination: "+ edge[1]+ " Weight: "+ edge[2]);
        }

        edges.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]<o2[2]?-1:1;
            }
        });

        System.out.println("\nAfter Sorting");
        for(int[] edge : edges) {
            System.out.println("Source: "+ edge[0]+ " Destination: "+ edge[1]+ " Weight: "+ edge[2]);
        }
        int min =  calculateMinimumStandingTree(edges, numberOfVertices);
        System.out.println("Minimum Spanning tree: " + min);


    }
}

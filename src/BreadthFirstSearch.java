import java.util.ArrayList;


public class BreadthFirstSearch {
    public static void main(String[] args) {
        ArrayList<Integer> tree = new ArrayList<>();
        tree.add(1);
        tree.add(3);
        tree.add(2);
        tree.add(5);
        tree.add(3);
        tree.add(null);
        tree.add(9);
        System.out.print("Tree: ");
        for (int i = 0; i < tree.size(); i++) {
            System.out.print(tree.get(i)+" ");
        }
        ArrayList<Integer> queue = new ArrayList<>();

        int[] selectedValues = new int[tree.size()/2];
        queue.add(tree.getFirst());

        int current =0;
        int level = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            int maxElement =0;

            while (n > 0) {

               if(queue.getFirst() != null){
                   int element = queue.getFirst();
                   maxElement = Math.max(maxElement, element);
               }
               if(tree.size()>= Math.pow(2, level+2)-1){
                   queue.add(tree.get(current*2+1));
                   queue.add(tree.get(current*2+2));
                   current++;
               }
                queue.removeFirst();
                n--;
            }
            selectedValues[level] = maxElement;
            level++;
        }
        System.out.print("\nselected values: " );
        for (int i = 0; i < selectedValues.length; i++) {
            System.out.print(selectedValues[i]+" ");
        }
    }
}

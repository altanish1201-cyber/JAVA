import java.util.ArrayList;

public class ArrayL {
    public static void main(String[] args) {

        // static memory arrays
        int[][] arr = new int[4][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i + j + 1;
            }
        }
        for (int[] row : arr) {
            System.out.print("|");
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.print("|");
            System.out.println();
        }

        // dynamic memory arrays
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        arr1.add(1, 4);
        arr1.addFirst(4);
        arr1.addLast(4);
        arr1.remove(1);
        System.out.println("array elements: " + arr1);
        System.out.println("Size of arr: " + arr1.size());
        System.out.println(arr1.contains(2));
        System.out.println(arr1.indexOf(2));
    }
}
package twopointer;

public class ReverseArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        reverse(arr);
        for (Integer i : arr)
            System.out.print(i + " ");
    }

    public static void reverse(int[] arr) {

        int i = 0, j = arr.length - 1;
        while (i < j) {
            int tmp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = tmp;
        }
    }
}

package HomeWorkDay1;

public class FindMaximumAndMinimumElementInArray {
    public static void main(String[] args) {
        int[] a = {20,8,1000,70,2,1};
        int max = a[0];
        int min = a[0];

        for (int i = 1; i < a.length ; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min){
                min = a[i];
            }
        }
        System.out.println("Maximum element in an array : " + max);
        System.out.println("Minimum element in an array : " + min);
    }
}

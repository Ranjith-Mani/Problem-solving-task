package HomeWorkDay2;

public class FindSecondLargestElementInArray {
    public static void main(String[] args) {
        int[] num = {10, 40, 80, 100, 90, 500, 1000};
        int n = num.length;
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (num[i] > highest){
                secondHighest = highest;
                highest = num[i];
            }
            if (num[i] < highest && num[i] > secondHighest){
                secondHighest = num[i];
            }
        }
        System.out.println("Second Highest element in Array is : " + secondHighest);
    }
}

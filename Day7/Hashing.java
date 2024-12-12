package Day7;

import java.util.Scanner;

class HashTableArr{
    private int[] table;
    private int size;

    // Implementing constructor
    public HashTableArr(int size) {
        this.size = size;
        table = new int[size];

        for (int i = 0; i < size; i++) {
            table[i] = -1; // to assume the empty slots
        }
    }
    // Hash Function
    private int HashFunction(int key){
        return key % size;
    }

    // To insert keys
    public void InsertKey(int key){
        int index = HashFunction(key);

        // For linear probing
        while (table[index] != -1){
            index = (index+1) % size;
        }

        // Insert key
        table[index] = key;
    }

    // Search function
    public boolean searchKey(int searchKey){
        int index = HashFunction(searchKey);

        // For Linear probing
        while (table[index] != -1){
            if (table[index] == searchKey){
                return true; // element found
            }
            // To move to next slot
            index = (index+1) % size;
        }
        return false;
    }
}


public class Hashing {
    public static void main(String[] args) {
         // Implementing scanner class to get input from the user
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of a hashtable : ");
        int n = input.nextInt(); // size of a hashtable

        // Implementing object for HashtableArr
        HashTableArr ht = new HashTableArr(n);

        // For getting no. of . keys from the user
        System.out.println("Enter the no. of. keys : ");
        int noOfKeys = input.nextInt();

        // Loop to insert a keys
        System.out.println("Enter key elements : ");
        for (int i = 0; i < noOfKeys; i++) {
            int key = input.nextInt();
            ht.InsertKey(key);
        }

        // Implementing search key
        System.out.println("Enter the key element which you want to search : ");
        int searchKey = input.nextInt();
        if (ht.searchKey(searchKey)){
            System.out.println("Your required search key element is : " + searchKey);
        }else {
            System.out.println("Invalid search key element...please enter valid search key element : " + -1);
        }
    }
}

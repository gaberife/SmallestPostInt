import java.io.*;

//TODO: returns the smallest positive integer (greater than 0) that does not occur in A.
class Solution {
    public static int solution(int[] A) {
        int answer = 0, i = 1;
        int[] count = counter(A);
        while(i < count.length) {
            if(count[i] == 0) {
                answer = i;
                break;
            }
            i++;
        }
        return answer;
    }

    public static int[] counter(int[] A){
        int size = largest(A); //Finds largest number in the original array
        int[] count = new int[size]; //Assigns that size to the counter array
        for (int i = 0; i < size; i++)
            if (search(A, i))
                //Parses through array, searching for it and accumulating the number of
                // times that index number shows up in the original array
                count[i]++;
        for (int i = 1; i < size; i++)
            System.out.println(i + " " + count[i]);
        return count;
    }

    public static boolean search(int [ ] numbers, int key) {
        for (int index = 0; index < numbers.length; index++) {
            if ( numbers[index] == key )
            return true;
        }
        return false;
    }


    static int largest(int[] arr){
        int i;
        int max = arr[0];
        for (i = 1; i < arr.length; i++)

            if (arr[i] > max)
                max = arr[i];
        return max + 1; //Accounts for the maximum digit within the counter
    }

    public static void main(String[] args) throws IOException {
        File file = new File("src/test-input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String ch = br.readLine();
        String[] splt = ch.split(", ", 0);
        int size = splt.length;
        int[] array = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = Integer.parseInt(splt[i]);
        System.out.println(solution(array));
    }
}


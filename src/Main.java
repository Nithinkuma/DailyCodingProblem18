/**Given an array of integers and a number k, where 1 <= k <= length of the array,
 compute the maximum values of each subarray of length k.

 For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:

 10 = max(10, 5, 2)
 7 = max(5, 2, 7)
 8 = max(2, 7, 8)
 8 = max(7, 8, 7)
 Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results.
 You can simply print them out as you compute them.**/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String line = br.readLine();
        String[] strs = line.trim().split(" ");

        ArrayList<Integer> list = new ArrayList<>();
        for (String str : strs) {
            list.add(Integer.parseInt(str));
        }

        String k = br.readLine();
        int windowLength = Integer.parseInt(k);

        maxValueOfEachSubArray(list,windowLength);
    }

    private static void maxValueOfEachSubArray(ArrayList<Integer> list,int windowLength) {
        ArrayList<Integer> window = new ArrayList<>(windowLength);
        for(int i=0; i<windowLength;i++)
            window.add(list.get(i));

        if(list.size()>windowLength){
            for(int i=0 ; i<list.size()-windowLength ; i++){
                System.out.println(Collections.max(window));
                window.remove(0);
                window.add(list.get(i+windowLength));
            }
            System.out.println(Collections.max(window));
        }
        else
            System.out.println(Collections.max(list));

    }
}
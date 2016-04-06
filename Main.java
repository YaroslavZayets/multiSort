package multiSort;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        long start = 0;
        long end = 0;
        int[] arr = new int[100];
        Random rnd = new Random();
        for (int i = 0; i<arr.length; i++){
            arr[i]=rnd.nextInt(100);
        }

        MultiThreadSort sort = new MultiThreadSort();

        start = System.currentTimeMillis();
        sort.sort(arr);
        end = System.currentTimeMillis();
        System.out.println((end-start) + "ms двухпоточная сортировка");

        start = System.currentTimeMillis();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        end = System.currentTimeMillis();
        System.out.println((end-start) + "ms сортировка arrays");


    }




}

package multiSort;

import java.util.Arrays;

public class MultiThreadSort {

    public void sort(int[] arr){
        SingleThreadSort th1 = new SingleThreadSort(arr,0,arr.length/2);
        SingleThreadSort th2 = new SingleThreadSort(arr,arr.length/2,arr.length);

        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();

            int[] firstpart = th1.getRes();
            int[] secondpart = th2.getRes();
            int[] rezult = new int [arr.length];

            int indexFirst = 0;
            int indexSecond = 0;
            int index = 0;

            while (indexFirst<firstpart.length && indexSecond<secondpart.length) {
                if (firstpart[indexFirst] < secondpart[indexSecond]) {
                    rezult[index] = firstpart[indexFirst];
                    indexFirst++;
                } else {
                    rezult[index] = secondpart[indexSecond];
                    indexSecond++;
                }
                index++;
            }

            while (indexFirst < indexSecond){
                rezult[index] = firstpart[indexFirst];
                indexFirst++;
                index++;
            }

            while (indexFirst > indexSecond){
                rezult[index] = secondpart[indexSecond];
                indexSecond++;
                index++;
            }

            System.out.println("Массив отсортирован");
            System.out.println(Arrays.toString(rezult));

        } catch (InterruptedException e){
            System.out.println(e);
        }

    }
}

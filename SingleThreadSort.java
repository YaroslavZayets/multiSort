package multiSort;

public class SingleThreadSort extends Thread {
    private int[] arr;
    private int start;
    private int end;
    private int[] copyArr;

    public SingleThreadSort(int[] arr, int start, int end){
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.copyArr = new int[end-start];
        System.arraycopy(arr,start,copyArr,0,copyArr.length);
    }

    public int[] getRes() {
        return copyArr;
    }

    public int partition (int[] arr, int start, int end){
        int marker = start;
        for (int i = start; i<=end; i++){
            if (arr[i]<=arr[end]){
                int temp = arr[marker];
                arr[marker] = arr[i];
                arr[i] = temp;
                marker +=1;
            }
        }
        return marker - 1;
    }

    public void quicksort (int[] arr, int start, int end){
        if (start>=end){
            return;
        }
        int pivot = partition(arr,start,end);
        quicksort(arr,start,pivot-1);
        quicksort(arr,pivot+1,end);
    }

    @Override
    public void run(){
        quicksort(this.copyArr,0,this.copyArr.length-1);
    }


}
